package com.example.demo.components;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.Getter;

import java.util.LinkedList;

public class CodePanel extends VerticalLayout {
    @Getter
    private final Operator operator;
    private final ToolsButton2 toolsButton2;
    //    private final FieldPosition permanentDrop;
    private Span title = new Span();
    //    private FieldPosition before = new FieldPosition(0, this::onAdd);
    private final LinkedList<CodePanel> children = new LinkedList<>();
    private VerticalLayout slot = new VerticalLayout();

    public CodePanel(Operator operator) {
        this.operator = operator;
        children.add(null);

        title.addClassName("h1");
        title.setText(operator.name()); // TODO
        slot.setPadding(false);
//        after.setVisible(false);

//        slot.add(before);
        addChild(0, createCodePanelDropWrapper(null));
//            slot.addComponentAtIndex(0, createCodePanelDropWrapper(0, new CodePanel(null)));

        getElement().getStyle().set("border", "1px solid black");
        toolsButton2 = new ToolsButton2(operator, findAncestor(CodePanelDropWrapper.class));
        add(toolsButton2, slot);
    }

//    public void highlight(Operator operator) {
//        before.addClassName("drop-target");
////        after.addClassName("drop-target");
//        children.forEach(panel -> panel.highlight(operator));
//    }
//
//    public void removeHighlight(FieldPosition fieldPosition) {
//        before.removeClassName("drop-target");
////        after.removeClassName("drop-target");
//        children.forEach(panel -> panel.removeHighlight(fieldPosition));
//    }

    private CodePanelDropWrapper createCodePanelDropWrapper(CodePanel e) {
        CodePanelDropWrapper dropWrapper = new CodePanelDropWrapper(operator -> {
            int dropPanelIndex = children.indexOf(e);
            CodePanel e1 = new CodePanel(operator);
            CodePanelDropWrapper codePanelDropWrapper1 = createCodePanelDropWrapper(e1);
            e1.setDragData(codePanelDropWrapper1);
            addChild(dropPanelIndex + 1, codePanelDropWrapper1);
        }, codePanelWrapper -> {
            int dropPanelIndex = children.indexOf(e);
            addChild(dropPanelIndex + 1, codePanelWrapper);
        }, codePanelWrapper -> {
            children.remove(codePanelWrapper.getCodePanel());
            codePanelWrapper.getElement().removeFromParent();
        });

        if (e != null) {
            dropWrapper.addCodePanel(e);
        }

        return dropWrapper;
    }

    private void addChild(int index, CodePanelDropWrapper codePanelDropWrapper) {
        int oldPanelIndex = children.indexOf(codePanelDropWrapper.getCodePanel());
        if (children.remove(codePanelDropWrapper.getCodePanel())
                && (oldPanelIndex < index)) {
            index--;
        }

        if (codePanelDropWrapper.getParent().isPresent()) {
            codePanelDropWrapper.delete();
        }

        if (index == children.size()) {
            children.addLast(codePanelDropWrapper.getCodePanel());
        } else {
            children.add(index, codePanelDropWrapper.getCodePanel());
        }

        slot.addComponentAtIndex(index, codePanelDropWrapper);

    }

    public void setDragData(CodePanelDropWrapper codePanelDropWrapper) {
        toolsButton2.setDragData(codePanelDropWrapper);
    }

//    private void onDelete(CodePanel codePanel) {
//        // remove afterDrop
//        slot.getComponentAt(codePanel).getElement().removeFromParent();
//        children.remove(codePanel).getElement().removeFromParent();
//    }

//    public void addAfter(Operator operator) {
//        CodePanel e = new CodePanel(operator);
//        children.addLast(e);
//        slot.add(e);
//
//        updateAfterVisibility();
//    }
}

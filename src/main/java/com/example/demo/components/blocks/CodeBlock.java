package com.example.demo.components.blocks;

import com.example.demo.components.CodeBlocksFactory;
import com.example.demo.components.CodePanelDropWrapper;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.LinkedList;

public class CodeBlock extends VerticalLayout {
    private final CodeBlocksFactory codeBlocksFactory;
    protected final VerticalLayout slot = new VerticalLayout();
    protected final Span title = new Span();
    protected final LinkedList<CodeBlock> children = new LinkedList<>();

    public CodeBlock(CodeBlocksFactory codeBlocksFactory) {
        initContent();
        this.codeBlocksFactory = codeBlocksFactory;
    }

    protected void initContent() {
        slot.setPadding(false);
        setPadding(true);
        setSpacing(false);
    }

    protected void addDropSlot() {
        children.add(null);
        addChild(0, createCodePanelDropWrapper(null));
        add(slot);
    }

    protected void setText(String text) {
        title.addClassName("h1");
        title.setText(text);
        addComponentAsFirst(title);
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

    private CodePanelDropWrapper createCodePanelDropWrapper(CodeBlock e) {
        CodePanelDropWrapper dropWrapper = new CodePanelDropWrapper(operator -> {
            int dropPanelIndex = children.indexOf(e);
            CodeBlock e1 = codeBlocksFactory.byOperator(operator);
            CodePanelDropWrapper codePanelDropWrapper1 = createCodePanelDropWrapper(e1);
            addChild(dropPanelIndex + 1, codePanelDropWrapper1);
        }, codePanelWrapper -> {
            int dropPanelIndex = children.indexOf(e);
            addChild(dropPanelIndex + 1, codePanelWrapper);
        }, codePanelWrapper -> {
            children.remove(codePanelWrapper.getCodeBlock());
            codePanelWrapper.getElement().removeFromParent();
        });

        if (e != null) {
            dropWrapper.addCodePanel(e);
        }

        return dropWrapper;
    }

    private void addChild(int index, CodePanelDropWrapper codePanelDropWrapper) {
        int oldPanelIndex = children.indexOf(codePanelDropWrapper.getCodeBlock());
        if (children.remove(codePanelDropWrapper.getCodeBlock())
                && (oldPanelIndex < index)) {
            index--;
        }

        if (codePanelDropWrapper.getParent().isPresent()) {
            codePanelDropWrapper.delete();
        }

        if (index == children.size()) {
            children.addLast(codePanelDropWrapper.getCodeBlock());
        } else {
            children.add(index, codePanelDropWrapper.getCodeBlock());
        }

        slot.addComponentAtIndex(index, codePanelDropWrapper);
    }
}

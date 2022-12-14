package com.example.demo.components;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.LinkedList;

public class CodePanel extends VerticalLayout {

    private Span title = new Span();
    private FieldPosition before = new FieldPosition(0, this::onAdd);
//    private FieldPosition after = new FieldPosition(this::addAfter)
    private LinkedList<CodePanel> children = new LinkedList<>();
    private VerticalLayout slot = new VerticalLayout();

    public CodePanel(Operator operator) {
        title.addClassName("h1");
        title.setText(operator.name()); // TODO
        slot.setPadding(false);
//        after.setVisible(false);

        slot.add(before);
        getElement().getStyle().set("border", "1px solid black");
        add(title, slot);
    }

    public void highlight(Operator operator) {
        before.addClassName("drop-target");
//        after.addClassName("drop-target");
        children.forEach(panel -> panel.highlight(operator));
    }

    public void removeHighlight(FieldPosition fieldPosition) {
        before.removeClassName("drop-target");
//        after.removeClassName("drop-target");
        children.forEach(panel -> panel.removeHighlight(fieldPosition));
    }

    public void onAdd(Integer index, Operator operator) {
        CodePanel e = new CodePanel(operator);
        addChild(index, e);

        updateAfterVisibility();
    }

    private void addChild(int index, CodePanel e) {
        children.add(index, e);
        slot.addComponentAtIndex(index*2+1, e);

        FieldPosition drop = new FieldPosition(index+1, this::onAdd);
        slot.addComponentAtIndex(index*2+2, drop);

    }

    public void addAfter(Operator operator) {
        CodePanel e = new CodePanel(operator);
        children.addLast(e);
        slot.add(e);

        updateAfterVisibility();
    }

    @Deprecated
    private void updateAfterVisibility() {
//        after.setVisible(children.size() > 0);
    }
}

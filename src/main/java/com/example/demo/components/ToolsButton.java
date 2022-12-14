package com.example.demo.components;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dnd.DragSource;
import com.vaadin.flow.component.dnd.EffectAllowed;
import com.vaadin.flow.component.html.Div;

public class ToolsButton extends Button implements DragSource<Button> {

    public ToolsButton(Operator operator) {
        super(operator.name()); // TODO

//        addClassName("player-card");
        setDraggable(true);
        setDragData(operator);
        setEffectAllowed(EffectAllowed.MOVE);
    }
}

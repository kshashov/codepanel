package com.example.demo.components;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dnd.DragSource;
import com.vaadin.flow.component.dnd.EffectAllowed;

public class ToolsButton2 extends Button implements DragSource<ToolsButton2> {



    public ToolsButton2(Operator operator, CodePanel codePanelDropWrapper) {
        super(operator.name()); // TODO

//        addClassName("player-card");
        setDraggable(true);
        setDragData(codePanelDropWrapper);
        setEffectAllowed(EffectAllowed.MOVE);
    }
}

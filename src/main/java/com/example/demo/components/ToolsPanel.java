package com.example.demo.components;

import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.dnd.DragEndEvent;
import com.vaadin.flow.component.dnd.DragStartEvent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import java.util.Arrays;

public class ToolsPanel extends HorizontalLayout {

    public ToolsPanel(ComponentEventListener<DragStartEvent<ToolsButton>> onDragStart, ComponentEventListener<DragEndEvent<ToolsButton>> onDragEnd) {
        Arrays.stream(Operator.values()).forEach(operator -> {
            ToolsButton toolsButton = new ToolsButton(operator);
            add(toolsButton);
            toolsButton.addDragStartListener(onDragStart);
            toolsButton.addDragEndListener(onDragEnd);
        });
    }
}

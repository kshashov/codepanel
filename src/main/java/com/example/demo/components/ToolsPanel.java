package com.example.demo.components;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import java.util.Arrays;

public class ToolsPanel extends HorizontalLayout {

    public ToolsPanel() {
        Arrays.stream(Operator.values()).forEach(operator -> add(new ToolsButton(operator)));
    }
}

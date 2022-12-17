package com.example.demo.components;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dnd.DragSource;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.Getter;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

@Getter
public class CodePanelDropWrapper extends VerticalLayout implements DragSource<CodePanelDropWrapper> {

    private final CodePanel codePanel;
    private final FieldPosition drop;

    public CodePanelDropWrapper(CodePanel codePanel, Consumer<Operator> onAdd, Consumer<CodePanel> onMove) {
        this.codePanel = codePanel;
        this.drop = new FieldPosition(onAdd, onMove);

        if (codePanel != null) {
            add(codePanel);
        }
        add(drop);
    }
}

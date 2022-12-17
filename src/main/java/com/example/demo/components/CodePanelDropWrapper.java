package com.example.demo.components;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.function.Consumer;

@Getter
public class CodePanelDropWrapper extends VerticalLayout {

    private CodePanel codePanel;
    private final FieldPosition drop;
    private final Consumer<CodePanelDropWrapper> onDelete;

    public CodePanelDropWrapper(Consumer<Operator> onAdd, Consumer<CodePanelDropWrapper> onMove, Consumer<CodePanelDropWrapper> onDelete) {
        this.drop = new FieldPosition(onAdd, onMove);
        this.onDelete = onDelete;
        add(drop);
    }

    public void addCodePanel(@NotNull CodePanel codePanel) {
        this.codePanel = codePanel;
        addComponentAsFirst(codePanel);
    }

    public void delete() {
        onDelete.accept(this);
    }
}

package com.example.demo.components;

import com.example.demo.components.blocks.CodeBlock;
import com.example.demo.components.blocks.RootCodeBlock;
import com.vaadin.flow.component.dnd.DragSource;
import com.vaadin.flow.component.dnd.EffectAllowed;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.function.Consumer;

@Getter
public class CodePanelDropWrapper extends VerticalLayout implements DragSource<CodePanelDropWrapper> {

    private final DragPanel dragPanel;
    private final FieldPosition drop;
    private final Consumer<CodePanelDropWrapper> onDelete;
    private final HorizontalLayout content;
    private CodeBlock codeBlock;


    public CodePanelDropWrapper(Consumer<Operator> onAdd, Consumer<CodePanelDropWrapper> onMove, Consumer<CodePanelDropWrapper> onDelete) {
        this.drop = new FieldPosition(onAdd, onMove);
        this.onDelete = onDelete;

        dragPanel = new DragPanel();
        content = new HorizontalLayout();
        content.setPadding(false);
        content.setSpacing(false);
        content.add(dragPanel);

        add(drop);
        setPadding(false);
        initDnD();
    }

    private void initDnD() {
        setDraggable(true);
        setDragData(CodePanelDropWrapper.this);
        setEffectAllowed(EffectAllowed.MOVE);

        addDragStartListener(dragPanelDragStartEvent -> {
            findAncestor(RootCodeBlock.class).highlightDropTarget();
        });

        addDragEndListener(dragPanelDragEndEvent -> {
            findAncestor(RootCodeBlock.class).unhighlightDropTarget();
        });
    }

    public void addCodePanel(@NotNull CodeBlock codeBlock) {
        this.codeBlock = codeBlock;
        content.add(codeBlock);

        addComponentAsFirst(content);
    }

    public void delete() {
        onDelete.accept(this);
    }

    private class DragPanel extends Div {
        public DragPanel() {
            addClassName("drag-source");
        }
    }
}

package com.example.demo.components;

import com.vaadin.flow.component.dnd.DropEffect;
import com.vaadin.flow.component.dnd.DropTarget;
import com.vaadin.flow.component.html.Div;
import lombok.Data;

import java.util.function.Consumer;

@Data
public class FieldPosition extends Div implements DropTarget<Div> {

    private boolean isEmpty = true;

    public FieldPosition(Consumer<Operator> onAdd, Consumer<CodePanelDropWrapper> onMove) {

        addClassName("field-position");
        addClassName("drop-target");

        setActive(true);
        setDropEffect(DropEffect.MOVE);
        addDropListener(event -> {
            event.getDragSourceComponent().ifPresent(component -> {
//                component.setVisible(false);
                Object data = event.getDragData().get();
                if (data instanceof Operator) {
                    setEmpty(false);
                    onAdd.accept((Operator) data);
                } else if (data instanceof CodePanelDropWrapper) {
                    // existing block
                    onMove.accept((CodePanelDropWrapper) data);
                }
//                field.getPositions().forEach(position ->
//                        position.removeClassName("drop-target"));

//                panel.removeHighlight(this);
            });
//            event.getDragData().ifPresent(data -> setText(data.toString()));
        });
    }
}

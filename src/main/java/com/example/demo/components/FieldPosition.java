package com.example.demo.components;

import com.vaadin.flow.component.dnd.DropEffect;
import com.vaadin.flow.component.dnd.DropTarget;
import com.vaadin.flow.component.html.Div;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

@Data
public class FieldPosition extends Div implements DropTarget<Div> {

    private final Integer index;
    private boolean isEmpty = true;

    public FieldPosition(Integer index, BiConsumer<Integer, Operator> onAdd) {
        this.index = index;

        addClassName("field-position");
        addClassName("drop-target");

        setActive(true);
        setDropEffect(DropEffect.MOVE);
        addDropListener(event -> {
            event.getDragSourceComponent().ifPresent(component -> {
//                component.setVisible(false);
                setEmpty(false);
                onAdd.accept(index, Operator.valueOf(((ToolsButton) component).getText()));
//                field.getPositions().forEach(position ->
//                        position.removeClassName("drop-target"));

//                panel.removeHighlight(this);
            });
//            event.getDragData().ifPresent(data -> setText(data.toString()));
        });
    }
}

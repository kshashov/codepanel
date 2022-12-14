package com.example.demo.components;

import com.vaadin.flow.component.html.Div;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FootballField extends Div {

    private final List<FieldPosition> positions = new ArrayList<>();

    public FootballField() {
        addClassName("football-field");
        add(createRow(2), createRow(4),
                createRow(4), createRow(1));
    }

    private Div createRow(int numOfPlayers) {
        Div row = new Div();
        for (int i=0; i<numOfPlayers; i++) {
//            FieldPosition fieldPosition = new FieldPosition(this);
//            row.add(fieldPosition);
//            positions.add(fieldPosition);
        }
        row.addClassName("row");
        return row;
    }
}

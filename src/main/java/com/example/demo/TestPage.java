package com.example.demo;

import com.example.demo.components.*;
import com.example.demo.data.JuventusData;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dnd.DragSource;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Route("/")
@CssImport("./styles/styles.css")
public class TestPage extends VerticalLayout {

    public TestPage() {
        VerticalLayout playersList = new VerticalLayout();
        playersList.setSizeUndefined();
        playersList.addClassName("players-list");

        FootballField footballField = new FootballField();

        JuventusData data = new JuventusData();
        data.getPlayers().forEach(player -> {
            PlayerCard playerCard = new PlayerCard(player);
            playerCard.addDragStartListener(event ->
                    footballField.getPositions().forEach(position -> {
                        if (position.isEmpty()) {
                            position.addClassName("drop-target");
                        }
                    }));
            playersList.add(playerCard);
        });

        add(new ToolsPanel(), new CodePanel(Operator.IF), footballField);

    }
}

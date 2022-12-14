package com.example.demo;

import com.vaadin.componentfactory.selectiongrid.SelectionGrid;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Route("/selection-grid-bug")
public class GridSelectionBugPage extends VerticalLayout {

    public GridSelectionBugPage() {
        List<Integer> items = IntStream.rangeClosed(1, 500).boxed()
                .collect(Collectors.toList());

        SelectionGrid<Integer> grid = new SelectionGrid<>();
        grid.setSelectionMode(Grid.SelectionMode.MULTI);
        grid.addColumn(s -> s);
        grid.setItems(items);

        // We reduce the page size to simplify the example
        grid.getDataCommunicator().setPageSize(10); // 50 by default

        grid.getDataCommunicator().setPagingEnabled(false);

        grid.setSizeFull();
        add(grid);
        setSizeFull();
    }

}

package com.example.demo;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dnd.DragSource;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;

import java.time.LocalDate;

@Route("/sdf")
public class TestPage1 extends VerticalLayout {

    public TestPage1() {

        Bean bean = new Bean();

        DatePicker datePicker = new DatePicker();
        datePicker.setAutoOpen(false);

        Binder<Bean> binder = new Binder<>(Bean.class);
        binder.forField(datePicker)
                .asRequired("Empty")
                .bind("date");

        binder.readBean(bean);

        Button save = new Button("Save", event -> {
            if (binder.writeBeanIfValid(bean)) {
                Notification.show(bean.toString());
            }
        });

        Div box1 = new Div(new Span("1"));
        Div box2 = new Div(new Span("2"));
        DragSource<Div> box1DragSource = DragSource.create(box1);
        DragSource<Div> box2DragSource = DragSource.configure(box2);
        box2DragSource.setDraggable(true);

        add(datePicker, save, box1, box2);

    }


    public static class Bean {
        LocalDate date;

        public LocalDate getDate() {
            return date;
        }

        public void setDate(LocalDate date) {
            this.date = date;
        }

        @Override
        public String toString() {
            return "Bean{" +
                    "date=" + date +
                    '}';
        }
    }
}

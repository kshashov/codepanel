package com.example.demo;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;

import java.time.LocalDate;

@Route("/binder")
public class TestPage2 extends VerticalLayout {

    public TestPage2() {

        Binder<Bean> binder = new Binder<>(Bean.class);

        Bean person = new Bean(0, 0);
        binder.setBean(person);

        IntegerField value1 = new IntegerField();
        IntegerField value2 = new IntegerField();

        binder.forField(value1)
                .withValidator(integer -> integer > 0, "should be less than 0")
                .bind("value1");

        binder.forField(value2)
                .bind("value2");

        add(value1, value2, new Button("print", buttonClickEvent -> Notification.show(person.toString())));
    }


    public static class Bean {
        Integer value1;
        Integer value2;

        public Bean(Integer value1, Integer value2) {
            this.value1 = value1;
            this.value2 = value2;
        }

        public Integer getValue1() {
            return value1;
        }

        public void setValue1(Integer value1) {
            this.value1 = value1;
        }

        public Integer getValue2() {
            return value2;
        }

        public void setValue2(Integer value2) {
            this.value2 = value2;
        }

        @Override
        public String toString() {
            return "Bean{" +
                    "value1=" + value1 +
                    ", value2=" + value2 +
                    '}';
        }
    }
}

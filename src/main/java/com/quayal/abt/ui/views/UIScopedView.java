package com.quayal.abt.ui.views;

import com.quayal.abt.ui.Greeter;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

@UIScope
@SpringView(name = UIScopedView.VIEW_NAME)
public class UIScopedView extends VerticalLayout implements View {
    public static final String VIEW_NAME = "UI";

    @Autowired
    Greeter greeter;

    @PostConstruct
    void init () {
        addComponent(new Label("This is a UI scoped view. Greeter says: " + greeter.sayHello()));
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event){

    }
}

package com.quayal.abt.ui.views;

import com.quayal.abt.ui.Greeter;
import com.quayal.abt.ui.ViewGreeter;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

@SpringView(name = ScopedView.VIEW_NAME)
public class ScopedView extends VerticalLayout implements View {
    public static final String VIEW_NAME = "VIEW";

    @Autowired
    ViewGreeter viewGreeter;

    @Autowired
    Greeter uiGreeter;

    @PostConstruct
    public void init(){
        addComponent(new Label("This is a scoped view"));
        addComponent(new Label(uiGreeter.sayHello()));
        addComponent(new Label(viewGreeter.sayHello()));
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event){

    }
}

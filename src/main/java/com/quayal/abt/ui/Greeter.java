package com.quayal.abt.ui;

import com.vaadin.spring.annotation.SpringComponent;

@SpringComponent
public class Greeter {

    public String sayHello() {
        return "Hello from Greeter: " + toString();
    }
}

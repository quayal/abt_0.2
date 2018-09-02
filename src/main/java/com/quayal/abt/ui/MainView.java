package com.quayal.abt.ui;

import com.quayal.abt.beans.CourseBean;
import com.quayal.abt.services.CourseService;
import com.quayal.abt.services.TrainerService;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@HtmlImport("styles/shared-styles.html")
@Route("app")
public class MainView extends VerticalLayout {

    private CourseService courseService;
    private TrainerService trainerService;
    private Grid<CourseBean> courseGrid = new Grid<>();
    private CourseForm courseForm = new CourseForm(this);


    public MainView() {
        courseService = CourseService.getInstance();
        trainerService = TrainerService.getInstance();
        courseGrid.setSizeFull();
        courseGrid.addColumn(CourseBean::getCourseName).setHeader("Course name");
        HorizontalLayout main = new HorizontalLayout(courseGrid, courseForm);
        main.setAlignItems(Alignment.START);
        main.setSizeFull();
        setHeight("100vh");
        updateCourses();
        add(main);
    }

    private void updateCourses() {
        courseGrid.setItems(courseService.getCourses());
    }
}




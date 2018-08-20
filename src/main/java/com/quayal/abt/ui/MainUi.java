package com.quayal.abt.ui;

import com.quayal.abt.beans.CourseBean;
import com.quayal.abt.services.CourseService;
import com.quayal.abt.services.TrainerService;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;

@Theme("valo")
@SpringUI(path = "/app")
public class MainUi extends UI {

    private CourseService courseService;
    private TrainerService trainerService;
    private HorizontalSplitPanel rootSplitPanel = new HorizontalSplitPanel();
    Grid<CourseBean> courseGrid = new Grid<>();
    CourseForm courseForm;


    @Autowired
    public MainUi(CourseService courseService, TrainerService trainerService) {
        this.courseService = courseService;
        this.trainerService = trainerService;
        courseForm = new CourseForm(trainerService.getAllTrainers(), trainerService.getAllTrainers(), this, courseService);
    }

    @Override
    public void init(VaadinRequest request) {
        rootSplitPanel.setSizeFull();
        courseGrid.setSizeFull();
        courseForm.setSizeFull();
        courseGrid.addColumn(CourseBean::getCourseName).setCaption("Course name");
        rootSplitPanel.setFirstComponent(courseGrid);
        rootSplitPanel.setSecondComponent(courseForm);
        courseGrid.setItems(courseService.getCourses());
        setContent(rootSplitPanel);
        courseGrid.asSingleSelect().addValueChangeListener(event ->
            courseForm.populateForm(event.getValue()));

    }
//
//    private Button createNavigationButton(String caption, final String viewName) {
//        Button button = new Button(caption);
//        button.addStyleName(ValoTheme.BUTTON_SMALL);
//        button.addClickListener(event -> getUI().getNavigator().navigateTo(viewName));
//        return button;
//    }

}

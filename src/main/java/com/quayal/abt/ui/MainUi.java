package com.quayal.abt.ui;

import com.quayal.abt.beans.CourseBean;
import com.quayal.abt.services.CourseService;
import com.quayal.abt.ui.views.ScopedView;
import com.quayal.abt.ui.views.UIScopedView;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.jooq.generated.abt.tables.Course;
import org.springframework.beans.factory.annotation.Autowired;

@Theme("valo")
@SpringUI(path = "/app")
@SpringViewDisplay
public class MainUi extends UI implements ViewDisplay {

    private CourseService courseService;
    private Panel springViewDisplay;
    private HorizontalSplitPanel rootSplitPanel = new HorizontalSplitPanel();
    Grid<CourseBean> courseGrid = new Grid<>();
    CourseForm courseForm = new CourseForm();


    @Autowired
    public MainUi(CourseService courseService) {
        this.courseService = courseService;
    }

    @Override
    public void init(VaadinRequest request) {

        rootSplitPanel.setSizeFull();
        courseGrid.setSizeFull();
        courseGrid.addColumn(CourseBean::getCourseName);
        rootSplitPanel.setFirstComponent(courseGrid);
        rootSplitPanel.setSecondComponent(courseForm);
        courseGrid.setItems(courseService.getCourses());
        setContent(rootSplitPanel);
        courseGrid.asSingleSelect().addValueChangeListener(event -> courseForm.populateForm(event.getValue()));


//        final VerticalLayout rootLayout = new VerticalLayout();
//        rootLayout.setSizeFull();
//        setContent(rootLayout);
//
//        final CssLayout navigationBar = new CssLayout();
//        navigationBar.addStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
//        navigationBar.addComponent(createNavigationButton("View Scoped View", ScopedView.VIEW_NAME));
//        navigationBar.addComponent(createNavigationButton("UI scoped view", UIScopedView.VIEW_NAME));
//        rootLayout.addComponent(navigationBar);
//
//        springViewDisplay = new Panel();
//        springViewDisplay.setSizeFull();
//        rootLayout.addComponent(springViewDisplay);
//        courseGrid.setItems(courseService.getCourses());
//        courseGrid.setSizeFull();
//        rootLayout.addComponent(courseGrid);

    }

    private Button createNavigationButton(String caption, final String viewName) {
        Button button = new Button(caption);
        button.addStyleName(ValoTheme.BUTTON_SMALL);
        button.addClickListener(event -> getUI().getNavigator().navigateTo(viewName));
        return button;
    }

    @Override
    public void showView(View view){
        //springViewDisplay.setContent((Component) view);
    }
}

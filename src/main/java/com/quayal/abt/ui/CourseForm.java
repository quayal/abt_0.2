package com.quayal.abt.ui;

import com.quayal.abt.beans.CourseBean;
import com.vaadin.data.Binder;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.TextField;

public class CourseForm extends FormLayout {

    private CourseBean courseBean;

    private TextField courseName = new TextField("Course name");
    private TextField courseCode = new TextField("Course code");
    private TextField trainer = new TextField("Trainer");
    private TextField facilitator = new TextField("Facilitator");
    private DateField dayOne = new DateField("Day one");
    private DateField dayTwo = new DateField("Day two");

    private Binder<CourseBean> courseBeanBinder = new Binder<>(CourseBean.class);

    public CourseForm() {
        courseBeanBinder.bindInstanceFields(this);
        addComponents(courseName, courseCode, trainer, facilitator, dayOne, dayTwo);
        setSizeUndefined();
        setVisible(true);
    }

    public void populateForm(CourseBean courseBean) {
        this.courseBean = courseBean;
        courseBeanBinder.setBean(courseBean);
    }
}

package com.quayal.abt.ui;

import com.quayal.abt.beans.CourseBean;
import com.quayal.abt.beans.TrainerBean;
import com.quayal.abt.services.CourseService;
import com.quayal.abt.services.TrainerService;
import com.vaadin.data.Binder;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

class CourseForm extends FormLayout {

    private CourseBean courseBean;
    private CourseService courseService;
    TextField courseName = new TextField("Course name");
    TextField courseCode = new TextField("Course code");
    ComboBox<TrainerBean > trainer = new ComboBox<>("Trainer");
    ComboBox<TrainerBean > facilitator = new ComboBox<>("Facilitator");
    DateField dayOne = new DateField("Day one");
    DateField dayTwo = new DateField("Day two");


    private Binder<CourseBean> courseBeanBinder = new Binder<>(CourseBean.class);

    CourseForm(List<TrainerBean> trainers, List<TrainerBean> facilitators, UI ui, CourseService courseService){
        this.courseService = courseService;
        dayOne.setDateFormat("dd-MM-yyyy");
        dayTwo.setDateFormat("dd-MM-yyyy");
        trainer.setItems(trainers);
        trainer.setItemCaptionGenerator(TrainerBean::getFullName);
        facilitator.setItems(facilitators);
        facilitator.setItemCaptionGenerator(TrainerBean::getFullName);
        courseBeanBinder.bindInstanceFields(this);
        Button saveButton = new Button("Save");
        saveButton.addClickListener(event -> save(courseBean));
        saveButton.setEnabled(true);
        addComponents(courseName, courseCode, trainer, facilitator, dayOne, dayTwo, saveButton);
        setSizeFull();
        setVisible(true);

    }

    void populateForm(CourseBean courseBean) {
        this.courseBean = courseBean;
        courseBeanBinder.setBean(courseBean);
    }
    void setCourseBean(CourseBean courseBean) {
        this.courseBean = courseBean;
    }

    void save(CourseBean courseBean){
        courseService.save(courseBean);
    }
}

package com.quayal.abt.ui;

import com.quayal.abt.beans.CourseBean;
import com.quayal.abt.beans.TrainerBean;
import com.quayal.abt.services.CourseService;
import com.quayal.abt.services.TrainerService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

import java.util.List;

class CourseForm extends FormLayout {

    private MainView mainView;
    private CourseBean courseBean;
    private CourseService courseService;
    private TextField courseName = new TextField("Course name");
    private TextField courseCode = new TextField("Course code");
    private ComboBox<TrainerBean > trainer = new ComboBox<>("Trainer");
    private ComboBox<TrainerBean > facilitator = new ComboBox<>("Facilitator");
    private DatePicker dayOne = new DatePicker("Day one");
    private DatePicker dayTwo = new DatePicker("Day two");
    private Button saveButton = new Button("Save");
    private Button delete = new Button("Delete");


    private Binder<CourseBean> courseBeanBinder = new Binder<>(CourseBean.class);

    CourseForm(MainView mainView){
        TrainerService trainerService = TrainerService.getInstance();
        List<TrainerBean> trainers = trainerService.getAllTrainers();
        List<TrainerBean> facilitators = trainerService.getAllTrainers();

        this.mainView = mainView;
        trainer.setItems(trainers);
        trainer.setItemLabelGenerator(TrainerBean::getFullName);
        facilitator.setItems(facilitators);
        facilitator.setItemLabelGenerator(TrainerBean::getFullName);
        courseBeanBinder.bindInstanceFields(this);
        saveButton.addClickListener(event -> save(courseBean));
        saveButton.setEnabled(true);
        add(courseName, courseCode, trainer, facilitator, dayOne, dayTwo, saveButton);
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

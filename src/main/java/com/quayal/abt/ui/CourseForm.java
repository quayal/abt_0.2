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
    private TrainerService trainerService;
    private TextField courseName = new TextField("Course name");
    private TextField courseCode = new TextField("Course code");
    ComboBox<TrainerBean> trainerBox = new ComboBox<>("Trainer");
    ComboBox<TrainerBean> facilitatorBox = new ComboBox<>("Facilitator");
    List<TrainerBean> trainers;
    List<TrainerBean> facilitators;
    private DatePicker dayOne = new DatePicker("Day one");
    private DatePicker dayTwo = new DatePicker("Day two");
    private Button saveButton = new Button("Save");
    private Button delete = new Button("Delete");


    private Binder<CourseBean> courseBeanBinder = new Binder<>(CourseBean.class);

    CourseForm(MainView mainView, TrainerService trainerService, CourseService courseService){
        this.trainerService = trainerService;
        this.courseService = courseService;
        trainers = trainerService.getAllTrainers();
        facilitators = trainerService.getAllTrainers();

        this.mainView = mainView;

        trainerBox.setItems(trainers);
        trainerBox.setItemLabelGenerator(TrainerBean::getFullName);
        facilitatorBox.setItems(facilitators);
        facilitatorBox.setItemLabelGenerator(TrainerBean::getFullName);
        courseBeanBinder.bindInstanceFields(this);
        saveButton.addClickListener(event -> save(courseBean));
        add(courseName, courseCode, trainerBox, facilitatorBox, dayOne, dayTwo, saveButton);
        setSizeFull();
        setVisible(true);


    }

    void populateForm(CourseBean courseBean) {
        this.courseBean = courseBean;
        courseBeanBinder.setBean(courseBean);
        trainerBox.setValue(trainers.stream()
                .filter(trainerBean -> trainerBean.getId() == courseBean.getTrainer().getId())
                .findFirst().get());
        if (courseBean.getFacilitator() != null) {
            facilitatorBox.setValue(facilitators.stream()
                    .filter(facilitatorBean -> facilitatorBean.getId() == courseBean.getFacilitator().getId())
                    .findFirst().get());
        }

        saveButton.setEnabled(true);
    }
    void setCourseBean(CourseBean courseBean) {
        this.courseBean = courseBean;
    }

    void save(CourseBean courseBean){
        courseService.save(courseBean);
    }
}

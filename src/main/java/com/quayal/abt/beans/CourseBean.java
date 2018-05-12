package com.quayal.abt.beans;

import org.jooq.types.UInteger;

import java.time.LocalDate;

public class CourseBean {

    private UInteger id;
    private String courseName;
    private String courseCode;
    private int companyId;
    private LocalDate dayOne;
    private LocalDate dayTwo;
    private LocalDate closingDate;
    private LocalDate closed;
    private String trainer;
    private String facilitator;
    private int contactId;
    private int projectManager;
    private String courseEmail;
    private double courseAverage;
    private double trainerAverage;
    private double facilitatorAverage;

    public CourseBean() {
    }


    public UInteger getId() {
        return id;
    }

    public void setId(UInteger id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public LocalDate getDayOne() {
        return dayOne;
    }

    public void setDayOne(LocalDate dayOne) {
        this.dayOne = dayOne;
    }

    public LocalDate getDayTwo() {
        return dayTwo;
    }

    public void setDayTwo(LocalDate dayTwo) {
        this.dayTwo = dayTwo;
    }

    public LocalDate getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(LocalDate closingDate) {
        this.closingDate = closingDate;
    }

    public LocalDate getClosed() {
        return closed;
    }

    public void setClosed(LocalDate closed) {
        this.closed = closed;
    }

    public String getTrainer() {
        return trainer;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    public String getFacilitator() {
        return facilitator;
    }

    public void setFacilitator(String facilitator) {
        this.facilitator = facilitator;
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public int getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(int projectManager) {
        this.projectManager = projectManager;
    }

    public String getCourseEmail() {
        return courseEmail;
    }

    public void setCourseEmail(String courseEmail) {
        this.courseEmail = courseEmail;
    }

    public double getCourseAverage() {
        return courseAverage;
    }

    public void setCourseAverage(double courseAverage) {
        this.courseAverage = courseAverage;
    }

    public double getTrainerAverage() {
        return trainerAverage;
    }

    public void setTrainerAverage(double trainerAverage) {
        this.trainerAverage = trainerAverage;
    }

    public double getFacilitatorAverage() {
        return facilitatorAverage;
    }

    public void setFacilitatorAverage(double facilitatorAverage) {
        this.facilitatorAverage = facilitatorAverage;
    }
}

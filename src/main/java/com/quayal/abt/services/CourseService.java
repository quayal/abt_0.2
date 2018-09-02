package com.quayal.abt.services;

import com.quayal.abt.beans.CourseBean;
import com.quayal.abt.beans.TrainerBean;
import com.quayal.abt.data.access.ConnectionProvider;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import static org.jooq.generated.abt.Tables.COURSE;
import static org.jooq.generated.abt.Tables.TRAINER;

@Service
public class CourseService {

    private final DSLContext create;
    private final TrainerService trainerService;

    public CourseService() {
        create = DSL.using(ConnectionProvider.getConnection(), SQLDialect.MYSQL_8_0);
        trainerService = TrainerService.getInstance();
    }

    public List<CourseBean> getCourses() {
        Map<Integer, TrainerBean> courseTrainer =
                create.select(COURSE.ID, TRAINER.ID, TRAINER.FIRST_NAME, TRAINER.LAST_NAME, TRAINER.PHONE, TRAINER.EMAIL)
                        .from(COURSE)
                        .join(TRAINER)
                        .on(COURSE.TRAINER.eq(TRAINER.ID))
                        .fetchMap(COURSE.ID, TrainerBean.class);
        Map<Integer, TrainerBean> courseFacilitator =
                create.select(COURSE.ID, TRAINER.ID, TRAINER.FIRST_NAME, TRAINER.LAST_NAME, TRAINER.PHONE, TRAINER.EMAIL)
                        .from(COURSE)
                        .join(TRAINER)
                        .on(COURSE.FACILITATOR.eq(TRAINER.ID))
                        .fetchMap(COURSE.ID, TrainerBean.class);
        List<CourseBean> courses =
                create.select(COURSE.ID, COURSE.COURSE_NAME, COURSE.COURSE_CODE, COURSE.DAY_ONE, COURSE.DAY_TWO)
                        .from(COURSE)
                        .fetchInto(CourseBean.class);
        courses.forEach(courseBean -> courseBean.setTrainer(courseTrainer.get(courseBean.getId())));
        courses.forEach(courseBean -> courseBean.setFacilitator(courseFacilitator.get(courseBean.getId())));
        return courses;
    }

    public void save(CourseBean courseBean) {
        create.update(COURSE)
                .set(COURSE.COURSE_CODE, courseBean.getCourseCode())
                .set(COURSE.COURSE_NAME, courseBean.getCourseName())
                .set(COURSE.DAY_ONE, Date.valueOf(courseBean.getDayOne()))
                .set(COURSE.DAY_TWO, Date.valueOf(courseBean.getDayTwo()))
                .set(COURSE.TRAINER, courseBean.getTrainer().getId())
                .set(COURSE.FACILITATOR, courseBean.getFacilitator() != null ? courseBean.getFacilitator().getId() : null)
//                .set(COURSE.CLOSING_DATE, Date.valueOf(courseBean.getClosingDate()))
//                .set(COURSE.CLOSED, Date.valueOf(courseBean.getClosed()))
                .where(COURSE.ID.eq(courseBean.getId())).execute();
    }

    public static CourseService getInstance(){
        return new CourseService();
    }
}


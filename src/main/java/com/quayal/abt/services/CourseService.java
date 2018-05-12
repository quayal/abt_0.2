package com.quayal.abt.services;

import com.quayal.abt.beans.CourseBean;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.jooq.generated.abt.Tables.COURSE;
import static org.jooq.generated.abt.Tables.TRAINER;

@Service
public class CourseService {

    private final DSLContext create;

    @Autowired
    public CourseService(DSLContext dslContext){
        this.create = dslContext;
    }

    public List<CourseBean> getCourses() {
        Short facilitator = 1;
        return create.select(COURSE.COURSE_NAME, COURSE.COURSE_CODE, TRAINER.LAST_NAME.as("Trainer"), TRAINER.LAST_NAME.as("Facilitator"), COURSE.DAY_ONE, COURSE.DAY_TWO)
        .from(COURSE).join(TRAINER).on(COURSE.FACILITATOR.eq(TRAINER.ID)).where(COURSE.FACILITATOR.eq(facilitator)).fetchInto(CourseBean.class);
    }
}

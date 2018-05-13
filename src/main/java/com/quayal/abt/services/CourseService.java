package com.quayal.abt.services;

import com.quayal.abt.beans.CourseBean;
import org.jooq.DSLContext;
import org.jooq.generated.abt.tables.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.jooq.generated.abt.Tables.COURSE;

@Service
public class CourseService {

    private final DSLContext create;

    @Autowired
    public CourseService(DSLContext dslContext){
        this.create = dslContext;
    }

    public List<CourseBean> getCourses() {
        Trainer t = Trainer.TRAINER.as("t");
        Trainer f = Trainer.TRAINER.as("f");
        Short facilitator = 1;
        return create.select(COURSE.ID, COURSE.COURSE_NAME, COURSE.COURSE_CODE, t.LAST_NAME.as("trainer"),
                f.LAST_NAME.as("facilitator"), COURSE.DAY_ONE, COURSE.DAY_TWO)
                .from(COURSE).join(t).on(COURSE.TRAINER.eq(t.ID)).join(f)
                .on(COURSE.FACILITATOR.eq(f.ID)).where(COURSE.FACILITATOR.eq(facilitator))
                .fetchInto(CourseBean.class);
    }
}

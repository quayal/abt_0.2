package com.quayal.abt.services;

import com.quayal.abt.beans.TrainerBean;
import com.quayal.abt.data.access.ConnectionProvider;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.jooq.generated.abt.Tables.TRAINER;
import static org.jooq.impl.DSL.concat;
import static org.jooq.impl.DSL.val;

@Service
public class TrainerService {

    DSLContext create;

    private TrainerService() {
        create = DSL.using(ConnectionProvider.getConnection(), SQLDialect.MYSQL_8_0);
    }

    public TrainerBean getTrainerBeanById(short trainerId) {
        return create.select(TRAINER.ID, TRAINER.FIRST_NAME, TRAINER.LAST_NAME, TRAINER.EMAIL, TRAINER.PHONE).from(TRAINER).where(TRAINER.ID.eq(trainerId)).fetchOne().into(TrainerBean.class);
    }

    public List<String> getFullNames() {
        return create.select(concat((TRAINER.FIRST_NAME), val(" "), (TRAINER.LAST_NAME))).from(TRAINER).fetchInto(String.class);
    }

    public List<TrainerBean> getAllTrainers() {
        return create.select().from(TRAINER).fetchInto(TrainerBean.class);
    }


    public static TrainerService getInstance(){
        return new TrainerService();
    }

    }

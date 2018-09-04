package com.quayal.abt.data.access;


import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JooqConnector {

    private final DSLContext create;

    @Autowired
    public JooqConnector(DSLContext create){
        this.create = create;
    }

    public DSLContext getCreate(){
        return create;
    }

}

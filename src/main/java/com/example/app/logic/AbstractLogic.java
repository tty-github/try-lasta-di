package com.example.app.logic;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.db.exbhv.MemberBhv;

public abstract class AbstractLogic {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    protected MemberBhv bhv;
}

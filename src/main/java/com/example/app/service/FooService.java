package com.example.app.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.app.logic.BarLogic;
import com.example.app.logic.subpkg.BazLogic;

public class FooService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    protected BarLogic barLogic;

    @Resource
    protected BazLogic bazLogic;

    public void exec() {
        log.info("FooService.exec()");
        barLogic.selectList();
        bazLogic.doLogic();
    }

}

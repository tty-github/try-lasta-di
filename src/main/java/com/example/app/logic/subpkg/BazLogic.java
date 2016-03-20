package com.example.app.logic.subpkg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BazLogic {
    private final Logger log = LoggerFactory.getLogger(getClass());

    public void doLogic() {
        log.info("doLogic");
    }
}

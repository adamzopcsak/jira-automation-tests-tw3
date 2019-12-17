package com.codecool.harmadikhet.tests.BDDTest;

import com.codecool.harmadikhet.tests.BaseTest;

public abstract class BaseStepdefs {

    protected BaseTest baseTest;

    protected void initObjectsForBDD() {
        baseTest = new BaseTest();
        baseTest.initDriver();
        baseTest.setupTestEnvironment();
    }

}

package com.codecool.harmadikhet.tests.BDDTest;

import com.codecool.harmadikhet.tests.BaseTest;

abstract class BaseStepdefs {

    BaseTest baseTest;

    void initObjectsForBDD() {
        baseTest = new BaseTest();
        baseTest.initDriver();
        baseTest.setupTestEnvironment();
    }

}

package com.example.SBNZ;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CEPTest.class, DietTest.class, QueryTest.class, TrainingTest.class
})
public class SuiteAll {
}

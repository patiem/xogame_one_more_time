package app;

import org.apache.commons.io.input.ReversedLinesFileReader;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;


import static org.testng.Assert.*;

public class AppTest extends DataProviderForApp {

    @BeforeSuite
    public void printBeforMessage() {
        System.out.println("Tests will take a while because there will be almost 1800 scenarios generated" +
                " and tested end to end. Please be patient");
    }


    @Test
    public void wholeGameTest() throws IOException {

        //given
        String file = "src/test/scenarios/game1.txt";
        String print = "FL";
        String language = "EN";
        String[] args = {print, language, file};
        String lastLine = "XXXXXXXXXXXXXXXXXXXX";
        //when
        App.main(args);
        ReversedLinesFileReader fr = new ReversedLinesFileReader(new File("result.txt"));

        //then
        assertEquals(fr.readLine(), lastLine);
    }

    @Test(dataProvider = "scenarios")
    public void wholeGameTestWithRandomScenarios(String testName, String resultName) throws IOException {

        //given
        String print = "FL";
        String language = "PL";
        String[] args = {print, language, testName, resultName};
        //when
        App.main(args);
        ReversedLinesFileReader fr = new ReversedLinesFileReader(new File(resultName));

        //then
        //assertEquals(fr.readLine(), lastLine);
    }

    @AfterSuite
    public void printMessage() {
        System.out.println("All scenarios for e2e tests are generated for various combinations of horizontal, vertical and winning" +
                "condition - from 3-19 for every argument. Some games will not have winner because they will be exit before end of game" +
                "(in situation when random numbers will repeat to much and not enough numbers will be generated.\n" +
                "Results are stored in <working_directory>/src/test/results .\n" +
                "Generated scenarios are stored in <working_directory>/src/test/results");
    }



}
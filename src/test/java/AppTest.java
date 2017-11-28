import org.apache.commons.io.input.ReversedLinesFileReader;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


import static org.testng.Assert.*;

public class AppTest {
    @Test
    public void wholeGameTest() throws IOException {

        //given
        String file = "game1.txt";
        String print = "FL";
        String[] args = {print, file};
        String lastLine = "XXXXXXXXXXXXXXXXXXXX";
        //when
        App.main(args);
        ReversedLinesFileReader fr = new ReversedLinesFileReader(new File("result.txt"));

        //then
        assertEquals(fr.readLine(), lastLine);
    }

}
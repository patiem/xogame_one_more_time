package utility.scanning;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ScannMenagerTest {

    @Test
    public void isScanningFromTerminal() {

        //given
        assertEquals(ScannMenager.getScanner().getClass(), TScanner.class);
    }

}
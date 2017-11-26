package utility.printing;

import org.testng.annotations.Test;
import utility.printing.ErrorPrinter;
import utility.printing.PrintManager;
import utility.printing.TerminalPrinter;

import static org.testng.Assert.*;

public class PrintManagerTest {


    @Test
    public void defaultPrinterIsTerminal() {

        //given //when
        PrintManager.setPrinterBuilderToDefault();
        assertEquals(PrintManager.getPrinter().getClass(), TerminalPrinter.class);
    }

    @Test
    public void ifUserGetsWrong_printerIsTerminal() {

        //given //when
        PrintManager.setPrinter("dr");
        assertEquals(PrintManager.getPrinter().getClass(), TerminalPrinter.class);
    }

    @Test
    public void ifUserGetsER_printerIsError() {

        //given //when
        PrintManager.setPrinter("ER");
        assertEquals(PrintManager.getPrinter().getClass(), ErrorPrinter.class);
    }

    @Test
    public void ifUserGetsTR_printerIsTerminal() {

        //given //when
        PrintManager.setPrinter("TR");
        assertEquals(PrintManager.getPrinter().getClass(), TerminalPrinter.class);
    }


}

//TODO: how to test static fields if i cannot set it do null
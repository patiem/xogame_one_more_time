package app;

import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.List;

public class DataProviderForApp {

    @DataProvider(name = "scenarios")
    public static Object[][] scenarios() throws IOException {

        List<String> prefixes = Generator.generate();
        Object[][] files = new Object[prefixes.size()][];
        String testName = "src/test/scenarios/test_";
        String resultName = "src/test/results/result_";
        int n = 0;

        for(String pref: prefixes) {
            Object[] pair = {testName+pref, resultName+pref};
            files[n++] = pair;
        }
        return files;
    }
}

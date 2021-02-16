package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks
{
    @Before
    public void setup() throws Exception{
        try {

        }
        catch (Exception e) {
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @After
    public void teardown() {

    }
}

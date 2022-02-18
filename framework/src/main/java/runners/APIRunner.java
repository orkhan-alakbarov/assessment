package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/java/Features/Pet.feature",
        glue={"src/main/java/Steps"},
        dryRun = false,
        monochrome = true,
        tags = "@pet",
        plugin = { "pretty" }
)
public class APIRunner {

}
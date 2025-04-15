package CustomerPackage;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/resources/Uses_Cases/Customer.feature",
        glue = {"CustomerPackage"},
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true
)


public class TestRunner {
}

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {"src/test/java/features"},
        glue = {"steps"},
        plugin = {"http:target/cucumber-html-report"}
)
public class RunnerTest extends AbstractTestNGCucumberTests {
}

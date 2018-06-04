import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {"src/test/java/features"},
        glue = {"steps"},
        dryRun = false,
        strict = false
)
public class RunnerTest extends AbstractTestNGCucumberTests {
}

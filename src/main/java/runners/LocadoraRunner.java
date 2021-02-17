package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/features/AlugarFilme.feature",
        glue = "",
        tags = ("not @ignore"),
        plugin = {"pretty", "html:target/report-tests.html"},
        snippets = CucumberOptions.SnippetType.CAMELCASE

)
public class LocadoraRunner {

}

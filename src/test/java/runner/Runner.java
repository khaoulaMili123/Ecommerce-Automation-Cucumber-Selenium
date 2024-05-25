package runner;
import org.junit.runner.RunWith;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith (Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/TotalPrice.feature",
		glue = {"stepdefinitions","hooks"},
		//publish = false,
	//	monochrome = true,
		//tags = "@tag1",
		plugin = {"pretty", "html:target\\cucumber\\report.html"
}
		)

public class Runner {

}

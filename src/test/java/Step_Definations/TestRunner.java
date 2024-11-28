package Step_Definations;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features", // Path to feature files
    glue = "Step_Definations",                // Package for step definitions
    plugin = {"pretty", "html:target/cucumber-reports.html"}, // Reporting
    monochrome = true                         // Clean console output
)
public class TestRunner {
    public static void main(String[] args) {
        System.out.println("Starting TestRunner...");
        io.cucumber.core.cli.Main.main(args); // This explicitly runs the Cucumber tests
        System.out.println("TestRunner finished!");
    }
}

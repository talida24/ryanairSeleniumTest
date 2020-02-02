package Cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import java.util.stream.Stream;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/Cucumber/RyanairTesting.feature"}, glue =  "Cucumber")
public final class Runner {

    private static String[] defaultOptions = {
            "--glue", "Cucumber",
            "--plugin", "pretty",
            "--plugin", "json:cucumber.json",
    };

    public static void main(String[] args) throws Throwable {
        Stream<String> cucumberOptions = Stream.concat(Stream.of(defaultOptions), Stream.of(args));
        cucumber.api.cli.Main.main(cucumberOptions.toArray(String[]::new));
    }
}
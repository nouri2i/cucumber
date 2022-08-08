package com.testing2i;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.Map;
//import com.testing2i.Hooks.*;
import static org.hamcrest.CoreMatchers.containsString;


public class StepDefinitions {
    private static WebDriver driver;

    public StepDefinitions() {
      driver = Hooks.getDriver();

    }

    @Given("^(?i)I am on the (?-i)Google homepage$")
    @Given("I am on Google")
    public void i_am_on_the_google_homepage() {

        driver.get("https://www.google.co.uk");
        driver.findElement(By.cssSelector("#L2AGLb > div")).click();

    }

    @Then("I search for \"([^\"]*)\"$")
    @When("I search for {string}")
    public void i_search_for(String searchText) throws InterruptedException {
        driver.findElement(By.cssSelector(".a4bIc > input[role='combobox']")).sendKeys(searchText+ Keys.ENTER);
        Thread.sleep(1000);
    }
//    @When("I search for \"([^\"]*)\"$")
//    public void blah(String searchText) throws InterruptedException {
//
//    }
    @Then("{string} appears in the results")
    public void appears_in_the_results(String searchResult) {
        String searchResults= driver.findElement(By.cssSelector("#rso")).getText();
       MatcherAssert.assertThat(searchResults,containsString(searchResult));

    }
    @Then("I see in the results")
    public void i_see_in_the_results(io.cucumber.datatable.DataTable dataTable) {

        String searchResults= driver.findElement(By.cssSelector("#rso")).getText();
       List<Map<String,String>> rows= dataTable.asMaps();
       for( var row: rows){
           MatcherAssert.assertThat(searchResults,containsString(row.get("title")));
           MatcherAssert.assertThat(searchResults,containsString(row.get("url")));

       }
    }



}


//package Step_Definitions;
//
//import Pages.LoginPage;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import utilities.Config;
//
//import java.sql.Driver;
//
//public class LoginStep_Definitions {
//
//
//
//        @Given("I am on vytrack login page")
//        public void i_am_on_vytrack_login_page() {
//            Driver.getDriver().get(Config.getProperty("url"));
//        }
//
//        @Then("I login as a sales manager")
//        public void i_login_as_a_sales_manager() {
//            String username = Config.getProperty("username");
//            String password = Config.getProperty("password");
//
//            LoginPage loginPage = new LoginPage();
//            loginPage.username.sendKeys(username);
//            loginPage.password.sendKeys(password);
//            loginPage.submit.click();
//
//        }
//
//    }
//
//

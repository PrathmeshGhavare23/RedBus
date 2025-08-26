package GlueCode;

import BaseLayer.BaseClass;
import PageLayer.Redbus;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RedbusTest extends BaseClass {
	Redbus redbus;

	@Given("the {string} browser is launched")
	public void the_browser_is_launched(String browsername) {
		BaseClass.intialization(browsername);
	}

	@When("user click on From Field")
	public void user_click_on_from_field() {
		redbus = new Redbus();
		redbus.clickOnFromField();
	}

	@When("User Eneter value as {string}")
	public void user_eneter_value_as(String sourceLocation) {
		redbus = new Redbus();
		redbus.EnterSourceLocation(sourceLocation);
	}

	@When("user select value from dropdown")
	public void user_select_value_from_dropdown() {
		redbus = new Redbus();
		redbus.selectSourceLocation("Mumbai");

	}

	@When("User enter destination location value as {string}")
	public void user_enter_destination_location_value_as(String destinationLocation) {
		redbus = new Redbus();
		redbus.EnterDestinationLocation(destinationLocation);

	}

	@When("user select value To dropdown")
	public void user_select_value_to_dropdown() {
		redbus = new Redbus();
		redbus.selectDestinationLocation("Pune");
	}

	@When("User select month and year as {string} and date as {string}")
	public void user_select_month_and_year_as_and_date_as(String MonthYear, String date) {
		redbus = new Redbus();
		redbus.OpenCalender();
		redbus.ExpectedDateSelector(MonthYear, date);
	}

	@When("user click on SearchBus button")
	public void user_click_on_search_bus_button() {
		redbus = new Redbus();
		redbus.SearchButton();
	}

	@Then("user search PrimoBus")
	public void user_search_primo_bus() {
		redbus = new Redbus();
		redbus.searchPrimoBus();

	}

	@Then("user search ACBus")
	public void user_search_ac_bus() {
		redbus = new Redbus();
		redbus.searchAcBus();
	}

	@Then("Scroll to the bottom of the page to load all bus operator")
	public void scroll_to_the_bottom_of_the_page_to_load_all_bus_operator() {
		redbus = new Redbus();
		redbus.scrollBottomPage();
	}

	@Then("Store Operator Names")
	public void store_operator_names() {
		redbus = new Redbus();
		redbus.StoreOperatorNames();

	}

	@Then("Print Total Buses and Operator names")
	public void print_total_buses_and_operator_names() {
		redbus = new Redbus();
		redbus.PrintAllOperatorsAndTotal();
	}

	@AfterStep
	public static void WaitingTime() throws InterruptedException {
		Thread.sleep(1000);
	}

	@AfterAll
	public static void tearDown() {
		driver().quit();
	}
}

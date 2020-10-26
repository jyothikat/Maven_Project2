package com.objectrepository;

import org.openqa.selenium.By;

public class Locators {
	
	public final By FLIGHTS_LINK = By.xpath("//span[text()= 'Flights']");
	public final By LEAVINGFROM_BUTTON = By.xpath("//button[@aria-label='Leaving from']");
	public final By ORIGIN_INPUT = By.xpath("//input[@id='location-field-leg1-origin']");
	public final By ORIGIN1_INPUT = By.xpath("//li[@class='uitk-typeahead-result-item has-subtext'][1]");
	public final By GOINGTO_BUTTON = By.xpath("//button[@aria-label='Going to']");
	public final By DESTINATION_INPUT = By.xpath("//input[@id='location-field-leg1-destination']");
	public final By DESTINATION1_INPUT = By.xpath("(//button[@data-stid = 'location-field-leg1-destination-result-item-button'])[1]");
	public final By TRAVEL_DATE = By.xpath("//button[contains(@id,'d1-btn')]");
	public final By DEPART_DATE = By.xpath("(//table[@class='uitk-new-date-picker-weeks'])[1]/tbody/tr[3]/td[4]");
	public final By RETURN_DATE = By.xpath("(//table[@class='uitk-new-date-picker-weeks'])[2]/tbody/tr[4]/td[6]");
	public final By DONE_BUTTON = By.xpath("//span[text() = 'Done']");
	public final By SEARCH_BUTTON = By.xpath("//button[text()='Search']");
	public final By TEXTVALIDATION = By.xpath("(//div[@class='uitk-flex'])[1]");

}

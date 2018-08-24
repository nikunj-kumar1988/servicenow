package com.atos.servicenow.pages.module.call;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.atos.servicenow.base.TestBase;

public class CreateNew extends TestBase {

	// Page Factory - OR:
	@FindBy(linkText = "Call Logging")
	WebElement callLogging;

	@FindBy(id = ".//*[@id='u_call.contact_type']")
	WebElement contactType;

	@FindBy(id = ".//*[@id='nav_west_south']")
	WebElement caller;

	@FindBy(id = ".//*[@id='sys_display.u_call.u_actual_location']")
	WebElement actualLocation;

	@FindBy(id = ".//*[@id='u_call.u_notify_by']")
	WebElement notifyBy;

	@FindBy(id = ".//*[@id='sys_display.u_call.u_customer']")
	WebElement businessUser;

	@FindBy(id = ".//*[@id='sys_readonly.u_call.u_local_user_time']")
	WebElement localBUTime;

	@FindBy(id = ".//*[@id='sys_display.u_call.u_service']")
	WebElement serviceOffering;

	@FindBy(id = ".//*[@id='sys_display.u_call.cmdb_ci']")
	WebElement configurationItem;

	@FindBy(id = ".//*[@id='sys_display.u_call.u_supporting_service']")
	WebElement supportOffering;

	@FindBy(id = ".//*[@id='u_call.u_managed_type']")
	WebElement managedType;

	@FindBy(id = ".//*[@id='u_call.u_call_category']")
	WebElement callCategory;

	@FindBy(id = ".//*[@id='sys_display.u_call.u_service_offering_causing_the_incident']")
	WebElement serviceOfferingCausingIncident;

	@FindBy(id = ".//*[@id='sys_display.u_call.u_support_offering_causing_the_incident']")
	WebElement supportOfferingCausingIncident;

	@FindBy(id = ".//*[@id='sys_display.u_call.u_support_offering_causing_the_incident']")
	WebElement shortDescription;

	@FindBy(id = ".//*[@id='u_call.description']")
	WebElement longDescription;

	@FindBy(id = ".//*[@id='sys_readonly.u_call.u_call_state']")
	WebElement assignmentGroup;

	@FindBy(id = ".//*[@id='sysverb_insert']")
	WebElement submit;
	
	// Initializing the Page Objects:
	public CreateNew() {
		PageFactory.initElements(driver, this);
	}
	
	

}

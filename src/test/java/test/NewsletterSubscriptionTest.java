package test;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.firestarters.steps.HomepageSteps;
import com.firestarters.utils.Constants;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = Constants.CSV_FILES_PATH + "newsletterEmail.csv")

public class NewsletterSubscriptionTest extends BaseTest {
	
	@Steps
	HomepageSteps homePageSteps;
	
	
	private String emailAddress,expectedResult;
	
	@Test
	public void checkEmailInputForSubscription() {
		homePageSteps.testSubscriptionInput(emailAddress, expectedResult);
	}
	

}

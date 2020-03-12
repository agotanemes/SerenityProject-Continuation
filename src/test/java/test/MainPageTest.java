package test;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.firestarters.steps.HomepageSteps;
import com.firestarters.steps.MainPageSteps;
import com.firestarters.steps.SalePageSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class MainPageTest {
	@Steps
	HomepageSteps homePageSteps;
	
	@Steps
	SalePageSteps salePageSteps;
	
	@Test
	public void checkNavigation() {
		homePageSteps.clickOnSaleSection();
		salePageSteps.checkUrl();
	}
	

	
	

}

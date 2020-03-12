package test;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.firestarters.page.TopsAndBlousesPage;
import com.firestarters.steps.HomepageSteps;
import com.firestarters.steps.MainPageSteps;
import com.firestarters.steps.MenPageSteps;
import com.firestarters.steps.ProductSortingSteps;
import com.firestarters.steps.TopsAndBlousesSteps;
import com.firestarters.steps.WomenPageSteps;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class ProductSortingTest extends BaseTest{
	@Steps
	HomepageSteps mainPageSteps;
	
	@Steps
	MenPageSteps menPageSteps;
	
	@Steps
	ProductSortingSteps productSorting;
	
	@Steps
	WomenPageSteps womenPageSteps;
	
	@Steps
	TopsAndBlousesSteps topsAndBlousesSteps;

	@Test
	public void checkMenTeesAscendingPriceSort() {
		mainPageSteps.clickOnMenSection();
		menPageSteps.selectTeesKnitsPolosCategory();
		productSorting.verifyAscendingSortByPrice();
	}
	
	@Test
	public void checkMenTeesDescendingPriceSort() {
		mainPageSteps.clickOnMenSection();
		menPageSteps.selectTeesKnitsPolosCategory();
		productSorting.verifyDescendingSortByPrice();;
	}
	
	@Test
	public void checkMenTeesAscendingNameSort() {
		mainPageSteps.clickOnMenSection();
		menPageSteps.selectTeesKnitsPolosCategory();
		productSorting.verifyAscendingSortByName();
		
	}
	
	@Test
	public void checkMenTeesDescendingNameSort() {
		mainPageSteps.clickOnMenSection();
		menPageSteps.selectTeesKnitsPolosCategory();
		productSorting.verifyDescendingSortByName();;
		
	}
	
	
	@Test
	public void checkSortingByFirstPriceCategory() {
		mainPageSteps.clickOnWomenSection();
		womenPageSteps.clickTopsAndBlousesCategory();
		topsAndBlousesSteps.clickFirstPriceCategory();
		topsAndBlousesSteps.checkFirstPriceCategorySorting();
			
	}
	

	@Test
	public void checkSortingBySecondPriceCategory() {
		mainPageSteps.clickOnWomenSection();
		womenPageSteps.clickTopsAndBlousesCategory();
		topsAndBlousesSteps.clickSecondPriceCategory();
		topsAndBlousesSteps.checkSecondPriceCategorySorting();
			
	}
	
	@Test
	public void checkSortingByThirdPriceCategory() {
		mainPageSteps.clickOnWomenSection();
		womenPageSteps.clickTopsAndBlousesCategory();
		topsAndBlousesSteps.clickThirdPriceCategory();
		topsAndBlousesSteps.checkThirdPriceCategorySorting();
		
	}
	
	
	

}

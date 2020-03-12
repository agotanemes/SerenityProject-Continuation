package test;

import com.firestarters.steps.HomepageSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class HomaPageTest extends BaseTest {
    @Steps
    HomepageSteps homepageSteps;
    @Test
    public void clickOnSpecifiedSubcategory(){
        String category="Women";
        String subcategory="New Arrivals";
        homepageSteps.clickOnSubcategoryOfACategory(category,subcategory);
    }

}

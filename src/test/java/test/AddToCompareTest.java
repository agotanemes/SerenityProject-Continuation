package test;

import com.firestarters.steps.HeaderSteps;
import com.firestarters.steps.ProductPageSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class AddToCompareTest extends BaseTest {

    @Steps
    HeaderSteps headerSteps;

    @Steps
    ProductPageSteps productPageSteps;

    @Test
    public void testIfAddToCompareConfirmationMessageAppears(){
        headerSteps.navigateToMenPantsSubcategory();
        productPageSteps.selectAdToCompare();

    }

    @Test
    public void testIfCompareMenuAppears(){
        headerSteps.navigateToMenPantsSubcategory();
        productPageSteps.addToCompare();
    }

}

package test;

import com.firestarters.models.Wheather;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class WheatherApiTest {

    @Test
    public void test_NumberOfCircuitsFor2017Season_ShouldBe20() {
        RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";

        Wheather wheather = given().
                when().
                get("/Hyderabad").
                then().
                assertThat().
                statusCode(200).
                extract().as(Wheather.class);

        System.out.println("City: "+wheather.getCity()+" "+"Temperature: "+wheather.getTemperature()+" "+ "Humidity: "+wheather.getHumidity()+" WeatherDescription: "+wheather.getWeatherDescription()+" WindSpeed: "+ wheather.getWindSpeed()
        +" WindDirectionDegree: "+wheather.getWindDirectionDegree());

    }

}

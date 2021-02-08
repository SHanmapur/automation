package tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiTest {


    @Test
    public void test() {

        String url = "https://jsonplaceholder.typicode.com/posts";

        Response resp = RestAssured.given()
               .when().get(url);
        //ExtractableResponse<Response> jsonResp = resp.then().contentType(ContentType.JSON).extract();

        JSONArray JSONResponseBody = new   JSONArray(resp.body().asString());
        Assert.assertTrue(JSONResponseBody.length()>0);
        Assert.assertEquals(JSONResponseBody.getJSONObject(0).get("id").toString(), "1");
        Assert.assertEquals(JSONResponseBody.getJSONObject(0).get("title").toString(), "sunt aut facere repellat provident occaecati excepturi optio reprehenderit");




    }
}

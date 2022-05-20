package com.bridgelebz.restdemo;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class GetMethodTest {
    @Test
    public void Test(){
        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        System.out.println("Status code: " + response.statusCode());
        System.out.println("Response body: "+ response.prettyPrint());
    }
    @Test
    public void get_Web_Total() {
        RestAssured.given().when().get("https://reqres.in/api/users?page=2").
                then().body("total", equalTo(12));
    }

        @Test
        public void get_Web_Email(){
            RestAssured.given().when().get("https://reqres.in/api/users?page=2").then()
                    .body("data[0].email", equalTo("michael.lawson@reqres.in"));
    }

}

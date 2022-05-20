package com.bridgelebz.restdemo;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import netscape.javascript.JSObject;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RestDemo {
    @Test
    public void Test(){
        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        System.out.println("Status code: " + response.statusCode());
        System.out.println("Response body: "+ response.prettyPrint());
    }
    @Test
    public void getTest(){
        Response response = RestAssured.get("http://localhost:3000/posts");
        response.prettyPrint();
    }

    @Test
    public void postTest(){
        RequestSpecification request =RestAssured.given();
        request.header("content-type","application/json");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Id","6");
        jsonObject.put("Name","Ganesh");
        jsonObject.put("Job Profile","Doctor");
        request.body(jsonObject.toJSONString());
        Response response = request.post("http://localhost:3000/posts");
        System.out.println(response.getStatusCode());
        System.out.println(response.prettyPrint());
    }
    @Test
    public void putTest(){
        RequestSpecification request =RestAssured.given();
        request.header("content-type","application/json");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Id","5");
        jsonObject.put("Name","Ganesh");
        jsonObject.put("Job Profile","Doctor");
        request.body(jsonObject.toJSONString());
        Response response = request.put("http://localhost:3000/posts");
        System.out.println(response.getStatusCode());
        System.out.println(response.prettyPrint());
    }
@Test
    public void deleteTest(){
        RequestSpecification request = RestAssured.given();
        Response response = request.delete("http://localhost:3000/posts/10");
        System.out.println(response.getStatusCode());
        int Statuscode = response.statusCode();
        assertEquals(Statuscode,200);
    }

    @Test
    public void get_Test() {
        Response response = RestAssured.get("http://localhost:3000/comments");
        response.prettyPrint();
    }
    @Test
    public void post_Test(){
        RequestSpecification request =RestAssured.given();
        request.header("content-type","application/json");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Id","202");                           //d": 1, "body": "some comment", "postId": 1 }
        jsonObject.put("comment","great");
        jsonObject.put("postId",1);
        request.body(jsonObject.toJSONString());
        Response response = request.post("http://localhost:3000/comments");
        System.out.println(response.getStatusCode());
        System.out.println(response.prettyPrint());
    }
    @Test
    public void put_Test(){
        RequestSpecification request =RestAssured.given();
        request.header("content-type","application/json");
        JSONObject jsonObject = new JSONObject();
        //jsonObject.put("Id","5");
        jsonObject.put("comment","excellent");
        //jsonObject.put("postID","1");
        request.body(jsonObject.toJSONString());
        Response response = request.put("http://localhost:3000/comments/1");
        System.out.println(response.getStatusCode());
        System.out.println(response.prettyPrint());
    }
    @Test
    public void delete_Test(){
        RequestSpecification request = RestAssured.given();
        Response response = request.delete("http://localhost:3000/comments/1");
        System.out.println(response.getStatusCode());
//        int Statuscode = response.statusCode();
//        assertEquals(Statuscode,200);
    }
    @Test
    public void get_profileTest(){
        Response response = RestAssured.get("http://localhost:3000/profile");
        response.prettyPrint();
    }

    @Test
    public void post_profileTest(){
        RequestSpecification request =RestAssured.given();
        request.header("content-type","application/json");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Id","1");
        jsonObject.put("Name","Ganesh");
        //jsonObject.put("Job Profile","Doctor");
        request.body(jsonObject.toJSONString());
        Response response = request.post("http://localhost:3000/profile");
        System.out.println(response.getStatusCode());
        System.out.println(response.prettyPrint());
    }
    @Test
    public void put_profileTest(){
        RequestSpecification request =RestAssured.given();
        request.header("content-type","application/json");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Id","1");
        jsonObject.put("Name","Ajit");
        //jsonObject.put("Job Profile","Doctor");
        request.body(jsonObject.toJSONString());
        Response response = request.put("http://localhost:3000/profile");
        System.out.println(response.getStatusCode());
        System.out.println(response.prettyPrint());
    }
    @Test
    public void delete_profileTest(){
        RequestSpecification request = RestAssured.given();
        Response response = request.delete("http://localhost:3000/profile/1");
        System.out.println(response.getStatusCode());
//        int Statuscode = response.statusCode();
//        assertEquals(Statuscode,200);
    }
}

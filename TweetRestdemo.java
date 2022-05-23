package com.bridgelebz.restdemo;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;




public class TweetRestdemo {
    //oauth("API key","API secret","Acesstoken","Access secret")


    @Test
    public void twitterPost() {
        Response response = RestAssured.given()
                .auth().oauth("xCJD9KCzFAeywAT0ErnQtyCGh",
                        "rUr8uvfBuk7CYqhqqvanzPcnFHQxpIheudeQZXEcJ4XsVkWddi",
                        "1527487497931849729-meyxDwSehMTW0tDyIB8bc5krp2eVUj",
                        "zM7qgDQgBhnPNqqax6D2ewcZEK9TEkkpyYHhrhV2TOtMt")
                .post("https://api.twitter.com/1.1/statuses/update.json?status= Good morning");
        System.out.println(response.prettyPrint());
        JsonPath jsonPath = response.jsonPath();
        System.out.println("ID:" + jsonPath.get("id_str"));
    }

    @Test
    public void retwitterPost() {
        Response response = RestAssured.given()
                .auth().oauth("08plrBcbYHxOGYEkkywh9lFRA",
                        "L05ubKvpZ6KUkBIHak3UptH6mBDwV4l1rhRMQpO1NNhq3ms8ch",
                        "4003503614-Zyvb5CvJsQgYP1aF74Nwj0IrcQKoo9gfkofWbJz",
                        "lEYfrijNJMIiHaRUnAIUKWg5mfNBD1LhM9Lxehtix96NE")
                .post("https://api.twitter.com/1.1/statuses/retweet/1528570791402811393.json");
        System.out.println(response.prettyPrint());
    }
    @Test
    public void delete() {
        Response response = RestAssured.given()
                .auth().oauth("08plrBcbYHxOGYEkkywh9lFRA",
                        "L05ubKvpZ6KUkBIHak3UptH6mBDwV4l1rhRMQpO1NNhq3ms8ch",
                        "4003503614-Zyvb5CvJsQgYP1aF74Nwj0IrcQKoo9gfkofWbJz",
                        "lEYfrijNJMIiHaRUnAIUKWg5mfNBD1LhM9Lxehtix96NE")
                .post("https://api.twitter.com/2/tweets/1528570791402811393");
        System.out.println(response.prettyPrint());
    }
}






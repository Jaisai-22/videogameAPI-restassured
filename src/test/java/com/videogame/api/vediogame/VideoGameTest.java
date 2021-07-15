package com.videogame.api.vediogame;

import com.videogame.api.model.VideoGamePojo;
import com.videogame.api.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;


import java.util.Random;

import static io.restassured.RestAssured.given;

public class VideoGameTest extends TestBase {
    public Random randomGenerator = new Random();
    public int randomInt = randomGenerator.nextInt(1000);

    @Test
    public void getAllVideoGames() {

        Response response =
                given()
                        .accept("application/json")
                        .when()
                        .get();
        response.then().statusCode(200);
        response.prettyPrint();


    }

    @Test
    public void createNewVedioGame() {

        VideoGamePojo videoGamePojo = new VideoGamePojo();
        videoGamePojo.setId(randomInt);
        videoGamePojo.setName("IronMan");
        videoGamePojo.setReleaseDate("2021-07-15T19:08:27.609Z");
        videoGamePojo.setReviewScore(67);
        videoGamePojo.setCategory("String");
        videoGamePojo.setRating("String");

        Response response =
                given()
                        .header("Content-Type", "application/json")
                        .body(videoGamePojo).accept("application/json")
                        .when()
                        .post();
        response.then().statusCode(200);
        response.prettyPrint();


    }

    @Test
    public void deleteRecord() {
        Response response =
                given()
                        .accept("application/json")
                        .pathParam("id", 23)
                        .when()
                        .delete("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }


    @Test
    public void getProductById() {

        Response response =
                given()
                        .accept("application/json")
                        .pathParam("id",4)
                        .when()
                        .get("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }

@Test
    public void updateExistingVideoGame(){
    VideoGamePojo videoGamePojo = new VideoGamePojo();
    videoGamePojo.setId(6);
    videoGamePojo.setName("SpiderMan");
    videoGamePojo.setReleaseDate("2021-07-15T19:08:27.609Z");
    videoGamePojo.setReviewScore(98);
    videoGamePojo.setCategory("Platform");
    videoGamePojo.setRating("Universal");

    Response response = given()
            .accept("application/json")
            .header("Content-Type", "application/json")
            .when()
            .body(videoGamePojo)
            .put("/6");
    response.then().statusCode(200);
    response.prettyPrint();

    }



}







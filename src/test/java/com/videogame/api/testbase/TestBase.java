package com.videogame.api.testbase;

import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class TestBase {

    @BeforeClass
    public static void init() {
        RestAssured.baseURI = "http://localhost/app";
        RestAssured.port = 8080;
       RestAssured.basePath=("/videogames");



    }
}
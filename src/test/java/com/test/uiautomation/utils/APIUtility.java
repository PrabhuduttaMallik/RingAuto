package com.test.uiautomation.utils;

import com.test.uiautomation.requests.RegisterUser;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;

public class APIUtility {

        public APIUtility() {

        }

        public static Response postWithRequestBody(int statusCode, RegisterUser reqBody, String url) throws Exception {

                Response response = RestAssured.given().contentType("application/json").and().body(reqBody).when().post(url);
                if (response.statusCode() != statusCode){
                        System.out.println("ApI behaving weired $$#@$@ -- "+response.getStatusCode());
                }
                return response;
        }

        public static Response getDetails(int statusCode, String url) throws Exception {

                Response response = RestAssured.given().contentType("application/json").and().get(url);
                if (response.statusCode() != statusCode){
                        System.out.println("ApI behaving weired $$#@$@ -- "+response.getStatusCode());
                }
                return  response;
        }
}

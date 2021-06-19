package com.test.uiautomation.apiActions;

import com.google.gson.JsonObject;
import com.test.uiautomation.requests.RegisterUser;
import com.test.uiautomation.requests.User;
import com.test.uiautomation.utils.APIUtility;
import com.test.uiautomation.utils.ResponseCode;
import com.test.uiautomation.utils.TestDataFetcher;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class APIActionDetails {

    public static Logger LOGGER = Logger.getLogger(APIActionDetails.class.getName());
    public static Response response;

    public static String url;

    static {
        try {
            url = TestDataFetcher.getPropertyDetails("apiBaseUrl",System.getProperty("envType"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public APIActionDetails() throws Exception {
    }

    public static void registerUser(String email, String password, String userName, String userType) throws Exception {

        //RandomStringUtils.randomAlphanumeric(5);
        //FORMING REQUEST BODY
        RegisterUser registerUser = new RegisterUser();
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setUsername(userName);
        registerUser.setUser(user);

        //FORMING REGISTER USER URL
        String registerUrl = url+TestDataFetcher.getPropertyDetails("registerUserEP", System.getProperty("envType"));
        System.out.println(registerUrl);

        //MAKING POST CALL WITH REQUEST BODY TO SERVER
        if (userType.equalsIgnoreCase("invalidUser")) {
            response = APIUtility.postWithRequestBody(ResponseCode.UNPROCESSRED_ENTITY, registerUser, registerUrl);
            System.out.println("The response is ---" + response.prettyPrint());
        }

        else if (userType.equalsIgnoreCase("validUser")){
             response = APIUtility.postWithRequestBody(ResponseCode.OK, registerUser, registerUrl);
        }
    }

    public static boolean listAllArticle(String pathToArray, int articleCount) throws Exception {

        response = APIUtility.getDetails(ResponseCode.OK, url+TestDataFetcher.getPropertyDetails("listAllArticles", System.getProperty("envType")));
        int val = Integer.parseInt(response.jsonPath().getString("articlesCount"));
        Assert.assertEquals("The article count is a misssmatch", articleCount, val);

        List<HashMap<String, String>> list = response.jsonPath().getList(pathToArray);
        for (HashMap<String, String > hm : list) {
           if (hm.containsKey("title")){
               return true;
           }
        }
        return false;
    }

    public static void getListOfArticleByTheUser(String userIs) throws Exception {

        String username = null;
        String urlIs = url+TestDataFetcher.getPropertyDetails("articleByUser", System.getProperty("envType"))+userIs;
        System.out.println("The url is --"+urlIs);
        if (userIs.equalsIgnoreCase("johnjacob")) {


            response = APIUtility.getDetails(ResponseCode.OK, urlIs);

            JSONObject jsonObject = new JSONObject(response.getBody().asString());
            JSONArray jsonObject1 = (JSONArray) jsonObject.get("articles");
           for (int i =0; i<jsonObject1.length(); i++) {
               JSONObject  jsonObject2 = jsonObject1.getJSONObject(i);
               JSONObject  authorDetails = (JSONObject) jsonObject2.get("author");
                username = authorDetails.getString("username");
           }
            Assert.assertEquals("Username is a mismatch:[Looking  for username "+userIs+" and found user is "+username+"]",userIs, username);
        }
    }

    public static void getArticleByTag(String tagName) throws Exception {

        String urlIs = url+TestDataFetcher.getPropertyDetails("articleByTag", System.getProperty("envType"))+tagName;
        System.out.println("The url is --"+urlIs);

        if (tagName.equalsIgnoreCase("dragons")){

            response = APIUtility.getDetails(ResponseCode.OK, urlIs);
            JSONObject jsonObject = new JSONObject(response.getBody().asString());
            JSONArray jsonObject1 = (JSONArray) jsonObject.get("articles");
            for (int i =0; i<jsonObject1.length(); i++) {
                JSONObject  jsonObject2 = jsonObject1.getJSONObject(i);
                System.out.println("loowewq --"+jsonObject2.toString());
                JSONArray  tagList = (JSONArray) jsonObject2.get("tagList");
                for (Object s : tagList){
                    System.out.println("tagname --"+s.toString());
                    if (s == tagName){
                        Assert.assertTrue(""+tagName+" is not present", true);
                    }
                }
             }

        }
        else if (tagName.equalsIgnoreCase("Gandhi")){

            response = APIUtility.getDetails(ResponseCode.OK, urlIs);
            JSONObject jsonObject = new JSONObject(response.getBody().asString());
            JSONArray jsonObject1 = (JSONArray) jsonObject.get("articles");
            for (int i =0; i<jsonObject1.length(); i++) {
                JSONObject  jsonObject2 = jsonObject1.getJSONObject(i);
                System.out.println("loowewq --"+jsonObject2.toString());
                JSONArray  tagList = (JSONArray) jsonObject2.get("tagList");
                for (Object s : tagList){
                    System.out.println("tagname --"+s.toString());
                    if (s == tagName){
                        Assert.assertTrue(""+tagName+" is not present", true);
                    }
                }
            }

        }

        else if (tagName.equalsIgnoreCase("BlackLivesMatter")){

            response = APIUtility.getDetails(ResponseCode.OK, urlIs);
            JSONObject jsonObject = new JSONObject(response.getBody().asString());
            JSONArray jsonObject1 = (JSONArray) jsonObject.get("articles");
            for (int i =0; i<jsonObject1.length(); i++) {
                JSONObject  jsonObject2 = jsonObject1.getJSONObject(i);
                System.out.println("loowewq --"+jsonObject2.toString());
                JSONArray  tagList = (JSONArray) jsonObject2.get("tagList");
                for (Object s : tagList){
                    System.out.println("tagname --"+s.toString());
                    if (s == tagName){
                        Assert.assertTrue(""+tagName+" is not present", true);
                    }
                }
            }

        }
    }

    public static void getTagDetails() throws Exception {

        String urlIs = url+TestDataFetcher.getPropertyDetails("getAllTheTags", System.getProperty("envType"));
        System.out.println("The url is --"+urlIs);

        response = APIUtility.getDetails(ResponseCode.OK, urlIs);
    }
}

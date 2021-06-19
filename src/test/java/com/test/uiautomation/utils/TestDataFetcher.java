package com.test.uiautomation.utils;

import com.google.gson.JsonParser;
import org.json.JSONObject;

import java.io.FileReader;

public class TestDataFetcher {

    //Fetch Data from JSON File for each environment passed in gradle command


    public static String getPropertyDetails(String string, String property) throws Exception {
        String[] strings = {string};
        strings = getDataFromJSON(property, strings);

        return strings[0];
    }

    /**
     *
     * @param property
     * @param keyValue
     * @return
     * @throws Exception
     */
    public static String[] getDataFromJSON(String property, String[] keyValue) throws Exception
    {
        try
        {
            Object object = readJsonData("testData.json");
            JSONObject jsonObject = new JSONObject(object.toString());
            jsonObject = (JSONObject) jsonObject.get(property);
            String[] strings = new String[keyValue.length];

            for (int i=0; i<keyValue.length; ++i)
            {
                try{
                    strings[i] = (String) jsonObject.get(keyValue[i].toString());
                }catch (Exception e){

                }
            }
            return strings;
        }catch (Exception e1)
        {
            System.out.println("not found");
            return null;
        }
    }

    public static Object readJsonData(String jsonFilePath) throws Exception
    {
        FileReader fileReader = new FileReader(jsonFilePath);
        Object obj = (new JsonParser()).parse(fileReader);
        return obj;
    }
}

package com.test.uiautomation.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextFileReader {

    public static String getText(String fileName) {

        BufferedReader bufferedReader = null;
        try{
            bufferedReader = new BufferedReader(new FileReader(fileName));
            return bufferedReader.readLine();
        }catch (IOException e){
            e.printStackTrace();
        } finally {
            try{
                if(bufferedReader != null)
                    bufferedReader.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return null;
    }
}

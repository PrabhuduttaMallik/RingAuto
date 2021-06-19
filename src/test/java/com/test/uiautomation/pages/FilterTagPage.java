package com.test.uiautomation.pages;

public class FilterTagPage {

    public static final String globalFeedText = "//ul[@class='nav nav-pills outline-active']/li[@class='nav-item']/a[@class='nav-link active']";
    //public static final String huMantly = "//a[normalize-space()='HuManIty']";
    public static final String tagInResult = "//article-preview//li";
    public static final String articleText = "//article-preview//h1";

    public static final String tagResult(String tagToClick) {

        String xpath = "//a[normalize-space()='"+tagToClick+"']";
        System.out.println("daddddd -- "+xpath);
        return xpath;
    }
}

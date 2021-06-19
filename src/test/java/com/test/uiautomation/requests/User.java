package com.test.uiautomation.requests;

public class User {

    private String password;

    private String email;

    private String username;

    public String getPassword ()
    {
        return password;
    }

    public void setPassword (String password)
    {
        this.password = password;
    }

    public String getEmail ()
    {
        return email;
    }

    public void setEmail (String email)
    {
        this.email = email;
    }

    public String getUsername ()
    {
        return username;
    }

    public void setUsername (String username)
    {
        this.username = username;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [password = "+password+", email = "+email+", username = "+username+"]";
    }
}

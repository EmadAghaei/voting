package com.symplicity.web.model;

import java.util.HashMap;
import java.util.Map;

public class Vote {

    private String userName;
    private String fruit;
    private Map<String,Integer> fruitCount = new HashMap();



    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Map<String, Integer> getFruitCount() {
        return fruitCount;
    }

    public void setFruitCount(Map<String, Integer> fruitCount) {
        this.fruitCount = fruitCount;
    }

}

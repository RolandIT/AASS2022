package com.example.backend.controllers;

public enum BackendQueries {
    GET_CARS_REPAIRS("SELECT * FROM AASS.REPAIR WHERE ID_CAR = ?"),
    INSERT_CAR("INSERT INTO AASS.CARS (SPZ, YEAR_OF_MANUFACTURE, BRAND, ID_OWNER) VALUES (?,?,?,?)"),
    GET_CARS_FILTER("SELECT * FROM AASS.CARS WHERE SPZ LIKE '%' || '?' || '%'"),
    GET_CAR_LIST("SELECT * FROM AASS.CARS WHERE ID_OWNER = ?"),
    INSERT_CUSTOMER("INSERT INTO AASS.CUSTOMERS (NAME, SURNAME, PHONE_NUMBER, OP_NUMBER, ACCOUNT_ID) VALUES (?,?,?,?,?)"),
    INSERT_USER("INSERT INTO AASS.USERS (USERNAME, PASSWORD, TYPE) VALUES (?,?,?)"),
    GET_USER_ID("SELECT id FROM AASS.USERS WHERE USERNAME = ?"),
    LOGIN_USER("SELECT * FROM AASS.USERS WHERE USERNAME = ? AND PASSWORD = ?");

    private final String query;
    BackendQueries(String query){
        this.query = query;
    }

    public String getQuery(){
        return query;
    }
}

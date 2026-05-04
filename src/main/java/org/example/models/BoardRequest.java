package org.example.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BoardRequest {
    @JsonProperty("name")
    private String userName;

    public BoardRequest(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}

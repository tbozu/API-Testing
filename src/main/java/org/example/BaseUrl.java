package org.example;

import io.github.cdimascio.dotenv.Dotenv;
public class BaseUrl {

    Dotenv dotenv = Dotenv.load();
    private final String baseUrl ="https://api.trello.com/1/boards/";
    private final String apiKey = dotenv.get("API_KEY");
    private final String apiToken = dotenv.get("TOKEN_API");

    public String getApiToken() {
        return apiToken;
    }

    public String getApiKey() {
        return apiKey;
    }
    public String getBaseUrl() {
        return baseUrl;
    }

}

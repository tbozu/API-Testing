package testRestAssured;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.BaseUrl;
import org.example.models.BoardRequest;
import org.example.models.BoardResponse;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.ObjectMapper;

import static io.restassured.RestAssured.given;

public class testRestAssured {

    BaseUrl baseUrl = new BaseUrl();
    private BoardRequest boardRequest = new BoardRequest("Tudor Bozu");
    private BoardResponse boardResponse = new BoardResponse();
    @Test
    public void createBoard() throws JsonProcessingException {
        String responseAfterCreateBoard = given()
                .queryParam("name",boardRequest.getUserName())
                .queryParam("key",baseUrl.getApiKey())
                .queryParam("token",baseUrl.getApiToken())
                .post(baseUrl.getBaseUrl())
                .then()
                .statusCode(200)
                .extract()
                .asString();

        String getIdBoardNewCreated = new ObjectMapper().readTree(responseAfterCreateBoard).path("id").asText();
        boardResponse.setId(getIdBoardNewCreated);
    }
    @Test
    public void getIdBoard() throws JsonProcessingException {
        String responseGetBoardId = given()
                .pathParam("id", boardResponse.getId())
                .queryParam("key", baseUrl.getApiKey())
                .queryParam("token", baseUrl.getApiToken())
                .when()
                .get(baseUrl.getBaseUrl()+"{id}")
                .then()
                .statusCode(200)
                .extract()
                .asString();
        String getIdBoardFromGetMethod = new ObjectMapper().readTree(responseGetBoardId).path("id").asText();
        Assert.assertEquals(boardResponse.getId(),getIdBoardFromGetMethod);
    }

    @Test
    public void updateBoard() throws JsonProcessingException {
        String responseUpdateBoard = given()
                .pathParam("id",boardResponse.getId())
                .queryParam("key", baseUrl.getApiKey())
                .queryParam("token", baseUrl.getApiToken())
                .when()
                .put(baseUrl.getBaseUrl()+"{id}")
                .then()
                .statusCode(200)
                .extract().asString();

        String responseAfterUpdateBoard = new ObjectMapper().readTree(responseUpdateBoard).path("id").asText();
        Assert.assertEquals(responseAfterUpdateBoard,boardResponse.getId());
    }

    @Test
    public void deleteBoard() throws JsonProcessingException {
        String responseUpdateBoard = given()
                .pathParam("id",boardResponse.getId())
                .queryParam("key", baseUrl.getApiKey())
                .queryParam("token", baseUrl.getApiToken())
                .when()
                .delete(baseUrl.getBaseUrl()+"{id}")
                .then()
                .statusCode(200)
                .extract().asString();

        String responseAfterDeleteBoard = new ObjectMapper().readTree(responseUpdateBoard).path("_value").textValue();
        Assert.assertEquals(responseAfterDeleteBoard,null,"Board deleted with succeful");
    }

}

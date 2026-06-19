package testRetrofit;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.BaseUrl;
import org.example.api.TrelloApi;
import org.example.client.RetrofitClient;
import org.example.models.BoardRequest;
import org.example.models.BoardResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public class testRetrofitAndOkhttp {
    private TrelloApi api;
    private final ObjectMapper mapper = new ObjectMapper();
    BaseUrl baseUrl = new BaseUrl();
    @BeforeTest
    public void setUp(){
        api = RetrofitClient.getClient().create(TrelloApi.class);
    }

    @Test
    public BoardResponse testCreateBoard(String name) throws IOException {
        Call<BoardResponse> call = api.createBoard(name,baseUrl.getApiKey(),baseUrl.getApiToken());
        Response<BoardResponse> response = call.execute();
        int responseCode = response.code();
        Assert.assertEquals(responseCode,200);
        return mapper.readValue(response.body().toString(), BoardResponse.class);
    }
    @Test
    public BoardResponse testGetIdBoard(String id) throws IOException{
      Call<BoardResponse> call = api.getIdBoard(id,baseUrl.getApiKey(),baseUrl.getApiToken());
      Response<BoardResponse> response = call.execute();
        int responseCode = response.code();
        Assert.assertEquals(responseCode,200);
      return mapper.readValue(response.body().toString(), BoardResponse.class);
    }

    @Test
    public BoardResponse testUpdateBoard(String idBoard, String newName) throws IOException{
        Call<BoardResponse> call = api.updateBoard(idBoard,newName,baseUrl.getApiKey(),baseUrl.getApiToken());
        Response<BoardResponse> response = call.execute();
        int responseCode = response.code();
        Assert.assertEquals(responseCode,200);
        return mapper.readValue(response.body().toString(), BoardResponse.class);
    }
    @Test
    public BoardResponse testDeleteBoard(String id) throws IOException{
        Call<BoardResponse> call = api.deleteBoard(id, baseUrl.getApiKey(), baseUrl.getApiToken());
        Response<BoardResponse> response = call.execute();
        int responseCode = response.code();
        Assert.assertEquals(responseCode,200);
        return mapper.readValue(response.body().toString(), BoardResponse.class);
    }
}

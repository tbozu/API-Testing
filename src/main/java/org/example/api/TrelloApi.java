package org.example.api;

import org.example.models.BoardResponse;
import retrofit2.Call;
import retrofit2.http.*;

public interface TrelloApi {
    @POST("board/")
    Call<BoardResponse> createBoard(
            @Query("name") String name
            ,@Query("key") String keyApi
            ,@Query("token") String tokenApi);

    @GET("boards/{id}")
        Call<BoardResponse> getIdBoard(
                @Path("id") String idBoard,
                @Query("key") String keyApi,
                @Query("token") String tokenApi
        );

    @PUT("boards/{id}")
    Call<BoardResponse> updateBoard(
            @Path("id") String idBoard,
            @Query("name") String name,
            @Query("key") String keyApi,
            @Query("token") String tokenApi
    );

    @DELETE("boards/{id}")
    Call<BoardResponse> deleteBoard(
            @Path("id") String idBoard,
            @Query("key") String keyApi,
            @Query("token") String tokenApi
    );

}

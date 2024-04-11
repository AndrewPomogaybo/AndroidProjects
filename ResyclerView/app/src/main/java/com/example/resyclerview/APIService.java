package com.example.resyclerview;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
@GET("users")
    Call<UsersList> getUser();
}

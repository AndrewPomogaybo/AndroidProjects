package com.example.resyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        APIClient apiClient = new APIClient();
        apiClient.getApiService().getUser()
                .enqueue(new Callback<UsersList>() {
                    @Override
                    public void onResponse(Call<UsersList> call, Response<UsersList> response) {
                        if(response.isSuccessful() && response.body() != null){
                            List<Users> usersList = response.body().users;
                            RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(usersList);
                            RecyclerView recyclerView = findViewById(R.id.RecyclerViewView);
                            recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                            recyclerView.setAdapter(recyclerViewAdapter);
                        }
                    }
                    @Override
                    public void onFailure(Call<UsersList> call, Throwable throwable) {
                        Log.d("onFailure", throwable.getMessage());
                    }
                });

    }
}
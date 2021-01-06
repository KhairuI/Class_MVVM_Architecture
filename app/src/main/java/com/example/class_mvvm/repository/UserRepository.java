package com.example.class_mvvm.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.class_mvvm.api.MyInterface;
import com.example.class_mvvm.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserRepository {


    Retrofit retrofit= new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create()).build();
    MyInterface myInterface= retrofit.create(MyInterface.class);


    public MutableLiveData<List<Post>> getPost(){

        MutableLiveData<List<Post>> getMutableData= new MutableLiveData<>();

        Call<List<Post>> call= myInterface.getPost(new int[]{2,3});
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if(!response.isSuccessful()){
                    return;
                }
                List<Post> postList= response.body();
                getMutableData.setValue(postList);
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {


            }
        });

        return getMutableData;
    }

}

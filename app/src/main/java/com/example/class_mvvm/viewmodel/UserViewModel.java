package com.example.class_mvvm.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.class_mvvm.model.Post;
import com.example.class_mvvm.repository.UserRepository;

import java.util.List;

public class UserViewModel extends AndroidViewModel {

    private UserRepository repository;
    public LiveData<List<Post>> getLiveData;


    public UserViewModel(@NonNull Application application) {
        super(application);
        repository= new UserRepository();
    }

    public void getPost(){

        getLiveData= repository.getPost();
    }

}

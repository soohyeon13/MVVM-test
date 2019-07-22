package com.example.gitservicemvvm.model;

import android.databinding.Observable;

public interface GitHubService {
    Observable listRepos(String s);

    public class Repositories {
    }
}

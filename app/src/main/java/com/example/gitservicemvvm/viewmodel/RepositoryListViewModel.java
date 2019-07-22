package com.example.gitservicemvvm.viewmodel;

import android.databinding.ObservableInt;
import android.view.View;

import com.example.gitservicemvvm.contract.RepositoryListViewContract;
import com.example.gitservicemvvm.model.GitHubService;

public class RepositoryListViewModel {
    public final ObservableInt progressBarVisibility = new ObservableInt(View.VISIBLE);
    private final RepositoryListViewContract repositoryListViewContract;
    private final GitHubService gitHubService;

    public RepositoryListViewModel(RepositoryListViewContract repositoryListViewContract, GitHubService gitHubService) {
            this.repositoryListViewContract = repositoryListViewContract;
            this.gitHubService = gitHubService;
    }

}

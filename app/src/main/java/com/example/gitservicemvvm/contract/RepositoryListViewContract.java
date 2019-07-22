package com.example.gitservicemvvm.contract;

import com.example.gitservicemvvm.model.GitHubService;

public interface RepositoryListViewContract {
    void showRepositories(GitHubService.Repositories repositories);

    void showError();

    void startDetailActivity(String fullName);
}

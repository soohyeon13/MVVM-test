package com.example.gitservicemvvm.view;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.gitservicemvvm.R;
import com.example.gitservicemvvm.contract.RepositoryListViewContract;
import com.example.gitservicemvvm.databinding.ActivityRepositoryListBinding;
import com.example.gitservicemvvm.model.GitHubService;
import com.example.gitservicemvvm.viewmodel.RepositoryListViewModel;

public class RepositoryListActivity extends AppCompatActivity implements RepositoryListViewContract {
    private RepositoryAdapter repositoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityRepositoryListBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_repository_list);
        final GitHubService githubService = ((NewGitHubReposApplication) getApplication()).getGitHubService();
        binding.setViewModel(new RepositoryListViewModel((RepositoryListViewContract)this,githubService));

        setupViews();
    }

    private void setupViews() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_repos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        repositoryAdapter = new RepositoryAdapter((Context)this,(RepositoryListViewContract)this);
        recyclerView.setAdapter(repositoryAdapter);



    }

    @Override
    public void showRepositories(GitHubService.Repositories repositories) {

    }

    @Override
    public void showError() {

    }
}

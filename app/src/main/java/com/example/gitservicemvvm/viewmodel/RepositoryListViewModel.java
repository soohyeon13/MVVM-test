package com.example.gitservicemvvm.viewmodel;

import android.databinding.ObservableInt;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.AdapterView;

import com.example.gitservicemvvm.contract.RepositoryListViewContract;
import com.example.gitservicemvvm.model.GitHubService;

import java.util.Calendar;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RepositoryListViewModel {
    public final ObservableInt progressBarVisibility = new ObservableInt(View.VISIBLE);
    private final RepositoryListViewContract repositoryListViewContract;
    private final GitHubService gitHubService;

    public RepositoryListViewModel(RepositoryListViewContract repositoryListViewContract, GitHubService gitHubService) {
            this.repositoryListViewContract = repositoryListViewContract;
            this.gitHubService = gitHubService;
    }
    public void onLanguageSpinnerItemSelected(AdapterView<?> parent , View view , int position , long id) {
        loadRepositories((String) parent.getItemAtPosition(position));
    }

    private void loadRepositories(String itemAtPosition) {
        progressBarVisibility.set(View.VISIBLE);

        final Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH,-7);
        String text = DateFormat.format("yyyy-MM-dd",calendar).toString();

        Observable<GitHubService.Repositories> observable = (Observable<GitHubService.Repositories>) gitHubService.listRepos("language:"+itemAtPosition + " " + "created:>" + text);
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<GitHubService.Repositories>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                repositoryListViewContract.showError();
            }

            @Override
            public void onNext(GitHubService.Repositories repositories) {
                progressBarVisibility.set(View.GONE);
                repositoryListViewContract.showRepositories(repositories);
            }
        });

    }
}

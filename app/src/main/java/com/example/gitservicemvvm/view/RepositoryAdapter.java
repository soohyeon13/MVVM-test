package com.example.gitservicemvvm.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.gitservicemvvm.contract.RepositoryListViewContract;

public class RepositoryAdapter extends RecyclerView.Adapter<RepositoryAdapter.RepoViewHolder> {
    private final Context context;
    private final RepositoryListViewContract repositoryListViewContract;

    public RepositoryAdapter(Context context, RepositoryListViewContract repositoryListViewContract) {
        this.context = context;
        this.repositoryListViewContract = repositoryListViewContract;
    }

    @NonNull
    @Override
    public RepoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RepoViewHolder repoViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class RepoViewHolder extends RecyclerView.ViewHolder {
        public RepoViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}

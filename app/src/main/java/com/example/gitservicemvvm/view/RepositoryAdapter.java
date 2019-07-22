package com.example.gitservicemvvm.view;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gitservicemvvm.R;
import com.example.gitservicemvvm.contract.RepositoryListViewContract;
import com.example.gitservicemvvm.databinding.RepoItemBinding;
import com.example.gitservicemvvm.model.GitHubService;
import com.example.gitservicemvvm.viewmodel.RepositoryItemViewModel;

import java.util.List;

public class RepositoryAdapter extends RecyclerView.Adapter<RepositoryAdapter.RepoViewHolder> {
    private final Context context;
    private final RepositoryListViewContract view;
    private List<GitHubService.RepositoryItem> item;

    public void setItemsAndRefresh(List<GitHubService.RepositoryItem> item) {
        this.item = item;
        notifyDataSetChanged();
    }

    public GitHubService.RepositoryItem getItemAt(int position) {
        return item.get(position);
    }



    public RepositoryAdapter(Context context, RepositoryListViewContract view) {
        this.context = context;
        this.view = view;
    }

    @NonNull
    @Override
    public RepoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        RepoItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.repo_item,viewGroup,false);
        binding.setViewModel(new RepositoryItemViewModel(view));
        return new RepoViewHolder(binding.getRoot(),binding.getViewModel());
    }

    @Override
    public void onBindViewHolder(@NonNull RepoViewHolder repoViewHolder, int i) {
        final GitHubService.RepositoryItem item = getItemAt(i);
        repoViewHolder.loadItem(item);
    }

    @Override
    public int getItemCount() {
        if (item == null) {
            return 0;
        }
        return item.size();
    }

    public class RepoViewHolder extends RecyclerView.ViewHolder {
        private final RepositoryItemViewModel viewModel;

        public RepoViewHolder(@NonNull View itemView, RepositoryItemViewModel viewModel) {
            super(itemView);
            this.viewModel = viewModel;
        }
        public void loadItem(GitHubService.RepositoryItem item) {
            viewModel.loadItem(item);
        }

    }
}

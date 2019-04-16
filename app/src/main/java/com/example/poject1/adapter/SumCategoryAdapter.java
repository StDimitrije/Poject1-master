package com.example.poject1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.poject1.R;
import com.example.poject1.model.Category;
import com.example.poject1.util.CategoryDiffCallback;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

public class SumCategoryAdapter extends RecyclerView.Adapter<SumCategoryAdapter.SumCategoryHolder> {


    private List<Category> mCategoryList;

    public SumCategoryAdapter(){
        mCategoryList= new ArrayList<>();
    }

    @NonNull
    @Override
    public SumCategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.third_fragment_list_item, parent, false);

        return new SumCategoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SumCategoryHolder holder, int position) {
        Category category = mCategoryList.get(position);
        holder.mTitle.setText(category.getmName() + ": " + category.getmSum() + " din.");

    }

    @Override
    public int getItemCount() {
        return mCategoryList.size();
    }

    public void setData(List<Category> categories) {
        CategoryDiffCallback callback = new CategoryDiffCallback(mCategoryList, categories);
        DiffUtil.DiffResult result = DiffUtil.calculateDiff(callback);
        mCategoryList.clear();
        mCategoryList.addAll(categories);
        result.dispatchUpdatesTo(this);
    }

    public class SumCategoryHolder extends RecyclerView.ViewHolder {
        private TextView mTitle;
        public SumCategoryHolder(@NonNull View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.third_li_tv_title);
        }
    }
}

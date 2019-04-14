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

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryHolder> {

    private List<Category> mCategoryList;


    public CategoryAdapter(){

        mCategoryList = new ArrayList<>();
    }

    @NonNull
    @Override
    public CategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.fourth_fragment_list_item, parent, false);

        return new CategoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryHolder holder, int position) {
        Category category = mCategoryList.get(position);
        holder.mTitle.setText(category.getmName());
    }

    @Override
    public int getItemCount() {
        return mCategoryList.size();
    }

    public void setData(List<Category> categories){
        CategoryDiffCallback callback = new CategoryDiffCallback(mCategoryList, categories);
        DiffUtil.DiffResult result = DiffUtil.calculateDiff(callback);
        mCategoryList.clear();
        mCategoryList.addAll(categories);
        result.dispatchUpdatesTo(this);


    }

    public class CategoryHolder extends RecyclerView.ViewHolder {
        private TextView mTitle;
        public CategoryHolder(@NonNull View itemView) {
            super(itemView);

            mTitle = itemView.findViewById(R.id.fourth_li_tv_title);

        }
    }
}

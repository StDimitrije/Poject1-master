package com.example.poject1.util;

import com.example.poject1.model.Category;

import java.util.List;

import androidx.recyclerview.widget.DiffUtil;

public class CategoryDiffCallback extends DiffUtil.Callback {

    private List<Category> mOldList;
    private List<Category> mNewList;

    public CategoryDiffCallback(List<Category> oldList, List<Category> newList){
        mOldList = oldList;
        mNewList = newList;
    }

    @Override
    public int getOldListSize() {
        return mOldList.size();
    }

    @Override
    public int getNewListSize() {
        return mNewList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        Category oldStudent = mOldList.get(oldItemPosition);
        Category newStudent = mNewList.get(newItemPosition);
        return oldStudent.getmId() == newStudent.getmId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        Category oldStudent = mOldList.get(oldItemPosition);
        Category newStudent = mNewList.get(newItemPosition);
        return oldStudent.getmName().equals(newStudent.getmName());
    }
}

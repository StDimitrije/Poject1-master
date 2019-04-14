package com.example.poject1.util;

import com.example.poject1.model.Expense;

import java.util.List;

import androidx.recyclerview.widget.DiffUtil;

public class ExpensesDiffCallback extends DiffUtil.Callback {

    private List<Expense> mOldList;
    private List<Expense> mNewList;

    public ExpensesDiffCallback(List<Expense> newList, List<Expense> oldList)
    {
        mNewList = newList;
        mOldList = oldList;
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
        Expense oldExpense = mOldList.get(oldItemPosition);
        Expense newExpense = mNewList.get(newItemPosition);

        return oldExpense.getmId() == newExpense.getmId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        Expense oldExpense = mOldList.get(oldItemPosition);
        Expense newExpense = mNewList.get(newItemPosition);

        return oldExpense.getmTitle().equals(newExpense.getmTitle());
    }
}

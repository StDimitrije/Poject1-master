package com.example.poject1.viewmodels;

import android.icu.util.ULocale;

import com.example.poject1.model.Category;
import com.example.poject1.model.Expense;
import com.example.poject1.util.Util;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {


    private MutableLiveData<List<Category>> mCategoryLiveData;
    private MutableLiveData<List<Expense>> mExpensesLiveData;
    private List<Category> mCategoryList;
    private List<Expense> mExpensesList;

    private MutableLiveData<String> mSpinnerChoiceLiveData;

    private MutableLiveData<String> mPercantageLiveData;




    public MainViewModel(){
        mSpinnerChoiceLiveData = new MutableLiveData<>();
        mExpensesLiveData = new MutableLiveData<>();
        mPercantageLiveData = new MutableLiveData<>();
        mCategoryLiveData = new MutableLiveData<>();
        mCategoryList = new ArrayList<>();
        mExpensesList = new ArrayList<>();

        for(int i=0; i<5; i++){
            mCategoryList.add(new Category(Util.generateId(), "Category" + i));
        }
        mCategoryLiveData.setValue(mCategoryList);

    }



    public MutableLiveData<String> getmSpinnerChoiceLiveData(){
        return mSpinnerChoiceLiveData;
    }

    public void setSpinnerCoice(String choice){
        mSpinnerChoiceLiveData.setValue(choice);
    }


    public MutableLiveData<List<Category>> getCategoryLiveData() {
        return mCategoryLiveData;
    }
    public MutableLiveData<List<Expense>> getExpensesLiveData(){
        return mExpensesLiveData;
    }

    public void addCategory(Category category){
        mCategoryList.add(category);
        mCategoryLiveData.setValue(mCategoryList);
    }

    public void addExpense(Expense expense){
        mExpensesList.add(expense);
        mExpensesLiveData.setValue(mExpensesList);
    }

    public void removeExpense(int position){
        mExpensesList.remove(position);
        mExpensesLiveData.setValue(mExpensesList);
    }

    public void setPercentage(String percentage){

        mPercantageLiveData.setValue(percentage);
    }

    public MutableLiveData<String> getPercentage(){

        return mPercantageLiveData;
    }


    public void setFilter(String filter) {
    }
}

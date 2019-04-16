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


    public MainViewModel(){
        mExpensesLiveData = new MutableLiveData<>();
        mCategoryLiveData = new MutableLiveData<>();
        mCategoryList = new ArrayList<>();
        mExpensesList = new ArrayList<>();

        for(int i=1; i<4; i++){
            mCategoryList.add(new Category(Util.generateId(), "CATEGORY" + i));
        }
        mCategoryLiveData.setValue(mCategoryList);

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

    public Expense getExpense(int index){
        return mExpensesList.get(index);

    }

    public void addExpense(Expense expense){
        mExpensesList.add(expense);
        mExpensesLiveData.setValue(mExpensesList);
    }

    public void removeExpense(int position){
        mExpensesList.remove(position);
        mExpensesLiveData.setValue(mExpensesList);
    }
//    public void addToCategorySum(Category category1,int sum){
//    }

    public void setTitleFilter(String filter) {

        filter = filter.toLowerCase();
        List<Expense> filteredExpenseList = new ArrayList<>();
        for(Expense expense: mExpensesList){
            if(expense.getmTitle().toLowerCase().startsWith(filter)){

                filteredExpenseList.add(expense);
            }
        }
        mExpensesLiveData.setValue(filteredExpenseList);
    }

    public void setCategoryFilter(String filter){
        filter = filter.toLowerCase();
        List<Expense> filteredCategoryList = new ArrayList<>();
        for(Expense expense: mExpensesList){
            if (expense.getmCategory().toLowerCase().startsWith(filter)){

                filteredCategoryList.add(expense);
            }
        }
        mExpensesLiveData.setValue(filteredCategoryList);
    }
}

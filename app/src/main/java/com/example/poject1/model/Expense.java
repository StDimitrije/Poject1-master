package com.example.poject1.model;

public class Expense {

    private int mId;
    private String mTitle;
    private String mCategory;
    private String mCost;
    private String mDate;


    public Expense(int id, String title, String category, String cost, String date){
        mId=id;
        mTitle = title;
        mCategory=category;
        mCost=cost;
        mDate=date;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmCategory() {
        return mCategory;
    }

    public void setmCategory(String mCategory) {
        this.mCategory = mCategory;
    }

    public String getmCost() {
        return mCost;
    }

    public void setmCost(String mCost) {
        this.mCost = mCost;
    }

    public String getmDate() {
        return mDate;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }
}

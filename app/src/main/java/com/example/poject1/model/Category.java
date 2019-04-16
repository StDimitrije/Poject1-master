package com.example.poject1.model;

public class Category {

    private int mId;
    private String mName;
    private int mSum;

    public Category(int id, String name){
        mId = id;
        mName=name;
        mSum = 0;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    @Override
    public String toString() {
        return mName;
    }

    public int getmSum() {
        return mSum;
    }

    public void setmSum(int mSum) {
        this.mSum = mSum;
    }
}

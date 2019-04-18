package com.example.poject1.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.poject1.R;
import com.example.poject1.adapter.SumCategoryAdapter;
import com.example.poject1.model.Category;
import com.example.poject1.model.Expense;
import com.example.poject1.viewcustom.PercentageView;
import com.example.poject1.viewmodels.MainViewModel;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ThirdFragment extends Fragment {

private PercentageView percentageView;
private TextView totalCostView;
private MainViewModel mainViewModel;
private SumCategoryAdapter sumCategoryAdapter;



    public static ThirdFragment newInstance(){

        return new ThirdFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_third_pie, container,false);
        percentageView = view.findViewById(R.id.percentage_view);
        totalCostView = view.findViewById(R.id.third_tv_sum);
        RecyclerView recyclerView = view.findViewById(R.id.third_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        sumCategoryAdapter = new SumCategoryAdapter();
        recyclerView.setAdapter(sumCategoryAdapter);


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mainViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);
        mainViewModel.getCategoryLiveData().observe(getViewLifecycleOwner(), new Observer<List<Category>>() {
            @Override
            public void onChanged(List<Category> categories) {


               sumCategoryAdapter.setData(categories);
               percentageView.setCategoryList(categories);
            }
        });

        mainViewModel.getExpensesLiveData().observe(getViewLifecycleOwner(), new Observer<List<Expense>>() {
            @Override
            public void onChanged(List<Expense> expenses) {


            }
        });
    }
}

package com.example.poject1.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.poject1.R;
import com.example.poject1.viewcustom.PercentageView;
import com.example.poject1.viewmodels.MainViewModel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class ThirdFragment extends Fragment {

private PercentageView percentageView;
private TextView totalCostView;
private MainViewModel mainViewModel;


    public static ThirdFragment newInstance(){

        return new ThirdFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_third_pie, container,false);
        percentageView = view.findViewById(R.id.percentage_view);
        totalCostView = view.findViewById(R.id.third_tv_sum);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mainViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);
        mainViewModel.getPercentage().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                percentageView.setText(s);
            }
        });
    }
}

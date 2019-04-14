package com.example.poject1.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.poject1.R;
import com.example.poject1.adapter.ExpensesAdapter;
import com.example.poject1.model.Category;
import com.example.poject1.model.Expense;
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

public class SecondFragment extends Fragment {

    private Spinner mSpinner;
    private EditText mFilter;
    private Button mBtnApplyCat;
    private RecyclerView mRecyclerView;
    private MainViewModel mainViewModel;
    private ExpensesAdapter mExpensesAdapter;
    private ArrayAdapter<Category> categoryArrayAdapter;


    public static SecondFragment newInstance(){

        return new SecondFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second_show_expense, container,false);
        mSpinner = view.findViewById(R.id.second_spinner);

        categoryArrayAdapter = new ArrayAdapter<>(view.getContext(), android.R.layout.simple_list_item_1, new ArrayList<>());
        mSpinner.setAdapter(categoryArrayAdapter);


        mFilter = view.findViewById(R.id.second_et_filter);

        mBtnApplyCat = view.findViewById(R.id.second_btn_apply_category);
        mBtnApplyCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String filter = mFilter.getText().toString();
                mainViewModel.setFilter(filter);
            }
        });

        mExpensesAdapter = new ExpensesAdapter();
        mExpensesAdapter.setOnRemoveItemCallback(new ExpensesAdapter.OnRemoveItemCallback() {
            @Override
            public void onItemRemove(int position) {

                mainViewModel.removeExpense(position);
                Toast.makeText(getContext(), "Remove expense from position: " + position, Toast.LENGTH_SHORT).show();
            }
        });

        mRecyclerView = view.findViewById(R.id.second_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mExpensesAdapter);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mainViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);

        mainViewModel.getExpensesLiveData().observe(getViewLifecycleOwner(), new Observer<List<Expense>>() {
            @Override
            public void onChanged(List<Expense> expenses) {

               mExpensesAdapter.setData(expenses);
            }
        });

        mainViewModel.getCategoryLiveData().observe(getViewLifecycleOwner(),
                new Observer<List<Category>>() {
                    @Override
                    public void onChanged(List<Category> categories) {
                        categoryArrayAdapter.clear();
                        categoryArrayAdapter.addAll(categories);
                        categoryArrayAdapter.notifyDataSetChanged();
                    }
                });

    }
}

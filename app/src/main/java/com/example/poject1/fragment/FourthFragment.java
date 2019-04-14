package com.example.poject1.fragment;



import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.poject1.R;
import com.example.poject1.activity.MainActivity;
import com.example.poject1.adapter.CategoryAdapter;
import com.example.poject1.model.Category;
import com.example.poject1.util.Util;
import com.example.poject1.viewmodels.MainViewModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FourthFragment extends Fragment {


    private MainViewModel mainViewModel;
    private TextView mTitleTv;
    private EditText mCategoryEt;
    private Button mAddBtn;
    private CategoryAdapter mCategoryAdapter;

    public static FourthFragment newInstance(){
        return new FourthFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fourth_add_category, container, false);
        mTitleTv  = view.findViewById(R.id.fourth_tv_title);
        mCategoryEt = view.findViewById(R.id.fourth_et_category);
        mAddBtn = view.findViewById(R.id.fourth_btn_add);
        mAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String categoryName = mCategoryEt.getText().toString();
                Category category = new Category(Util.generateId(), categoryName);
                mainViewModel.addCategory(category);
                Toast.makeText(FourthFragment.this.getContext(), "Dodata kategorija: " + categoryName, Toast.LENGTH_SHORT).show();
            }
        });

        mCategoryAdapter = new CategoryAdapter();
        RecyclerView recyclerView = view.findViewById(R.id.fourth_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(mCategoryAdapter);


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mainViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);
        mainViewModel.getCategoryLiveData().observe(getViewLifecycleOwner(),
                new Observer<List<Category>>() {
            @Override
            public void onChanged(List<Category> categories) {
                Log.e("kategorije",categories.toString());
                mCategoryAdapter.setData(categories);
            }
        });

    }
}

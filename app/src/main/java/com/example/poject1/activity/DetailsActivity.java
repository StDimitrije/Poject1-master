package com.example.poject1.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.poject1.R;
import com.example.poject1.viewmodels.MainViewModel;
import com.squareup.picasso.Picasso;

import java.net.URL;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity {

    private MainViewModel mainViewModel;
    private TextView mTitleView;
    private TextView mCategoryView;
    private TextView mCostView;
    private TextView mDateView;
    private ImageView mImageVeiw;
    private Button mRemoveBtn;
    private static final String URL = "https://picsum.photos/1080/1920/?random";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        init();
    }

    private void init() {


        mTitleView = findViewById(R.id.details_tv_title);
        mCategoryView = findViewById(R.id.details_tv_category);
        mCostView = findViewById(R.id.details_tv_cost);
        mDateView = findViewById(R.id.details_tv_date);

        mImageVeiw = findViewById(R.id.details_img);
        Picasso.get().load(URL).into(mImageVeiw);

        mRemoveBtn = findViewById(R.id.details_btn_remove);
        mRemoveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}

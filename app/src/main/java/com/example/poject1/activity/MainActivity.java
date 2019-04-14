package com.example.poject1.activity;

import android.os.Bundle;

import com.example.poject1.R;
import com.example.poject1.adapter.FragmentAdapter;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        ViewPager viewPager = findViewById(R.id.view_pager);
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager(), this);
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(3);
        TabLayout tabLayout =findViewById(R.id.tabs_main);
        tabLayout.setupWithViewPager(viewPager);
    }
}

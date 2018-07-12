package com.jonli.regioncode;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jonli.regioncode.model.CodeModel;
import com.jonli.regioncode.model.Model;
import com.jonli.regioncode.presenter.CodePresenter;
import com.jonli.regioncode.presenter.Presenter;

public class MainActivity extends AppCompatActivity {

    private Presenter presenter;

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        Model model = new CodeModel(this);
        presenter = new CodePresenter(model);

        viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(new PagerAdapter(getSupportFragmentManager()));

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabTextColors(Color.GRAY, Color.parseColor("white"));
    }
}

package com.example.android.slikeskulptura;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //pronalazi ViewPager koji ce omoguciti korisniku da svajpuje izmedju fragmenata
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);

        //krira adapter koji zna koji se fragment nalazi na svakoj strani
        CategoryAdapter categoryAdapter = new CategoryAdapter(this,
                getSupportFragmentManager());

        //postavimo adapter na view pager
        viewPager.setAdapter(categoryAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);

        //Povezemo tab layout sa view pager-om. Ovo ce:
        //1.Updejtovati tab layout prilikom svajpovanja(prevlacenja)
        //2.Updejtovati view pager kada se odabere tab
        //3.postavlja naziv tabova
        tabLayout.setupWithViewPager(viewPager);
    }
}

package com.example.ikeak.charactersynopsis;

import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ikeak.charactersynopsis.Fragments.pageFragment1;
import com.example.ikeak.charactersynopsis.Fragments.pageFragment2;
import com.example.ikeak.charactersynopsis.Fragments.pageFragment3;
import com.example.ikeak.charactersynopsis.Fragments.pageFragment4;
import com.example.ikeak.charactersynopsis.Fragments.pageFragment5;

import java.util.ArrayList;
import java.util.List;

public class simpsonActivity extends AppCompatActivity {

    //Viewpager handles the animation
    //
    private ViewPager pager;

    //The adapter provides the pages (fragments) the viewpager will animate.
    private PagerAdapter pageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simpson);

        List<Fragment> fragment = new ArrayList<>();
        fragment.add(new pageFragment1());
        fragment.add(new pageFragment2());
        fragment.add(new pageFragment3());
        fragment.add(new pageFragment4());
        fragment.add(new pageFragment5());

        pager = findViewById(R.id.pager);
        pageAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager(),fragment);
        pager.setAdapter(pageAdapter);
    }
}

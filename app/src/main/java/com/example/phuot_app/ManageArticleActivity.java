package com.example.phuot_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.phuot_app.R;
import com.example.phuot_app.ViewPagerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class ManageArticleActivity extends AppCompatActivity {

    //Khoi tao bien de thao tac voi xml
    int imgs[]= {R.drawable.banner1, R.drawable.banner5, R.drawable.banner3, R.drawable.banner4, R.drawable.banner5};
    TabLayout tabLayout;
    ViewPager2 viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_article);

        // Tao nut Back
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tabs);

        // gắn adapter liên kết từ ViewPagerAdapter lên ViewPager
        viewPager.setAdapter(createCardAdapter());
        // Đặt tên các tab
        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:
                        tab.setIcon(R.drawable.eating);
                        break;
                    case 1:
                        tab.setIcon(R.drawable.place);
                        break;
                    case 2:
                        tab.setIcon(R.drawable.shopping);
                        break;
                }
            }
        }).attach();

        // Nút thêm bài viết nổi
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(), CreateNewArticleActivity.class);
                startActivity(intent);
            }
        });
    }

    // lấy ViewPagerAdapter từ context này để đổ vào setAdapter()
    private ViewPagerAdapter createCardAdapter(){
        ViewPagerAdapter viewPagerAdapter= new ViewPagerAdapter(this);
        return viewPagerAdapter;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // khi bấm nút back sẽ dừng activity hiện tại
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
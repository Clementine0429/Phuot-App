package com.example.phuot_app;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;
import java.util.List;

// quản lý nội dung hiển thị liên quan đến home_layout.xml
public class CardFragment extends Fragment {

    private RecyclerView rvArticles;
    private ArticleAdapter articleAdapter;
    private LinkedList<Article> articles= new LinkedList<Article>();

    private static final String ARG_COUNT = "param1";
    private static Integer counter;
    View rootView;
    ViewFlipper viewFlipper;
    int imgs[]= {R.drawable.banner1, R.drawable.banner5, R.drawable.banner3, R.drawable.banner4, R.drawable.banner5};

    public CardFragment(){

    };
    public static CardFragment newInstance(Integer counter){
        CardFragment fragment= new CardFragment();
        Bundle args= new Bundle();
        args.putInt(ARG_COUNT, counter);
        fragment.setArguments(args);
        return fragment;
    }

    // gắn layout khác nhau vào nội dung của từng tab -> trả ra view
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        switch (getArguments().getInt(ARG_COUNT)){
            case 0:
                rootView= inflater.inflate(R.layout.home_layout, container, false);
                break;
        }
        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!=null){
            counter= getArguments().getInt(ARG_COUNT);
        }
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewFlipper= (ViewFlipper) view.findViewById(R.id.vfBanner);

        rvArticles= view.findViewById(R.id.rv_article);

        articles.add(new Article("Chợ đêm Đà Lạt", "Nhiều cảnh đẹp, đồ ăn ngon với giá cực rẻ","Chuyến đi phượt đến Đà Lạt của chúng tôi diễn ra vào cuối mùa thu. Chúng tôi ngây ngất với vẻ đẹp trong lành của thiên nhiên và sự thân thiện của người dân nơi đây",
        R.drawable.cho_da_lat ));
        articles.add(new Article("Chợ đêm Đà Lạt", "Nhiều cảnh đẹp, đồ ăn ngon với giá cực rẻ","Chuyến đi phượt đến Đà Lạt của chúng tôi diễn ra vào cuối mùa thu. Chúng tôi ngây ngất với vẻ đẹp trong lành của thiên nhiên và sự thân thiện của người dân nơi đây",
                R.drawable.cho_da_lat ));
        articles.add(new Article("Chợ đêm Đà Lạt", "Nhiều cảnh đẹp, đồ ăn ngon với giá cực rẻ","Chuyến đi phượt đến Đà Lạt của chúng tôi diễn ra vào cuối mùa thu. Chúng tôi ngây ngất với vẻ đẹp trong lành của thiên nhiên và sự thân thiện của người dân nơi đây",
                R.drawable.cho_da_lat ));
        articleAdapter= new ArticleAdapter(articles, getActivity());

        rvArticles.setHasFixedSize(true);

        // LinearLayoutManager quản lý hiển thị của RecycleView
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        // đổ LayoutManager và Adapter vào RecycleView
        rvArticles.setLayoutManager(linearLayoutManager);
        rvArticles.setAdapter(articleAdapter);

        for (int img:imgs){
            flipperImages(img);
        }
    }

    public void flipperImages(int img){
        ImageView imageView= new ImageView(getContext());
        imageView.setBackgroundResource(img);

        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(3000); //5sec
        viewFlipper.setAutoStart(true);

        //animation
        viewFlipper.setInAnimation(getContext(), android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(getContext(), android.R.anim.fade_out);
    }
}

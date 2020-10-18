package com.example.phuot_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;
import java.util.List;

//Là cầu nối giữa class Article và CardFragment
public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {

    private LinkedList<Article> Articles= new LinkedList<Article>() {
        @Override
        public Article get(int i) {
            return null;
        }

        @Override
        public Article set(int i, Article article) {
            return null;
        }
    };
    private Context Context;
    private LayoutInflater LayoutInflater;

    //khởi tạo ArticleAdapter
    public ArticleAdapter(LinkedList<Article> articles, android.content.Context context) {
        Articles = articles;
        Context = context;
        LayoutInflater = LayoutInflater.from(context);
    }

    //Holder dịch thoáng: hộp lưu trữ
    // hiển thị từng item theo mẫu article_layout.xml
    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate view from article_layout.xml
        View itemView = LayoutInflater.inflate(R.layout.article_layout, parent, false);
        return new ArticleViewHolder(itemView);
    }

    //Binding dữ liệu vào từng item theo position
    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        //get article in list Articles via position
        Article article = Articles.get(position);

        //bind data to viewholder
        holder.tvArticleHeading.setText(article.getArticleHeading());
        holder.tvArticleSummary.setText(article.getArticleSummary());
        holder.tvContent.setText(article.getContent());
        holder.ivImg.setImageResource(article.img);
    }

    @Override
    public int getItemCount() {
        return Articles.size();
    }

    //khởi tạo Holder
    // có các thuộc tính trung gian kết nối đến các View
    public class ArticleViewHolder extends RecyclerView.ViewHolder{
        private TextView tvArticleHeading;
        private TextView tvArticleSummary;
        private TextView tvContent;
        private ImageView ivImg;
        public ArticleViewHolder(@NonNull View itemView) {
            super(itemView);

            tvArticleHeading= itemView.findViewById(R.id.tvArticleHeading);
            tvArticleSummary= itemView.findViewById(R.id.tvArticleSummary);
            tvContent= itemView.findViewById(R.id.tvContent);
            ivImg= itemView.findViewById(R.id.imageView);
        }
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}

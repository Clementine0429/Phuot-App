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

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {
    private static final String TAG = "ArticleAdapter";
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

    public ArticleAdapter(LinkedList<Article> articles, android.content.Context context) {
        Articles = articles;
        Context = context;
        LayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate view from article_layout.xml
        View itemView = LayoutInflater.inflate(R.layout.article_layout, parent, false);
        return new ArticleViewHolder(itemView);
    }

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

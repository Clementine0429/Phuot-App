package com.example.phuot_app;

public class Article {
    String articleHeading= new String();
    String articleSummary= new String();
    String content= new String();
    int img;

    public Article(String articleHeading, String articleSummary, String content, int img) {
        this.articleHeading = articleHeading;
        this.articleSummary = articleSummary;
        this.content = content;
        this.img = img;
    }

    public Article() {
    }

    public String getArticleHeading() {
        return articleHeading;
    }

    public void setArticleHeading(String articleHeading) {
        this.articleHeading = articleHeading;
    }

    public String getArticleSummary() {
        return articleSummary;
    }

    public void setArticleSummary(String articleSummary) {
        this.articleSummary = articleSummary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}

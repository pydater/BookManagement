package com.firstspringboot.domain;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "bookset")
public class Book{
    @Field("书名")
    private String name;
    @Field("作者")
    private String author;
    @Field("出版社")
    private String press;
    @Field("副标题")
    private String subtitle;
    @Field("译者")
    private String translator;
    @Field("出版年")
    private String time;
    @Field("页数")
    private String page;
    @Field("定价")
    private String price;
    @Field("装帧")
    private String binding;
    @Field("丛书")
    private String series;
    @Field("image_urls")
    private String image_url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBinding() {
        return binding;
    }

    public void setBinding(String binding) {
        this.binding = binding;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", press='" + press + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", translator='" + translator + '\'' +
                ", time='" + time + '\'' +
                ", page='" + page + '\'' +
                ", price='" + price + '\'' +
                ", binding='" + binding + '\'' +
                ", series='" + series + '\'' +
                ", image_url='" + image_url + '\'' +
                '}';
    }
}

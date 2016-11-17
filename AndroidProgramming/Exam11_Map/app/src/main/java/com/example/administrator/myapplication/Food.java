package com.example.administrator.myapplication;

import android.graphics.Bitmap;

public class Food {
    private Bitmap image; //그림에 대한 데이터를 직접 가지고있는 비트맵데이터
    private Bitmap imageLarge; //그림에 대한 데이터를 직접 가지고있는 비트맵데이터
    private String imageFileName; //그림파일에 대한 그림파일명
    private String imageLargeFileName; //그림파일에 대한 그림파일명
    private String title;
    private String price;
    private String content;


    public Food() {
    }

    public Bitmap getImage() {
        return image;
    }
    public void setImage(Bitmap image) {
        this.image = image;
    }

    public Bitmap getImageLarge() {
        return imageLarge;
    }
    public void setImageLarge(Bitmap imageLarge) {
        this.imageLarge = imageLarge;
    }

    public String getImageFileName() {
        return imageFileName;
    }
    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    public String getImageLargeFileName() {
        return imageLargeFileName;
    }
    public void setImageLargeFileName(String imageLargeFileName) {
        this.imageLargeFileName = imageLargeFileName;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
}


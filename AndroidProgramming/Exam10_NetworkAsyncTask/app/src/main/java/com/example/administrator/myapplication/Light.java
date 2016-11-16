package com.example.administrator.myapplication;

import android.graphics.Bitmap;

public class Light {
    private Bitmap image; //그림에 대한 데이터를 직접 가지고있는 비트맵데이터
    private Bitmap imageLarge; //그림에 대한 데이터를 직접 가지고있는 비트맵데이터
    private String imageFileName; //그림파일에 대한 그림파일명
    private String imageLargeFileName; //그림파일에 대한 그림파일명
    private String title;
    private String content;

    public Light() {
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Bitmap getImageLarge() {
        return imageLarge;
    }

    public void setImageLarge(Bitmap imageLarge) {
        this.imageLarge = imageLarge;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}


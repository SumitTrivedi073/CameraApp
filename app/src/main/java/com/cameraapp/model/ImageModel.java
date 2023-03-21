package com.cameraapp.model;

public class ImageModel {
    String name,ImagePath;
    boolean isImageSelected;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagePath() {
        return ImagePath;
    }

    public void setImagePath(String imagePath) {
        ImagePath = imagePath;
    }

    public boolean isImageSelected() {
        return isImageSelected;
    }

    public void setImageSelected(boolean imageSelected) {
        isImageSelected = imageSelected;
    }
}

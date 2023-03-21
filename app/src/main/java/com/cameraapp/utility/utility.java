package com.cameraapp.utility;

import android.content.Context;
import android.content.SharedPreferences;

import com.cameraapp.model.ImageModel;
import com.google.gson.Gson;

import java.util.List;

public class utility {
    private static final String PREFERENCE = "CameraApp";
    private static final String CameraAppImage = "CameraAppImage";
    public static String getSharedPreferences(Context context) {
        SharedPreferences settings = context.getSharedPreferences(PREFERENCE, 0);
        return settings.getString(CameraAppImage, null);
    }

    public static void setSharedPreference(Context context, List<ImageModel> imageArrayList) {
        SharedPreferences settings = context.getSharedPreferences(PREFERENCE, 0);
        SharedPreferences.Editor editor = settings.edit();
        Gson gson = new Gson();
        String json = gson.toJson(imageArrayList);
        editor.putString(CameraAppImage, json);
        editor.commit();
    }
}

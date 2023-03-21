package com.cameraapp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.cameraapp.R;
import com.cameraapp.model.ImageModel;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<ImageModel> imageModelList;
    Context mcontext;
    private ImageSelectionListener docSelectionListener;

    public CustomAdapter(Context contact_, List<ImageModel> listdata) {
        this.imageModelList = listdata;
        this.mcontext = contact_;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View  listItem = layoutInflater.inflate(R.layout.imagelistitem, parent, false);

        return new ViewHolder(listItem);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder
            , @SuppressLint("RecyclerView") final int position) {

        if (holder instanceof ViewHolder) {
            ViewHolder viewHolder = (ViewHolder) holder;

            final ImageModel imageModel = imageModelList.get(position);

            ((ViewHolder) holder).title.setText(imageModel.getName());

            if(imageModel.isImageSelected()){
                ((ViewHolder) holder).image.setImageResource(R.drawable.ic_baseline_check_circle_24);
            }else {
                ((ViewHolder) holder).image.setImageResource(R.drawable.ic_baseline_cancel_24);
            }

            ((ViewHolder) holder).cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    docSelectionListener.ImageSelectionListener(imageModel,position);
                }
            });
        }
    }


    @Override
    public int getItemCount() {
        return imageModelList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        ImageView image;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            image = itemView.findViewById(R.id.image);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
    public void ImageSelection(ImageSelectionListener actDocList) {
        try {
            docSelectionListener = actDocList;
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }

    public interface ImageSelectionListener {
        void ImageSelectionListener(ImageModel imageModelList,int position);
    }

}

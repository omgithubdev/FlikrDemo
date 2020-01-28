package com.omagrahari.flickrApp.ui.home.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.omagrahari.flickrApp.R;
import com.omagrahari.flickrApp.databinding.LayoutPhotoItemBinding;
import com.omagrahari.flickrApp.entiry.Photos;

import java.util.List;

import static com.omagrahari.flickrApp.ui.details.DetailsActivity.getStartedDetailsActivity;


/**
 * Created by omprakash on 28,January,2020
 */
public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.ViewHolder> {
    List<Photos> photosList;

    public PhotoAdapter(List<Photos> photosList) {
        this.photosList = photosList;
    }

    @NonNull
    @Override
    public PhotoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        LayoutPhotoItemBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.layout_photo_item, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public int getItemCount() {
        return photosList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoAdapter.ViewHolder holder, int position) {
        holder.binding.setPhoto(photosList.get(position));
        holder.binding.executePendingBindings();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private LayoutPhotoItemBinding binding;

        public ViewHolder(LayoutPhotoItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

            this.binding.getRoot().setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            getStartedDetailsActivity(view.getContext(), photosList.get(getAdapterPosition()));
        }
    }
}


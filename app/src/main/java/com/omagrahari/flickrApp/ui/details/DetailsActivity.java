package com.omagrahari.flickrApp.ui.details;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.omagrahari.flickrApp.R;
import com.omagrahari.flickrApp.databinding.ActivityDetailsBinding;
import com.omagrahari.flickrApp.entiry.Photos;

import static com.omagrahari.flickrApp.util.Constants.PARAM_DETAILS;

public class DetailsActivity extends AppCompatActivity {
    ActivityDetailsBinding binding;
    Photos photos;

    public static void getStartedDetailsActivity(Context context, Photos photos) {
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra(PARAM_DETAILS, photos);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_details);

        if (getIntent() != null) {
            photos = getIntent().getParcelableExtra(PARAM_DETAILS);
            init();
        } else {
            finish();
        }
    }

    private void init() {
        binding.setDetails(photos);
        binding.executePendingBindings();
    }
}

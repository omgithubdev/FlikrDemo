package com.omagrahari.flickrApp.ui.home;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.omagrahari.flickrApp.R;
import com.omagrahari.flickrApp.databinding.ActivityMainBinding;
import com.omagrahari.flickrApp.entiry.Photos;
import com.omagrahari.flickrApp.entiry.ResponsePhotos;
import com.omagrahari.flickrApp.ui.home.adapter.PhotoAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import static com.omagrahari.flickrApp.FlickrApplication.getFlickrApplication;

public class MainActivity extends AppCompatActivity {
    @Inject
    MainViewModelFactory mainViewModelFactory;

    MainViewModel vIewModel;
    ActivityMainBinding binding;
    PhotoAdapter photoAdapter;
    List<Photos> photosList;
    boolean isLoading = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        getFlickrApplication().getComponent().inject(this);

        vIewModel = new ViewModelProvider(this, mainViewModelFactory).get(MainViewModel.class);

        init();
        initObserver();

        setListener();
    }

    private void init() {
        photosList = new ArrayList<>();
        photoAdapter = new PhotoAdapter(photosList);
        binding.rvImages.setAdapter(photoAdapter);
    }

    private void initObserver() {
        vIewModel.getPhotos().observe(this, new Observer<ResponsePhotos>() {
            @Override
            public void onChanged(ResponsePhotos responsePhotos) {
                if (responsePhotos != null) {
                    if (vIewModel.page >= responsePhotos.getPhotos().getPages())
                        vIewModel.lastPage = true;

                    isLoading = false;
                    binding.progressCircular.setVisibility(View.GONE);
                    photosList.addAll(responsePhotos.getPhotos().getPhotoList());
                    photoAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    public void search(View view) {
        if (binding.etSearch.getText().toString().equalsIgnoreCase("")) {
            Toast.makeText(this, getString(R.string.search_error_no_text), Toast.LENGTH_LONG).show();
        } else {
            vIewModel.page = 0;
            photosList.clear();
            photoAdapter.notifyDataSetChanged();
            binding.progressCircular.setVisibility(View.VISIBLE);
            vIewModel.searchTxt = binding.etSearch.getText().toString();
            vIewModel.requestPhotos();
        }
    }

    private void setListener() {
        binding.rvImages.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (dy > 0) //check for scroll down
                {
                    final int visibleThreshold = 2;

                    GridLayoutManager layoutManager = (GridLayoutManager) binding.rvImages.getLayoutManager();
                    int lastItem = layoutManager.findLastCompletelyVisibleItemPosition();
                    int currentTotalCount = layoutManager.getItemCount();

                    if (currentTotalCount <= lastItem + visibleThreshold && !isLoading) {
                        //show your loading view
                        // load content in background
                        if (vIewModel.requestPhotos()) {
                            isLoading = true;
                            binding.progressCircular.setVisibility(View.VISIBLE);
                        } else {
                            binding.tvEnd.setVisibility(View.VISIBLE);
                        }
                    }
                }
            }
        });
    }
}

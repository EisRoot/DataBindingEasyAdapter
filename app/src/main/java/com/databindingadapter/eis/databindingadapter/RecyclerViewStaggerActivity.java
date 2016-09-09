package com.databindingadapter.eis.databindingadapter;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.databindingadapter.eis.databindingadapter.databinding.ActivityRecyclerViewStaggerBinding;

public class RecyclerViewStaggerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityRecyclerViewStaggerBinding binding= DataBindingUtil.setContentView(this,R.layout.activity_recycler_view_stagger);
        MainActivityViewModel viewModel=new MainActivityViewModel();
        viewModel.viewModels.add(new ItemImageType());
        viewModel.viewModels.add(new ItemTextType("easy"));
        viewModel.viewModels.add(new ItemMixupType());
        viewModel.viewModels.add(new ItemTextType());
        viewModel.viewModels.add(new ItemMixupType());
        viewModel.viewModels.add(new ItemTextType("hello"));
        viewModel.viewModels.add(new ItemMixupType());
        viewModel.viewModels.add(new ItemImageType());
        viewModel.viewModels.add(new ItemMixupType());
        binding.setMain(viewModel);

    }
}

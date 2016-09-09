package com.databindingadapter.eis.databindingadapter;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.databindingadapter.eis.databindingadapter.databinding.ActivityRecyclerViewGridBinding;

public class RecyclerViewGridActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityRecyclerViewGridBinding binding= DataBindingUtil.setContentView(this,R.layout.activity_recycler_view_grid);
        MainActivityViewModel viewModel=new MainActivityViewModel();
        viewModel.viewModels.add(new ItemImageType());
        viewModel.viewModels.add(new ItemTextType());
        viewModel.viewModels.add(new ItemMixupType());
        viewModel.viewModels.add(new ItemTextType());
        viewModel.viewModels.add(new ItemTextType());
        viewModel.viewModels.add(new ItemTextType());
        viewModel.viewModels.add(new ItemMixupType());
        viewModel.viewModels.add(new ItemImageType());
        viewModel.viewModels.add(new ItemMixupType());
        binding.setMain(viewModel);



    }
}

package com.databindingadapter.eis.databindingadapter;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.databindingadapter.eis.databindingadapter.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding= DataBindingUtil.setContentView(this,R.layout.activity_main);

        MainActivityViewModel viewModel=new MainActivityViewModel();

        ItemTextType itemTextType;


        itemTextType = new ItemTextType();
        itemTextType.setText("listView Demo");
        itemTextType.setClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ListViewActivity.class));
            }
        });
        viewModel.viewModels.add(itemTextType);


        itemTextType = new ItemTextType();
        itemTextType.setText("RecyclerView Demo");
        itemTextType.setClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,RecylerViewActivity.class));
            }
        });

        viewModel.viewModels.add(itemTextType);
        itemTextType = new ItemTextType();
        itemTextType.setText("RecyclerViewWithGrid Demo");
        itemTextType.setClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,RecyclerViewGridActivity.class));
            }
        });
        viewModel.viewModels.add(itemTextType);



        itemTextType = new ItemTextType();
        itemTextType.setText("RecyclerViewWithStaggered Demo");
        itemTextType.setClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,RecyclerViewStaggerActivity.class));
            }
        });
        viewModel.viewModels.add(itemTextType);

        binding.setMain(viewModel);


        viewModel.notifyChange();

    }
}

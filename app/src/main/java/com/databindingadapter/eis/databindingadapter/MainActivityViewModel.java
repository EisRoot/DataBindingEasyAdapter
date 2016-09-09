package com.databindingadapter.eis.databindingadapter;

import android.databinding.BaseObservable;
import android.databinding.Observable;
import android.databinding.ObservableArrayList;

import com.databindingadapter.eis.databindingeasyadapter.ViewModel;

/**
 * Created by glx002 on 16/9/9.
 */
public class MainActivityViewModel extends BaseObservable {
    public ObservableArrayList<ViewModel> viewModels = new ObservableArrayList<>();



}

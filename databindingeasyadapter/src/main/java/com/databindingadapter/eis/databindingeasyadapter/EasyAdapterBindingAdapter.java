package com.databindingadapter.eis.databindingeasyadapter;

import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayList;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by glx002 on 16/9/9.
 */
public class EasyAdapterBindingAdapter {
    @BindingAdapter("ra_bind")
    public static <T extends ViewModel>void recyclerAdapterBind(RecyclerView recyclerView, ObservableArrayList<T> list){
        if (recyclerView.getAdapter()==null) {
            DataBindingRecyclerAdaptar<T> adaptar =
                    new DataBindingRecyclerAdaptar<>();
            adaptar.setList(list);
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), LinearLayoutManager.VERTICAL, false));
            recyclerView.setAdapter(adaptar);
            recyclerView.setFocusable(false);
        }else {
            ((DataBindingRecyclerAdaptar<T>)recyclerView.getAdapter()).setList(list);;
            ((DataBindingRecyclerAdaptar<T>)recyclerView.getAdapter()).notifyDataSetChanged();

        }
    }
}

package com.databindingadapter.eis.databindingeasyadapter;

import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayList;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ListView;

/**
 * Created by Eis on 16/9/9.
 * @author Eis
 */
public class EasyAdapterBindingAdapter {
    @BindingAdapter("RA_bind")
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
    @BindingAdapter({"RA_bind_G","RA_span"})
    public static <T extends ViewModel>void recyclerAdapterGridBind(RecyclerView recyclerView, ObservableArrayList<T> list,int span){
        if (recyclerView.getAdapter()==null) {
            DataBindingRecyclerAdaptar<T> adaptar =
                    new DataBindingRecyclerAdaptar<>();
            adaptar.setList(list);
            recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(),span));
            recyclerView.setAdapter(adaptar);
            recyclerView.setFocusable(false);
        }else {
            ((DataBindingRecyclerAdaptar<T>)recyclerView.getAdapter()).setList(list);;
            ((DataBindingRecyclerAdaptar<T>)recyclerView.getAdapter()).notifyDataSetChanged();

        }
    }
    @BindingAdapter({"RA_bind_S","RA_span"})
    public static <T extends ViewModel>void recyclerAdapterStaggerdBind(RecyclerView recyclerView, ObservableArrayList<T> list,int span){
        if (recyclerView.getAdapter()==null) {
            DataBindingRecyclerAdaptar<T> adaptar =
                    new DataBindingRecyclerAdaptar<>();
            adaptar.setList(list);
            recyclerView.setLayoutManager(new StaggeredGridLayoutManager(span,StaggeredGridLayoutManager.VERTICAL));
            recyclerView.setAdapter(adaptar);
            recyclerView.setFocusable(false);
        }else {
            ((DataBindingRecyclerAdaptar<T>)recyclerView.getAdapter()).setList(list);;
            ((DataBindingRecyclerAdaptar<T>)recyclerView.getAdapter()).notifyDataSetChanged();

        }
    }
    @BindingAdapter("BA_bind")
    public static <T extends ViewModel> void baseAdaptarBind(ListView listView, ObservableArrayList<T> list){
        if (listView.getAdapter()==null) {
            DataBindingBaseAdaptar<T> adaptar =
                    new DataBindingBaseAdaptar<>();
            adaptar.setList(list);
            listView.setAdapter(adaptar);
            listView.setFocusable(false);
        }else {
            ((DataBindingBaseAdaptar<T>)listView.getAdapter()).setList(list);;
            ((DataBindingBaseAdaptar<T>)listView.getAdapter()).notifyDataSetChanged();

        }
    }

    @BindingAdapter("click")
    public static void setlistener(View view, View.OnClickListener listener){
        if (listener!=null)view.setOnClickListener(listener);
    }
}

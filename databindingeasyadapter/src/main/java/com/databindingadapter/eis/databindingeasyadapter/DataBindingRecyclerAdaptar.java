package com.databindingadapter.eis.databindingeasyadapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by Eis on 2016/7/5.
 */
public  class DataBindingRecyclerAdaptar<T extends ViewModel> extends RecyclerView.Adapter {
    ObservableArrayList<T> list = new ObservableArrayList<>();


    public DataBindingRecyclerAdaptar() {

    }


    public void setList(ObservableArrayList<T> list) {
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding binding= DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), viewType,parent,false);
        MyViewHolder viewHolder=new MyViewHolder(binding.getRoot());
        viewHolder.setBinding(binding);
        return viewHolder;
    }

    @Override
    public int getItemViewType(int position) {
        return list.get(position).getLayout_id();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder holder1= (MyViewHolder) holder;
        list.get(position).setPositon(position);
        holder1.getBinding().setVariable(list.get(position).getBr_id(),list.get(position));
        holder1.getBinding().executePendingBindings();
    }
    /*@Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }*/

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private ViewDataBinding binding;

        public MyViewHolder(View itemView) {
            super(itemView);
        }

        public void setBinding(ViewDataBinding binding) {
            this.binding = binding;
        }

        public ViewDataBinding getBinding() {
            return this.binding;
        }
    }

}
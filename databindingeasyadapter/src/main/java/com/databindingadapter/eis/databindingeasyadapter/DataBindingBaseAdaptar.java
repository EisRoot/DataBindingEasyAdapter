package com.databindingadapter.eis.databindingeasyadapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by Eis on 2016/8/9.
 */

public class DataBindingBaseAdaptar<T extends ViewModel> extends BaseAdapter {
    ObservableArrayList<T> list = new ObservableArrayList<>();



    public void setList(ObservableArrayList<T> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHolder viewHolder;
        ViewDataBinding binding;
        if (convertView==null){
            binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), list.get(position).getLayout_id(),parent,false);
            convertView=binding.getRoot();
            viewHolder=new MyViewHolder(convertView);
            viewHolder.setBinding(binding);
            convertView.setTag(viewHolder);
        }else{
            viewHolder= (MyViewHolder) convertView.getTag();
            binding=viewHolder.getBinding();
        }
        list.get(position).setPositon(position);
        binding.setVariable(list.get(position).getBr_id(),list.get(position));
        binding.executePendingBindings();


        return convertView;
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

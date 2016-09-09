package com.databindingadapter.eis.databindingeasyadapter;

import android.databinding.BaseObservable;

/**
 * Created by glx002 on 16/9/9.
 */
public class ViewModel extends BaseObservable {
    private int layout_id;
    private int br_id;
    private int positon;

    public int getLayout_id() {
        return layout_id;
    }

    public void setLayout_id(int layout_id) {
        this.layout_id = layout_id;
    }

    public int getBr_id() {
        return br_id;
    }

    public void setBr_id(int br_id) {
        this.br_id = br_id;
    }

    public int getPositon() {
        return positon;
    }

    public void setPositon(int positon) {
        this.positon = positon;
    }
}

package com.databindingadapter.eis.databindingadapter;

import com.databindingadapter.eis.databindingeasyadapter.ViewModel;

/**
 * Created by glx002 on 16/9/9.
 */
public class ItemMixupType extends ViewModel {
    {
        setLayout_id(R.layout.item_mixup_type);
        setBr_id(com.databindingadapter.eis.databindingadapter.BR.itemMixup);
    }
    private String text="text from mixup Type";

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

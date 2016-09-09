package com.databindingadapter.eis.databindingadapter;

import com.databindingadapter.eis.databindingeasyadapter.ViewModel;
import com.google.common.base.Strings;

/**
 * Created by glx002 on 16/9/9.
 */
public class ItemTextType extends ViewModel {
    {
        setLayout_id(R.layout.item_text_type);
        setBr_id(com.databindingadapter.eis.databindingadapter.BR.itemText);
    }
    private String text="text from databinding";

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

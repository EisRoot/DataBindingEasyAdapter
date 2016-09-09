package com.databindingadapter.eis.databindingadapter;

import android.view.View;
import android.widget.Toast;

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

    public ItemTextType() {
    }

    public ItemTextType(String text) {
        this.text = text;
    }

    private String text="text";

    private View.OnClickListener click=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(),"the position is "+getPositon(),Toast.LENGTH_SHORT).show();
        }
    };

    public View.OnClickListener getClick() {
        return click;
    }

    public void setClick(View.OnClickListener click) {
        this.click = click;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

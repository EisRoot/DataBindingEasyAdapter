package com.databindingadapter.eis.databindingadapter;

import android.view.View;
import android.widget.Toast;

import com.databindingadapter.eis.databindingadapter.BR;
import com.databindingadapter.eis.databindingeasyadapter.ViewModel;

/**
 * Created by glx002 on 16/9/9.
 */
public class ItemImageType extends ViewModel {
    {
        setLayout_id(R.layout.item_image_type);
        setBr_id(BR.itemImage);
    }
    private View.OnClickListener click=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(),"the position is"+getPositon(),Toast.LENGTH_SHORT).show();
        }
    };

    public View.OnClickListener getClick() {
        return click;
    }

    public void setClick(View.OnClickListener click) {
        this.click = click;
    }
}

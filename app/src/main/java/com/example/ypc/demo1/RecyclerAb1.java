package com.example.ypc.demo1;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class RecyclerAb1 extends BaseQuickAdapter<String,BaseViewHolder> {
    public RecyclerAb1(@Nullable List<String> data) {
        super(R.layout.cicy2,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.cicyitemtext,item);


        final CheckBox checkBox=    helper.getView(R.id.cicyitemtext);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkBox.setTextColor(Color.BLACK);
                }else{
                    checkBox.setTextColor(null);
                }
            }
        });
    }
}

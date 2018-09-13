package com.example.ypc.demo1;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class RecyclerAb2 extends BaseQuickAdapter<String,BaseViewHolder> {

    private List<String> list;

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;

    }

    public RecyclerAb2(@Nullable List<String> data) {
        super(R.layout.cicy2,data);

    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.cicyitemtext,item);

        
    }
}

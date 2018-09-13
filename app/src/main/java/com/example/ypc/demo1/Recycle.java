package com.example.ypc.demo1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import java.util.List;

public class Recycle extends RecyclerView.Adapter<Recycle.ViewHolder> {
    private Context cityActivity;
    private List<String> state;
    private List<List<String>> city;
    private List<Bean> ppps;
    public Recycle(Context cityActivity, List<String> state, List<List<String>> city, List<Bean> ppps) {
        this.cityActivity = cityActivity;
        this.state = state;
        this.city=city;
       this.ppps=ppps;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(cityActivity).inflate(R.layout.cicy111, null);
        ViewHolder viewHolder=new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.cicyitemtext.setText(state.get(position));
        holder.cicyitemtext.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ppps.get(position).setChecked(true);
                } else {
                    ppps.get(position).setChecked(false);


                }
            }
        });

        if (ppps.get(position).isChecked()){
            holder.cicyitemtext.setChecked(true);
        }            holder.cicyitemtext.setChecked(false);

        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(holder.cicyitemtext,position);
                holder.cicyitemtext.setChecked(true);

            }
        });
    }

    @Override
    public int getItemCount() {
        return state.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public CheckBox cicyitemtext;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.cicyitemtext = (CheckBox) rootView.findViewById(R.id.cicyitemtext111);

        }

    }

    public interface OnItemClickListener {
         void onItemClick(View view, int postion);
    }
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}

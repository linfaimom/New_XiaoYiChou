package com.example.marcus.new_xiaoyichou.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.marcus.new_xiaoyichou.R;

/**
 * Created by marcus on 16-6-4.
 */
public class MyListRecyclerAdapter extends RecyclerView.Adapter<MyListRecyclerAdapter.MyViewHolder> {
    private String[] top;
    private String[] underTop;
    private String[] bottom;
    private int[] images;

    public MyListRecyclerAdapter(int[] images, String[] top, String[] underTop, String[] bottom) {
        this.images = images;
        this.top = top;
        this.underTop = underTop;
        this.bottom = bottom;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.they_list,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.image.setImageResource(images[position]);
        holder.top.setText(top[position]);
        holder.under_top.setText(underTop[position]);
        holder.bottom.setText(bottom[position]);
    }


    @Override
    public int getItemCount() {
        return top == null ? 0 : top.length;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;
        private TextView top,under_top,bottom;

        public MyViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.list_image);
            top = (TextView) itemView.findViewById(R.id.top);
            under_top = (TextView) itemView.findViewById(R.id.under_top);
            bottom = (TextView) itemView.findViewById(R.id.bottom);
        }
    }
}

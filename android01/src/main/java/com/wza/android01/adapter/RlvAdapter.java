package com.wza.android01.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.wza.android01.R;
import com.wza.android01.bean.ListData;

import java.util.ArrayList;

public class RlvAdapter extends RecyclerView.Adapter<RlvAdapter.ViewHolder_a> {
    ArrayList<ListData>list;
    Context context;

    public RlvAdapter(ArrayList<ListData> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void setList(ArrayList<ListData> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder_a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_a, null);
        return new ViewHolder_a(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder_a viewHolder_a, int i) {
        viewHolder_a.tv.setText(list.get(i).getName());
       /* RequestOptions options = RequestOptions.circleCropTransform()
                                            .placeholder(R.drawable.j)
                                            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                                            .skipMemoryCache(true);*/

        RequestOptions options = RequestOptions
                .circleCropTransform()
                .placeholder(R.drawable.j)
                .bitmapTransform(new RoundedCorners(10));
        Glide.with(context).load(list.get(i).getChildren()).apply(options).into(viewHolder_a.iv);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder_a extends RecyclerView.ViewHolder {

        private final ImageView iv;
        private final TextView tv;

        public ViewHolder_a(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv = itemView.findViewById(R.id.tv);
        }
    }
}

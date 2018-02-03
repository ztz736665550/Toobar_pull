package com.example.ztz.toobar_pull;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by ztz on 2018/2/2.
 */

public class MyRecyclerviewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<String> list;
    private Context context;
    private ArrayList<Object> mHeights;

    public MyRecyclerviewAdapter(Context context, ArrayList<String> list) {
        this.context = context;
        this.list = list;

        getRandomHight();
    }

    /**
     * 为瀑布流设置随机值
     */
    public void getRandomHight(){
        mHeights = new ArrayList<>();
        for(int i=0; i < list.size();i++){
            //随机的获取一个范围为200-600直接的高度
            mHeights.add((int)(300+Math.random()*400));
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recylayout, parent, false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof viewholder){
            ViewGroup.LayoutParams layoutParams = ((viewholder) holder).textview.getLayoutParams();
            layoutParams.height = (int) mHeights.get(position);
            ((viewholder) holder).textview.setLayoutParams(layoutParams);

            ((viewholder) holder).textview.setText(list.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class viewholder extends RecyclerView.ViewHolder {
        TextView textview;

        public viewholder(View itemView) {
            super(itemView);

            textview = itemView.findViewById(R.id.textview);
        }
    }
}

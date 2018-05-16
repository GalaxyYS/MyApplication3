package com.bwie.test.huangxing20180509.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.test.huangxing20180509.R;
import com.bwie.test.huangxing20180509.model.DataBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by Galaxy on 2018/5/9.
 */

public class MyAdapter extends RecyclerView.Adapter {

    Context context;
    List<DataBean.NewslistBean> list;


    public MyAdapter(Context context, List<DataBean.NewslistBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int itemViewType = getItemViewType(viewType);

        View view;
        if (itemViewType == 0) {
            view = View.inflate(context, R.layout.fresco_item1, null);
        } else {
            view = View.inflate(context, R.layout.fresco_item2, null);
        }

        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        MyViewHolder myViewHolder = (MyViewHolder) holder;

        //得到条目
        int itemViewType = getItemViewType(position);
        if(itemViewType==0){

            myViewHolder.rcv_title.setText(list.get(position).getTitle());

        }else{

            myViewHolder.rcv_title2.setText(list.get(position).getTitle());
        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {


        if (position % 2 == 0) {
            return 0;
        } else {
            return 1;
        }

    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView rcv_title, rcv_title2;
        private final SimpleDraweeView rcv_img;
        private final SimpleDraweeView rcv_img2;

        public MyViewHolder(View view) {
            super(view);
            //找到两个子布局文件的控件id
            rcv_img = view.findViewById(R.id.rcv_img);
            rcv_title = view.findViewById(R.id.rcv_title);
            rcv_img2 = view.findViewById(R.id.rcv_img2);
            rcv_title2 = view.findViewById(R.id.rcv_title2);
        }

    }
}
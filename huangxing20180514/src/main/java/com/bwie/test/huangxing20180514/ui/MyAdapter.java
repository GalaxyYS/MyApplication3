package com.bwie.test.huangxing20180514.ui;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.test.huangxing20180514.R;
import com.bwie.test.huangxing20180514.bean.JokesBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.JokesViewHolder>{


    private  Context context;
    private  List<JokesBean.DataBean> duanZiBeans;


    public MyAdapter(Context context, List<JokesBean.DataBean> duanZiBeans) {
        this.context = context;
        this.duanZiBeans = duanZiBeans;
    }

    @Override
    public JokesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_duanzi, parent, false);
        JokesViewHolder holder = new JokesViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(JokesViewHolder holder, int position) {


        JokesBean.DataBean bean = duanZiBeans.get(position);

        Uri parse = Uri.parse(String.valueOf(bean.getUser().getIcon()));

        holder.sdv_yuan.setImageURI(parse);
       // holder.sdv_yuan.setImageURI((Uri) bean.getUser().getIcon());
        holder.text_title.setText(bean.getUser().getNickname());
        holder.text_time.setText(bean.getCreateTime());
        holder.text_cont.setText(bean.getContent());
    }

    @Override
    public int getItemCount() {
        return duanZiBeans.size();
    }

    class JokesViewHolder extends RecyclerView.ViewHolder {
        public SimpleDraweeView sdv_yuan;
        public TextView text_title;
        public TextView text_time;
        public TextView text_cont;
        public JokesViewHolder(View itemView) {
            super(itemView);
            sdv_yuan = itemView.findViewById(R.id.sdv_yuan);
            text_title = itemView.findViewById(R.id.text_title);
            text_time = itemView.findViewById(R.id.text_time);
            text_cont = itemView.findViewById(R.id.text_cont);
        }
    }
}

package com.bwie.test.huangxing20180516.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwie.test.huangxing20180516.Bean;
import com.bwie.test.huangxing20180516.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class XrvListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<Bean.NewslistBean> list;
    private LayoutInflater inflater;




    public XrvListAdapter(Context context, List<Bean.NewslistBean> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item, parent, false);
        XlvViewHolder xlvViewHolder = new XlvViewHolder(view);
        return xlvViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        XlvViewHolder xlvViewHolder = (XlvViewHolder) holder;
        final Bean.NewslistBean dataBean = list.get(position);


        String title = list.get(position).getTitle();

        String imgUrl = dataBean.getPicUrl().split("\\|")[0];
//        Glide.with(context).load(imgUrl).into(xlvViewHolder.iv);
        xlvViewHolder.iv.setImageURI(imgUrl);
        xlvViewHolder.tv.setText(title);


        //设置条目监听

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class XlvViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView iv;
        private  TextView tv;

        public XlvViewHolder(View itemView) {
            super(itemView);

            itemView.findViewById(R.id.iv);
            iv = itemView.findViewById(R.id.iv);
            tv = itemView.findViewById(R.id.tv);
        }
    }

    /**
     * 刷新
     *
     * @param templist
     */
    public void refresh(List<Bean.NewslistBean> templist) {
        this.list.clear();
        this.list.addAll(templist);
        notifyDataSetChanged();
    }

    /**
     * 加载更多
     *
     * @param list
     */
    public void loadMore(List<Bean.NewslistBean> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

}

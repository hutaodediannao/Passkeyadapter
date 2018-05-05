package com.hutao.app.passkeyadapter.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.hutao.app.passkeyadapter.viewHolder.PassKeyViewHolder;
import com.hutao.app.passkeyadapter.viewHolderInterface.InterfaceManager;

import java.util.List;

/**
 * 万能适配器
 * Created by 胡涛 on 2018/5/5.
 */

public abstract class PassKeyRecyclerAdapter<T> extends RecyclerView.Adapter<PassKeyViewHolder>{

    public List<T> mList;
    private Context mContext;
    private InterfaceManager.ItemClickPositionListener<T> mItemClickPositionListener;

    public PassKeyRecyclerAdapter(List<T> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    /**
     * 更新整个列表的数据展示
     * @param updateList
     */
    public void updatePassKeyRecyclerAdapter(List<T> updateList) {
        this.mList = updateList;
        notifyDataSetChanged();
    }

    /**
     * 只更新修改的item数据列表
     * 而不是刷新整个列表
     * @param t
     * @param position
     */
    public void updateItemPositionRecyclerAdapter(T t, int position) {
        if (this.mList.size() > position) this.mList.set(position, t);
        notifyItemChanged(position);
    }

    @Override
    public PassKeyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return PassKeyViewHolder.newInstance(parent, mContext, getLayout());
    }

    @Override
    public void onBindViewHolder(PassKeyViewHolder holder, final int position) {
        bindHolder(holder, mList.get(position), position);
        holder.getItemView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mItemClickPositionListener != null)mItemClickPositionListener.onItemClick(position, mList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    /**
     * 设置点击item的事件回调
     * @param mItemClickPositionListener
     */
    public void setItemClickPositionListener(InterfaceManager.ItemClickPositionListener mItemClickPositionListener) {
        this.mItemClickPositionListener = mItemClickPositionListener;
    }

    /**
     * 获取子布局的layout
     * @return
     */
    public abstract int getLayout();

    /**
     * 绑定子布局的内容展示
     * @param holder
     * @param t
     * @param position
     */
    public abstract void bindHolder(PassKeyViewHolder holder, T t, int position);

}

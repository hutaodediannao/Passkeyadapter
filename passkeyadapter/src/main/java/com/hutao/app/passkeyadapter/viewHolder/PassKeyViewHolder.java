package com.hutao.app.passkeyadapter.viewHolder;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.hutao.app.passkeyadapter.viewHolderInterface.InterfaceManager;

import java.io.ByteArrayInputStream;

/**
 * 万能适配holder
 * Created by 胡涛 on 2018/5/5.
 */

public class PassKeyViewHolder extends RecyclerView.ViewHolder{

    private SparseArray<View> mViewSparseArray;
    private View mItemView;
    private Context mContext;

    public static PassKeyViewHolder newInstance(ViewGroup parent, Context context, int layoutId) {
        View itemView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        PassKeyViewHolder passKeyViewHolder = new PassKeyViewHolder(itemView, context);
        return passKeyViewHolder;
    }

    private PassKeyViewHolder(View itemView, Context context) {
        super(itemView);
        this.mContext = context;
        this.mItemView = itemView;
        this.mViewSparseArray = new SparseArray<>();
    }

    public <T> T getView(int viewId) {
        View v = mViewSparseArray.get(viewId);
        if (v == null) {
            v = mItemView.findViewById(viewId);
            mViewSparseArray.put(viewId, v);
        }
        return (T) v;
    }

    public View getItemView() {
        return mItemView;
    }

    /**
     * 设置一个子View的可见性
     * @param viewId
     * @param isVisibity
     * @return
     */
    public PassKeyViewHolder setVisibity(int viewId, boolean isVisibity) {
        View view = getView(viewId);
        if (view != null) view.setVisibility(isVisibity?View.VISIBLE:View.GONE);
        return this;
    }

    /**
     * 设置TextView属性
     * @param textViewId
     * @param string
     * @return
     */
    public PassKeyViewHolder setTextView(int textViewId, String string) {
        TextView textView = getView(textViewId);
        if (null != textView) textView.setText(string);
        return this;
    }

    /**
     * 设置本地资源图片
     * @param imageViewId
     * @param imageResource
     * @return
     */
    public PassKeyViewHolder setImageResource(int imageViewId, int imageResource) {
        ImageView iv = getView(imageViewId);
        if (iv != null) iv.setImageResource(imageResource);
        return this;
    }

    /**
     * 根据一个二进制数据设置一张图片
     * @param iamgeViewId
     * @param byteArray
     * @return
     */
    public PassKeyViewHolder setImageFormByteArray(int iamgeViewId, byte[] byteArray) {
        ByteArrayInputStream in = new ByteArrayInputStream(byteArray);
        Bitmap bitmap = BitmapFactory.decodeStream(in);
        return setImageBitmap(iamgeViewId, bitmap);
    }

    /**
     * 设置一个bitmap
     * @param imageViewId
     * @param bitmap
     * @return
     */
    public PassKeyViewHolder setImageBitmap(int imageViewId, Bitmap bitmap) {
        ImageView iv = getView(imageViewId);
        if (iv != null) iv.setImageBitmap(bitmap);
        return this;
    }

    /**
     * 根据路径加载一张图片，路径可以是本地路径或者网络路径
     * @param imageViewId
     * @param path
     * @param imageLoader
     * @return
     */
    public PassKeyViewHolder loadImageForPath(int imageViewId, String path, InterfaceManager.ImageLoader imageLoader) {
        ImageView iv = getView(imageViewId);
        if (iv != null && imageLoader != null) imageLoader.loadImage(iv, path);
        return this;
    }

    /**
     * 设置CheckBox选择状态
     * @param checkBoxId
     * @param isChecked
     * @return
     */
    public PassKeyViewHolder setCheckBox(int checkBoxId, boolean isChecked) {
        CheckBox checkBox = getView(checkBoxId);
        if (checkBox != null)checkBox.setChecked(isChecked);
        return this;
    }

    /**
     * 自定义控件加载数据框架
     * @param costomViewId
     * @param o
     * @param customWeightLoaderData
     * @return
     */
    public PassKeyViewHolder setCustomWeight(int costomViewId, Object o, InterfaceManager.CustomWeightLoaderData customWeightLoaderData) {
        View view = getView(costomViewId);
        if (view != null) customWeightLoaderData.loadData(view, o);
        return this;
    }

}

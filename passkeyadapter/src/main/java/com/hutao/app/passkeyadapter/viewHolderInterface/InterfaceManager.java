package com.hutao.app.passkeyadapter.viewHolderInterface;

import android.view.View;
import android.widget.ImageView;

/**
 * holder回调
 * Created by 胡涛 on 2018/5/5.
 */

public class InterfaceManager {

    /**
     * 自定义图片加载回调
     */
    public interface ImageLoader{
        void loadImage(ImageView imageView, String imageUrl);
    }

    /**
     * 自定义控件数据加载回调
     * @param <T>
     */
    public interface CustomWeightLoaderData<T>{
        void loadData(View view, T t);
    }

    /**
     * 点击item的回调
     * @param <T>
     */
    public interface ItemClickPositionListener<T>{
        void onItemClick(int position, T t);
    }

}

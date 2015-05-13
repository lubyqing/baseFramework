package com.base.framework.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * PagerAdapter 基类
 */
public abstract class BasePagerAdapter<T> extends PagerAdapter {
    @SuppressWarnings({ "unchecked", "rawtypes" })
    protected ArrayList<T> mData = new ArrayList();
    
    protected LayoutInflater mInflater;
    
    protected Context mContext;
    
    public BasePagerAdapter(Context c) {
        mContext = c;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    
    @Override
    public abstract Object instantiateItem(ViewGroup container, int position);
    
    @Override
    public abstract void destroyItem(ViewGroup container,
                                     int position,
                                     Object object);
    
    @Override
    public int getCount() {
        return mData.size();
    }
    
    public void addItem(final T item) {
        mData.add(item);
        notifyDataSetChanged();
    }
    
    public void addItem(int idx, final T item) {
        mData.add(idx, item);
        notifyDataSetChanged();
    }
    
    public void clearItems() {
        mData.clear();
        notifyDataSetChanged();
    }
    
    public T getItem(int position) {
        return mData.get(position);
    }
}

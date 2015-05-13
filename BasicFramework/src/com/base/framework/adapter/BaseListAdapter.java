package com.base.framework.adapter;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

/**
 * 列表适配器基类
 * 
 */
public abstract class BaseListAdapter<T> extends BaseAdapter {
    
    protected List<T> mList;
    
    protected Activity mContext;
    
    protected ListView mListView;
    
    public BaseListAdapter(Activity context) {
        this.mContext = context;
    }
    
    public int getCount() {
        if (mList != null)
            return mList.size();
        else
            return 0;
    }
    
    public Object getItem(int position) {
        return mList == null ? null : mList.get(position);
    }
    
    public long getItemId(int position) {
        return position;
    }
    
    abstract public View getView(int position,
                                 View convertView,
                                 ViewGroup parent);
    
    public void setList(List<T> list) {
        this.mList = list;
        notifyDataSetChanged();
    }
    
    public void clear() {
        this.mList = null;
        notifyDataSetChanged();
    }
    
    public void addList(List<T> list) {
        if (mList != null) {
            mList.addAll(list);
            notifyDataSetChanged();
        }
    }
    
    public List<T> getList() {
        return mList;
    }
    
    public void setList(T[] list) {
        List<T> arrayList = new ArrayList<T>(list.length);
        for (T t : list) {
            arrayList.add(t);
        }
        setList(arrayList);
    }
    
    public ListView getListView() {
        return mListView;
    }
    
    public void setListView(ListView listView) {
        mListView = listView;
    }
    
    public void remove(int position) {
        if (mList != null) {
            mList.remove(position);
            notifyDataSetChanged();
        }
    }
    
}

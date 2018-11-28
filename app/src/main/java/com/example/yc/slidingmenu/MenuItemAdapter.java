package com.example.yc.slidingmenu;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by yc on 2018/11/26.
 */

public class MenuItemAdapter extends ArrayAdapter<MenuItem> {

    private int resourceId;
    private int mSelect = 0; // 选中项

    public MenuItemAdapter(Context context, int textViewResourceId, List<MenuItem> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MenuItem menuItem = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.item_text_zh = (TextView) view.findViewById (R.id.item_text_zh);
            viewHolder.item_text_en = (TextView) view.findViewById (R.id.item_text_en);
            view.setTag(viewHolder); // 将ViewHolder存储在View中
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag(); // 重新获取ViewHolder
        }
        viewHolder.item_text_zh.setText(menuItem.getItem_text_zh());
        viewHolder.item_text_en.setText(menuItem.getItem_text_en());
        if (mSelect == position) {
            view.findViewById(R.id.mark).setBackgroundColor(getContext().getResources().getColor(R.color.colorPrimary));
            viewHolder.item_text_zh.setTextColor(getContext().getResources().getColor(R.color.colorPrimary));
            viewHolder.item_text_en.setTextColor(getContext().getResources().getColor(R.color.colorPrimary));
        } else {
            view.findViewById(R.id.mark).setBackgroundColor(Color.TRANSPARENT);
            viewHolder.item_text_zh.setTextColor(getContext().getResources().getColor(R.color.gray));
            viewHolder.item_text_en.setTextColor(getContext().getResources().getColor(R.color.gray));
        }
        return view;
    }

    public void changeSelected(int position) {
        if (position != mSelect) {
            mSelect = position;
            notifyDataSetChanged();
        }
    }

    class ViewHolder {
        TextView item_text_zh;
        TextView item_text_en;
    }
}

package com.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.model.DM;
import com.yugioh.R;

import java.util.List;

/**
 * Created by hpl on 2015/12/12.
 */
public class CharacterAdapter extends ArrayAdapter<DM> {
    private int resourceId;
    public CharacterAdapter(Context context, int textViewResourceId, List<DM> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        DM dm = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);
            viewHolder = new ViewHolder();
            viewHolder.dmImage = (ImageView) view.findViewById (R.id.dm_image);
            viewHolder.dmName = (TextView) view.findViewById (R.id.dm_name);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.dmImage.setImageResource(dm.getImageId());
        viewHolder.dmName.setText(dm.getName());
        return view;
    }

    public class ViewHolder {
        ImageView dmImage;
        TextView dmName;
    }
}

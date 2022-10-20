package com.google.profile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TreeAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Tree> CayList;

    public TreeAdapter(Context context, int layout, List<Tree> cayList) {
        this.context = context;
        this.layout = layout;
        this.CayList = cayList;
    }

    @Override
    public int getCount() {
        return CayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        view = inflater.inflate(layout, null);

        TextView txtTen = (TextView) view.findViewById(R.id.textviewTen);
        ImageView imgHinh = (ImageView) view.findViewById(R.id.imageviewHinh);

        Tree tree = CayList.get(i);
        txtTen.setText(tree.getTen());
        imgHinh.setImageResource(tree.getHinh());

        return view;
    }
}

package com.example.expandablelistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class ExpLVAdapter extends BaseExpandableListAdapter{

    private List<String> listCategoria;
    private Map<String, List<Animal>> mapChild;
    private Context context;

    public ExpLVAdapter(Context context, List<String> listCategoria, Map<String, List<Animal>> mapChild) {
        this.context = context;
        this.listCategoria = listCategoria;
        this.mapChild = mapChild;
    }

    @Override
    public int getGroupCount() {
        return listCategoria.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return mapChild.get(listCategoria.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return listCategoria.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mapChild.get(listCategoria.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String tituloCategoria = (String) getGroup(groupPosition);
        convertView = LayoutInflater.from(context).inflate(R.layout.elv_group, null);
        TextView tvGroup = (TextView) convertView.findViewById(R.id.tvGroup);
        tvGroup.setText(tituloCategoria);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        Animal item = (Animal) getChild(groupPosition, childPosition);
        convertView = LayoutInflater.from(context).inflate(R.layout.elv_child, null);
        CircleImageView imvChild = convertView.findViewById(R.id.imv_child);
        TextView tvChild = convertView.findViewById(R.id.tvChild);
        tvChild.setText(item.getName());
        imvChild.setImageResource(item.getImage());
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

}

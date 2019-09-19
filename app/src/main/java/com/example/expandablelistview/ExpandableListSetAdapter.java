package com.example.expandablelistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

class ExpandableListSetAdapter extends BaseExpandableListAdapter {
    Context context;
    List<String> _listDataHeader;
    HashMap<String, List<String>> _listDataChild;

    public ExpandableListSetAdapter(MainActivity mainActivity, List<String> listDataHeader, HashMap<String, List<String>> listDataChild) {
        this.context = mainActivity;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listDataChild;
    }

    @Override
    public int getGroupCount() {
        return this._listDataHeader.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this._listDataHeader.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int ChildPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition)).get(ChildPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int ChildPosition) {
        return ChildPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean b, View view, ViewGroup viewGroup) {
        return null;
    }

    @Override
    public View getChildView(int groupPosition, int ChildPosition, boolean b, View view, ViewGroup viewGroup) {
        final String childText = (String) getChild(groupPosition, ChildPosition);
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_item, null);
        }
        TextView txtListChild = view.findViewById(R.id.lblListItem);
        txtListChild.setText(childText);
        return view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int ChildPosition) {
        return true;
    }
}

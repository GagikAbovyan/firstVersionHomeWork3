package ru.startandroid.week2homework3;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Gagik on 07.07.2018.
 */

public class MyListAdapter extends ArrayAdapter {

    private Context context;
    private List<ChatItem> list;
    private int recource;

    MyListAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.context = context;
        this.list = objects;
        this.recource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.layout_for_listvew_for_chat, parent, false);
        }
        TextView bot = view.findViewById(R.id.bot);
        TextView user = view.findViewById(R.id.user);
        user.setText(list.get(position).getUserMessage());
        bot.setText(list.get(position).getBotMessage());
        return view;
    }
}

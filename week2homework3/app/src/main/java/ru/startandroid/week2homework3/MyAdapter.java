package ru.startandroid.week2homework3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.PersonViewHolder> {


    private List<Person> list;
    private Context context;
    static String KEY_1 = "KEY1";
    static String KEY_2 = "KEY2";
    static String KEY_3 = "KEY3";

    MyAdapter(List<Person> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, parent, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {
        Person person = list.get(position);
        holder.personPhoto.setImageResource(person.getPhotoId());
        holder.personName.setText(person.getName());
        holder.personStatus.setText(person.getStatus());
        if (person.getStatus().equals("In Search")) {
            holder.personStatus.setTextColor(context.getResources().getColor(R.color.in_search));
        }
        if (person.getStatus().equals("Married")){
            holder.personStatus.setTextColor(context.getResources().getColor(R.color.married));
        }
        if (person.getStatus().equals("Beloved")){
            holder.personStatus.setTextColor(context.getResources().getColor(R.color.beloved));
        }
        if (person.getStatus().equals("Lesbian")){
            holder.personStatus.setTextColor(context.getResources().getColor(R.color.lesbian));
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class PersonViewHolder extends RecyclerView.ViewHolder {

        ImageView personPhoto;
        TextView personName;
        TextView personStatus;
        PersonViewHolder(final View itemView) {
            super(itemView);
            personPhoto = itemView.findViewById(R.id.image);
            personName = itemView.findViewById(R.id.name_user);
            personStatus = itemView.findViewById(R.id.status_user);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context = itemView.getContext();
                    Intent intent = new Intent(context, ChatActivity.class);
                    intent.putExtra(MyAdapter.KEY_1, list.get(getAdapterPosition()).getPhotoId());
                    intent.putExtra(MyAdapter.KEY_2, list.get(getAdapterPosition()).getName());
                    intent.putExtra(MyAdapter.KEY_3,list.get(getAdapterPosition()).getStatus());
                    context.startActivity(intent);
                }
            });
        }
    }
}

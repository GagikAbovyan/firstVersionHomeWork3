package ru.startandroid.week2homework3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        final ListView listView = findViewById(R.id.list_view);
        final List<ChatItem> list = new ArrayList<>();
        final MyListAdapter myListAdapter = new MyListAdapter(this,
                R.layout.layout_for_listvew_for_chat,
                list);
        final int photoId = getIntent().getIntExtra(MyAdapter.KEY_1, 0);
        final String name = getIntent().getStringExtra(MyAdapter.KEY_2);
        final String status = getIntent().getStringExtra(MyAdapter.KEY_3);
        ImageView imageView = findViewById(R.id.image_chat);
        TextView nameUser = findViewById(R.id.nameChat);
        TextView statusM = findViewById(R.id.status_user);
        imageView.setImageResource(photoId);
        nameUser.setText(name);
        statusM.setText(status);
        listView.setAdapter(myListAdapter);
        list.add(new ChatItem("Hello My Name is" + name));
        final ImageButton button = findViewById(R.id.send);
        final EditText editText = findViewById(R.id.editText);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChatItem chatItem = list.get(list.size() - 1);
                chatItem.setUserMessage(editText.getText().toString());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                chatItem.setBotMessage(logicAnswer(chatItem.getUserMessage(), name, status));
                editText.setText("");
                changeView(list, myListAdapter);
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChatActivity.this, BinaryActivity.class);
                intent.putExtra(MyAdapter.KEY_1, photoId);
                intent.putExtra(MyAdapter.KEY_2, name);
                intent.putExtra(MyAdapter.KEY_3, status);
                startActivity(intent);
            }
        });
    }



    private String logicAnswer(final String message, final String name, final String status) {
        if (message.contains("hello".toLowerCase())) {
            return "Hello";
        }
        if (message.contains("age".toLowerCase())) {
            return "25";
        }
        if (message.contains("status".toLowerCase())) {
            return status;
        }
        if (message.contains("name".toLowerCase())) {
            return name;
        }
        if (message.contains("how are you".toLowerCase())) {
            return "nothing special";
        }
        if (message.contains("weather".toLowerCase())) {
            return "badly";
        }
        return "sorry bunny I'm not too smart";
    }

    private void changeView(final List<ChatItem> list, final MyListAdapter myListAdapter) {
        if (list.size() > 4) {
            list.clear();
            myListAdapter.notifyDataSetChanged();
        }
        list.add(new ChatItem());
        myListAdapter.notifyDataSetChanged();
    }

}

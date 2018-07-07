package ru.startandroid.week2homework3;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class BinaryActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binary);
        final ImageView imageView = findViewById(R.id.image_binary);
        final TextView name = findViewById(R.id.name_binary);
        final TextView status = findViewById(R.id.status_binary);
        imageView.setImageResource(getIntent().getIntExtra(MyAdapter.KEY_1, 0));
        name.setText(getIntent().getStringExtra(MyAdapter.KEY_2));
        status.setText(getIntent().getStringExtra(MyAdapter.KEY_3));
        final String wikiHollyWood = "https://ru.wikipedia.org/wiki/%D0%93%D0%BE%D0%BB%D0%BB%D0%B8%D0%B2%D1%83%D0%B4";
        final ImageButton company = findViewById(R.id.companyWiki);
        company.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new
                        Intent(Intent.ACTION_VIEW, Uri.parse(wikiHollyWood));
                startActivity(browserIntent);
            }
        });

        final ImageButton callButton = findViewById(R.id.mobileCall);
        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+37455118896"));
                startActivity(intent);
            }
        });
    }
}

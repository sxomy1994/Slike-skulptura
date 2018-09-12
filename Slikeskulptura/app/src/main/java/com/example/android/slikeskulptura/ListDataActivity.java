package com.example.android.slikeskulptura;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

public class ListDataActivity extends AppCompatActivity {

    TextView nazivIGodina;
    ImageView image;
    TextView imeVajara;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_data);

        nazivIGodina = findViewById(R.id.text_intent_naziv_godina);
        imeVajara = findViewById(R.id.text_intent);
        image = findViewById(R.id.image_full);

        Intent intent = getIntent();

        nazivIGodina.setText(intent.getStringExtra("nazivIgodina"));
        imeVajara.setText(intent.getStringExtra("name"));
        image.setImageResource(intent.getIntExtra("image",0));
    }
}

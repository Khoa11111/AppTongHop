package com.google.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CayXauHo extends AppCompatActivity {

    private ImageView img_back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_detail_cayxauho);

        img_back = (ImageView) findViewById(R.id.cayxauho_arwBack);

        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CayXauHo.this, ListTree.class);
                startActivity(intent);
            }
        });
    }
}

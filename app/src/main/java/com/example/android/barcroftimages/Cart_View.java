package com.example.android.barcroftimages;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

/**
 * Created by Dezyne 2 on 2/28/2017.
 */

public class Cart_View extends AppCompatActivity {

    ListView list;
    ListAdapter adapter;
    Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.cart_view_layout);

        list = (ListView)findViewById(R.id.list);

        adapter = new ListAdapter();

        if (adapter.getCount()==0)
        {
            setContentView(R.layout.empty_cart_layout);
        }
        else
        {
            setContentView(R.layout.cart_view_layout);
        }

        Intent intent = getIntent();
          Bitmap bitmap = intent.getParcelableExtra("image");
        String name = intent.getStringExtra("name");



    }
}

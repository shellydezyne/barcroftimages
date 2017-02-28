package com.example.android.barcroftimages;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class GridViewAdapter extends ArrayAdapter {

    private Context context;
    private int layoutResourceId;
    private ArrayList data = new ArrayList();

    public GridViewAdapter(Context context, int layoutResourceId, ArrayList data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder holder = null;

    if (row == null) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        row = inflater.inflate(layoutResourceId, parent, false);
        holder = new ViewHolder();
        holder.imageTitle = (TextView) row.findViewById(R.id.text);
        holder.image = (ImageView) row.findViewById(R.id.image);
        holder.cash = (ImageView) row.findViewById(R.id.cash);
        holder.cart = (ImageView) row.findViewById(R.id.cart);

        row.setTag(holder);
    } else {
        holder = (ViewHolder) row.getTag();
    }



    final GridItem item = (GridItem) data.get(position);
    holder.imageTitle.setText(item.getTitle());
    holder.image.setImageBitmap(item.getImage());

        holder.cash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.i("Cash","Cash request clicked"+String.valueOf(position));
                Toast.makeText(getContext(),"Price Request Sent",Toast.LENGTH_LONG).show();

            }
        });

        holder.cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(context,Cart_View.class);
               // intent.putExtra("image",item.getImage());
                intent.putExtra("name",item.getTitle());
                context.startActivity(intent);

            }
        });

    return row;
}




static class ViewHolder {
    TextView imageTitle;
    ImageView image;
    ImageView cash;
    ImageView cart;
}


}

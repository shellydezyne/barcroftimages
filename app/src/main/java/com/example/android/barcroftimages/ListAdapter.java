package com.example.android.barcroftimages;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Dezyne 2 on 2/28/2017.
 */

public class ListAdapter extends BaseAdapter {
    String  name;
    String price;
    Context context;
    int  image;
    static int i=0;
    private static LayoutInflater inflater=null;

    public ListAdapter(Context context, String name, int images, String price) {
        // TODO Auto-generated constructor stub
        this.name=name;
        this.context=context;
        this.image= images;
        this.price = price;

        i++;
    }

    ListAdapter() {
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return i;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView name;
        TextView price;
        ImageView img;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.cart_view_card, null);
        holder.name=(TextView) rowView.findViewById(R.id.cart_name);
        holder.img=(ImageView) rowView.findViewById(R.id.cart_image);
       holder.price =(TextView) rowView.findViewById(R.id.cart_price);







        return rowView;
    }

}

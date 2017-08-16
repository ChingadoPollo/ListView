package com.oneday.listview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class EcoBusAdapter extends ArrayAdapter<EcoBus> {

    Context myContext;
    int myLayoutResourceID;
    EcoBus mydata [] = null;

    public EcoBusAdapter(Context context,int layoutResourceID, EcoBus[] data) {
        super(context, layoutResourceID, data);

        this.myContext = context;
        this.myLayoutResourceID = layoutResourceID;
        this.mydata = data;

    }

    public View getView(int position, View convertView, ViewGroup parent ){
        View row = convertView;
        EcoBusHolder holder = null;

        if(row == null){
            LayoutInflater inflater = ((Activity)myContext).getLayoutInflater();
            row = inflater.inflate(myLayoutResourceID,parent,false);

            holder = new EcoBusHolder();
            holder.imagen = (ImageView) row.findViewById(R.id.image);
            holder.textView = (TextView) row.findViewById(R.id.text);
            row.setTag(holder);

        }

        else {
            holder = (EcoBusHolder)row.getTag();
        }

        EcoBus ecoBus = mydata[position];
        holder.textView.setText(ecoBus.title);
        holder.imagen.setImageResource(ecoBus.icon);


        return row;
    }

    static class EcoBusHolder {
        ImageView imagen;
        TextView textView;
    }



}

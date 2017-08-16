package com.oneday.listview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EcoBus ecoBus_datos[] = new EcoBus[] {
                new EcoBus(R.mipmap.ic_launcher,"Manzana"),
                new EcoBus(R.mipmap.ic_launcher,"Pera"),
                new EcoBus(R.mipmap.ic_launcher,"Melón"),
                new EcoBus(R.mipmap.ic_launcher,"Uva"),

        };

        EcoBusAdapter adapter = new EcoBusAdapter(this,R.layout.listview_item_row, ecoBus_datos);

        listView = (ListView) findViewById(R.id.listView);

        View header = (View) getLayoutInflater().inflate(R.layout.list_header_row,null);
        listView.addHeaderView(header);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView v = (TextView)view.findViewById(R.id.text);

                Toast.makeText(getApplicationContext(),v.getText(),Toast.LENGTH_SHORT).show();
            }
        });





    }
}

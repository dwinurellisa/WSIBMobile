package com.example.mylistview;

import static android.widget.Toast.makeText;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.text.DateFormatSymbols;


public class MainActivity extends AppCompatActivity {

    ListView listViewDay;   //memanggil fungsi

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewDay = findViewById(R.id.listViewDay);   //memanggil listView pada activity_main.xml
        String[] Day = new DateFormatSymbols().getShortWeekdays(); //data array nama hari

        // fungsi untuk menampilkan data list ke listView melalui adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Day);
        listViewDay.setAdapter(adapter);    //menetapkan sebuah adapter pada baris sebelumnya

        //action klik
        listViewDay.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                makeText(getApplicationContext(),"Anda klik hari : "+ parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();   //proses pesan saat diklik
            }
        });
    }
}
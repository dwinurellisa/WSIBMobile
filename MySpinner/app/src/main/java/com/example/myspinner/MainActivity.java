package com.example.myspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;    //memanggil fungsi

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);   //mendapatkan id dari spinner, memanggil resource dari item dan membuat adapter untuk spinner

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.country, android.R.layout.simple_spinner_item);  //memanggil nama array dan layout view nya
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);     //menetapkan tata letak yang harus digunakan adaptor untuk menampilkan daftar pilihan spinner dan tata letak standart lainnya yang telah ditetapkan
        spinner.setAdapter(adapter);    //menetapkan sebuah adapter pada baris sebelumnya

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {    //mengimplementasikan antarmuka
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                Toast.makeText(parent.getContext(),"Anda memilih negara ke : "+parent.getItemIdAtPosition(position), Toast.LENGTH_SHORT).show();   //proses pesan saat diklik
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
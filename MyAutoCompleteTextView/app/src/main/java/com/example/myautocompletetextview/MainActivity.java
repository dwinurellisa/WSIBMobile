package com.example.myautocompletetextview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    private static final String[] KOTA = new String[]{  //Daftar item menggunakan array
      "Ambon","Aceh",
      "Bandung","Bogor","Bengkulu","Bali","Bangkalan","Banjarmasin","Bondowoso","Bojonegoro",
      "Cilegon","Cimahi","Cirebon","Denpasar","Depok"
    };

    AutoCompleteTextView autocompletekota;
    @Override
    protected void onCreate(Bundle savedInstanceState) {    //memanggil implementasi superclass darimetode ini
        super.onCreate(savedInstanceState);     //untuk menjalankan kode selain kode yang ada dikelas induk
        setContentView(R.layout.activity_main); //untuk menyetel tata letak xml

        autocompletekota = findViewById(R.id.autocompletekota); //memanggil listView pada activity_main.xml

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, KOTA);   //memanggil nama array dan layoutview nya
        autocompletekota.setAdapter(adapter);   //menetapkan sebuah adapter pada baris sebelumnya
    }
}
package com.example.recyclerviewdatamovies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;  //mendeklarasikan recyclerview
    MoviesRecyclerViewAdapter adapter;  //memanggil objek dari movieRecyclerViewAdapter
    ArrayList<Movies> objMovies = new ArrayList<>();    //membuat arraylist dari tipe movies

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        //mengisi data pada objectMovie.add dan harus menyesuaikan urutan dengan yang ada pada movies
        objMovies.add(new Movies("Mariposa","Comedy, Drama,Romance","Fajar Bustomi",7.4,"Iqbal (Angga Yunanda) is like a Mariposa butterfly to Acha (Adhisty Zara). Each time someone approach, he always runs away. Acha is determined to win Iqbal, a man known to be handsome, smart, yet cold.","12 Maret 2020"));
        objMovies.add(new Movies("Home Town ChaChaCha","Comedy,Romance","Yoo Je-won",9.1,"A big-city dentist opens up a practice in a close-knit seaside village, home to a charming jack-of-all-trades who is her polar opposite in every way.","28 Agustus 2021"));
        objMovies.add(new Movies("The Suicede Squad", "Action, Adventure, Comedy", "James Gunn", 7.3, "Supervillains Harley Quinn, Bloodsport, Peacemaker and a collection of nutty cons at Belle Reve prison join the super-secret, super-shady Task Force X as they are dropped off at the remote, enemy-infused island of Corto Maltese.","6 Agustus 2021" ));

        adapter=new MoviesRecyclerViewAdapter(objMovies); //menerapkan adapter
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }
}
package com.example.recyclerviewdatamovies;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MoviesRecyclerViewAdapter extends RecyclerView.Adapter<MoviesRecyclerViewAdapter.MovieViewHolder> { //melakukan extend RecyclerView.Adapter
    ArrayList<Movies> arrayListMovies;  //memasukkan data ke arraylist dari class arrayListMovies

    //men-generate, cunstuctor
    public MoviesRecyclerViewAdapter(ArrayList<Movies> arrayListMovies) {
        this.arrayListMovies = arrayListMovies;
    }

    //mengimplement method MoviesRcyclerViewAdapter.MovieViewHolder, onBindViwHolder, dan getItemCount
    @NonNull
    @Override
    public MoviesRecyclerViewAdapter.MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false); //mengisi objek view
        return new MovieViewHolder(view);   //mengambil data atau layout dari item.xml
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesRecyclerViewAdapter.MovieViewHolder holder, int position) {
    final Movies movies = arrayListMovies.get(position);    //membuat sebuah constanta dan memanggil object movies

    holder.textViewTitle.setText(movies.getTitle());
    holder.textViewRating.setText(String.valueOf(movies.getRating()));
    holder.textViewReleaseDate.setText(movies.getReleasedata());

    holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(holder.itemView.getContext(), DetailMovieActivity.class);    //melempar nilai menggunakan intent agar bisa ditangkap oleh detail movie
            intent.putExtra("MOVIES",movies);   //kode yang akan dipanggil untuk ditampilkan
            holder.itemView.getContext().startActivity(intent); //menjalankan perpindahan activity dari mainActivity ke detailMovieActivity
        }
    });
    }

    @Override
    public int getItemCount() {
        return arrayListMovies.size();  //menjalankan fungsi size untuk mendapatkan data arrayListMovies
    }

    //mendeklarasikan class MovieViewHolder
    public class MovieViewHolder extends RecyclerView.ViewHolder {  //melakukan extends RecyclerViewHolder.ViewHolder
        TextView textViewTitle, textViewRating, textViewReleaseDate;    //mendeklarasikan widget atau view yang ada didalam item

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            //memanggilnya dengan findViewById
            textViewTitle = itemView.findViewById(R.id.tvTitle);
            textViewRating = itemView.findViewById(R.id.tvRating);
            textViewReleaseDate = itemView.findViewById(R.id.tvReleaseDate);
        }
    }
}

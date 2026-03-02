package com.example.app2iagi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class VillesMarocActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_villes_maroc);

        // 1. Liste des noms
        String[] noms = {"Casablanca", "Rabat", "Marrakech", "Fès", "Tanger", "Agadir"};

        // 2. Liste des images correspondantes (Assurez-vous que ces fichiers existent dans res/drawable)
        int[] images = {
                R.drawable.casablanca,
                R.drawable.rabat,
                R.drawable.marrakech,
                R.drawable.fes,
                R.drawable.tanger,
                R.drawable.agadir,
        };

        RecyclerView rv = findViewById(R.id.recycler_view_villes);
        rv.setLayoutManager(new GridLayoutManager(this, 2));

        rv.setAdapter(new RecyclerView.Adapter<RecyclerView.ViewHolder>() {
            @NonNull @Override
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup p, int t) {
                View v = LayoutInflater.from(p.getContext()).inflate(R.layout.item_ville, p, false);
                return new RecyclerView.ViewHolder(v) {};
            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder h, int pos) {
                // Liaison du texte
                ((TextView) h.itemView.findViewById(R.id.nom_ville)).setText(noms[pos]);

                // 3. Liaison de l'image spécifique à la position
                ((ImageView) h.itemView.findViewById(R.id.image_ville)).setImageResource(images[pos]);
            }

            @Override
            public int getItemCount() { return noms.length; }
        });
    }
}
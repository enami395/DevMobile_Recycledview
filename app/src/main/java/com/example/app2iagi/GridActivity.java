package com.example.app2iagi;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GridActivity extends AppCompatActivity {
    String[] countriesArray = {
            "Maroc", "France", "Canada", "Japon", "Brésil", "Égypte", "Allemagne", "Italie",
            "Espagne", "États-Unis", "Sénégal", "Corée du Sud", "Mexique", "Australie", "Tunisie",
            "Suisse", "Belgique", "Algérie", "Argentine", "Grèce", "Portugal", "Chine", "Inde",
            "Russie", "Turquie", "Arabie Saoudite", "Afrique du Sud", "Nigeria", "Chili", "Pérou",
            "Colombie", "Suède", "Norvège", "Danemark", "Finlande", "Autriche", "Pays-Bas",
            "Portugal", "Thaïlande", "Viêt Nam"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        GridView gridView = findViewById(R.id.grid_view_countries);

        List<String> countriesList = new ArrayList<>(Arrays.asList(countriesArray));

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            android.R.layout.simple_list_item_1,
            countriesList
        );

        gridView.setAdapter(adapter);
    }
}

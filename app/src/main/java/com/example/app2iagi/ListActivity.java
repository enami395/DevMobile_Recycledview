package com.example.app2iagi;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    String[] initialCountries = {
            "Maroc", "France", "Canada", "Japon", "Brésil",
            "Égypte", "Allemagne", "Italie", "Espagne", "États-Unis",
            "Sénégal", "Corée du Sud", "Mexique", "Australie", "Tunisie",
            "Suisse", "Belgique", "Algérie", "Argentine", "Grèce"
    };
    ArrayList<String> countriesList;
    ArrayAdapter<String> adapter;
    ListView listPays;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listPays = findViewById(R.id.list_view_countries);
        btnAdd = findViewById(R.id.button_add_country);

        countriesList = new ArrayList<>(Arrays.asList(initialCountries));
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, countriesList);
        listPays.setAdapter(adapter);

        // CREATE
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddDialog();
            }
        });

        // UPDATE (Short Click)
        listPays.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showUpdateDeleteDialog(position);
            }
        });
    }

    private void showAddDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Ajouter un nouveau pays");

        final EditText input = new EditText(this);
        input.setHint("Nom du pays");
        builder.setView(input);

        builder.setPositiveButton("Ajouter", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String name = input.getText().toString().trim();
                if (!name.isEmpty()) {
                    countriesList.add(name);
                    adapter.notifyDataSetChanged();
                    Toast.makeText(ListActivity.this, "Pays ajouté", Toast.LENGTH_SHORT).show();
                }
            }
        });
        builder.setNegativeButton("Annuler", null);
        builder.show();
    }

    private void showUpdateDeleteDialog(final int position) {
        String currentName = countriesList.get(position);
        String[] options = {"Modifier", "Supprimer"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(currentName);
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == 0) { // Modifier
                    showEditDialog(position);
                } else { // Supprimer
                    showDeleteConfirmDialog(position);
                }
            }
        });
        builder.show();
    }

    private void showEditDialog(final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Modifier le pays");

        final EditText input = new EditText(this);
        input.setText(countriesList.get(position));
        builder.setView(input);

        builder.setPositiveButton("Enregistrer", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String newName = input.getText().toString().trim();
                if (!newName.isEmpty()) {
                    countriesList.set(position, newName);
                    adapter.notifyDataSetChanged();
                    Toast.makeText(ListActivity.this, "Modifié avec succès", Toast.LENGTH_SHORT).show();
                }
            }
        });
        builder.setNegativeButton("Annuler", null);
        builder.show();
    }

    private void showDeleteConfirmDialog(final int position) {
        new AlertDialog.Builder(this)
                .setTitle("Suppression")
                .setMessage("Voulez-vous vraiment supprimer " + countriesList.get(position) + " ?")
                .setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        countriesList.remove(position);
                        adapter.notifyDataSetChanged();
                        Toast.makeText(ListActivity.this, "Supprimé", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Non", null)
                .show();
    }
}

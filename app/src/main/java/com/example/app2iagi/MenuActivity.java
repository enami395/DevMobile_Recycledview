package com.example.app2iagi;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.ctc) {
            Intent ctc = new Intent(MenuActivity.this, Contact.class);
            startActivity(ctc);
        }else if (id == R.id.abt) {
            Intent abt = new Intent(MenuActivity.this, About_us.class);
            startActivity(abt);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        Button buttonVillesMaroc = findViewById(R.id.button_villes_maroc);
        Button buttonCardView = findViewById(R.id.button_card_view);
        Button buttonList = findViewById(R.id.button_list);
        Button buttonGrid = findViewById(R.id.button_grid);
        Button buttonSpinner = findViewById(R.id.button_spinner);

        buttonVillesMaroc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, VillesMarocActivity.class);
                startActivity(intent);
            }
        });

        buttonCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, cardViewExample.class);
                startActivity(intent);
            }
        });

        buttonList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(MenuActivity.this, ListActivity.class);
                startActivity(i1);
            }
        });

        buttonGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(MenuActivity.this, GridActivity.class);
                startActivity(i2);
            }
        });

        buttonSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3 = new Intent(MenuActivity.this, SpinnerActivity.class);
                startActivity(i3);
            }
        });
    }
}

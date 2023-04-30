package com.example.mielux.vue;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mielux.R;

public class Commande extends AppCompatActivity {

    private TextView TvNom_Client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commande);

        TvNom_Client = findViewById(R.id.TvNom_Client);
        DatasEleve de = DatasEleve.getInstance();
        TvNom_Client.setText(de.getNomEleve());
    }
}
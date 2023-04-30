package com.example.mielux.vue;




import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mielux.R;

public class ListeClients extends AppCompatActivity {
    LinearLayout layout ;
    TextView tvNomEleve;
    TextView tvNbrMiel;
    TextView tvNomMiel;
    TextView tvPrixMiel;
    TextView tvQteMiel;
    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_clients);
        Log.d("yitshak", "entre dans liste client" );

        DatasEleve de = DatasEleve.getInstance();
        DatasMiel dm = DatasMiel.getInstance();
        Log.d("yitshak", "les data set sont declarés" );

        layout = findViewById(R.id.layoutVer);
        Log.d("yitshak", "layout trouvé" );


        tvNomEleve= findViewById(R.id.tvNomEleve);
        tvNomEleve.setText("Bonjour " + de.getNomEleve());
        Log.d("yitshak", "nom eleve assocé au visuel et renseigné" );

        tvNbrMiel = new TextView(this);
        int n =(dm.getNbrMiel());
        String s = Integer.toString(n);
        Log.d("yitshak", "nbrmiel = " +s);
        tvNbrMiel.setText(s);
        layout.addView(tvNbrMiel);
        Log.d("yitshak", "tvNbrMiel renseigné et ajoute au layout" );



        for (int i = 0; i<n; i++){
        //            Log.d("yitshak", "i=" +i);
            tvNomMiel = new TextView(this);
            tvQteMiel = new EditText(this);
            tvPrixMiel = new TextView(this);
            String nomM = dm.getNomMiel(i);
            String prixM = dm.getPrixMielEnStr(i);
            tvNomMiel.setText(nomM + " ("+prixM+"euro)");
            //tvPrixMiel.setText(prixM+"euro");
            layout.addView(tvNomMiel);
            layout.addView(tvPrixMiel);
            layout.addView(tvQteMiel);


            Log.d("yitshak", "tvNbrMiel renseigné et ajoute au layout" );

        }


    }
}
package com.example.mielux.vue;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mielux.R;
import com.example.mielux.outils.AccesHTTP;
import com.example.mielux.outils.AsyncResponse;

import org.json.JSONException;
import org.json.JSONObject;

public class Login extends AppCompatActivity implements AsyncResponse{


    private EditText login;
    private EditText password;
    private Button btnConnexion;
    private static final String SERVERADDR = "http://localhost/mielux/mobile/serveurmielux.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //asscoie le layout login a la page
        setContentView(R.layout.login);

        //lancement de la fonction
        init();
        ecoute_login();
    }

    private void init(){
        //intialisation des variables de la vue de login
        login = findViewById(R.id.login);
        password = findViewById(R.id.password);
        btnConnexion =findViewById(R.id.btnConnexion);
    }

    private void ecoute_login(){
        //associer le clique du boutton a une action
        btnConnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nom = login.getText().toString();
                String mdp = password.getText().toString();

                //lancement fonction
                requete_connexion( nom, mdp);
            }
        });

    }

    private void requete_connexion(String login, String password){
        // Voir la page Acces_HTTP pour comprendre
        AccesHTTP accesDonnees = new AccesHTTP();

        // Le delegate permet de dédié la requête cette fonction. Le process finish en revenant
        // Saura que c'est a cette fonction qu'il doit revenir.
        accesDonnees.delegate = (AsyncResponse) this;

        // Ajoute des paramètre à accèsDonnees.
        accesDonnees.addParam("login", login);
        accesDonnees.addParam("password", password);

        Log.d("login", "requete_connexion: "+login+" "+password);
        accesDonnees.execute(SERVERADDR);
    }



    // La méthode processFinish prend en entrée une chaîne de caractères appelée "output"
    public void processFinish(String output) {
        // Journalisation du contenu de "output" à l'aide de Log.d
        Log.d("serveurlogin", "processFinish: "+ output);

        try {
            // Convertir la réponse en objet JSON
            JSONObject reponse = new JSONObject(output);

            // Vérifier si la connexion est réussie
            if (!reponse.getString("state").equals("false")) {
                Log.d("serveurlogin", "retour du serveur: " +output);
                DatasEleve de = DatasEleve.getInstance();
                de.setDatasEleve(output);

                DatasMiel da = DatasMiel.getInstance();
                da.setDatasMiel(output);

                // Si la connexion est réussie, démarrer une nouvelle activité
                Log.d("salut", "jsuteavant" );
                Intent intent = new Intent(getApplicationContext(), ListeClients.class);
                Log.d("salut", "jsuteapres" );
                startActivity(intent);
                // Appel de la méthode "finish" pour terminer l'activité actuelle
                finish();
            } else {
                // Sinon, afficher un message d'erreur à l'utilisateur
                Toast.makeText(this, "Mot de passe ou identifiant incorrect", Toast.LENGTH_SHORT).show();
            }
        } catch (JSONException e) {
            // En cas d'erreur lors de la conversion en objet JSON, journaliser l'erreur
            e.printStackTrace();
            Log.d("erreur", "erreurJSON: " +e);
        }

    }

}

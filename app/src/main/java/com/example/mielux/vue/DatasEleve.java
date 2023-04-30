package com.example.mielux.vue;

import org.json.JSONException;
import org.json.JSONObject;

public class DatasEleve {

    public String nomEleve;
    public String prenomEleve;
    public String classeEleve;


    private static DatasEleve holder = null;

    private DatasEleve(){
        nomEleve ="";
        prenomEleve ="";
        classeEleve ="";
    }


    public static DatasEleve getInstance(){
        if(holder == null) {
            holder = new DatasEleve();
            return (holder);
        }else {

            return (holder);
        }
    }



    public void setDatasEleve(String donnees){

        try{
            JSONObject eleve = new JSONObject(donnees);
            nomEleve = eleve.getString("nom");
            prenomEleve = eleve.getString("prenom");
            classeEleve = eleve.getString("classe");


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public String getNomEleve(){
        return (nomEleve);
    }

    public String getPrenomEleve(){
        return (prenomEleve);
    }
}

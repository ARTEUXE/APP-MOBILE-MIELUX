package com.example.mielux.vue;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class DatasMiel {

    public String nomMiel;
    public String prixMiel;
    public String[] tabNomsMiels;
    public String[] tabPrixMiels;


    private static DatasMiel holder = null;

    private DatasMiel() {
        nomMiel = "";
        prixMiel = "";
    }

    public static DatasMiel getInstance(){
        if(holder == null) {
            holder = new DatasMiel();
            return (holder);
        }else {

            return (holder);
        }
    }

    public void setDatasMiel(String donnees){

        try{
            JSONObject miel = new JSONObject(donnees);
            nomMiel = miel.getString("miels");
            prixMiel = miel.getString("prix");
            Log.d("miel", "nomdesmiel: "+nomMiel);

            tabNomsMiels = nomMiel.split("#");
            tabPrixMiels = prixMiel.split("#");
            Log.d("miel", "setdatamiel nbrmiel = " +tabNomsMiels.length);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public String[] gettabNomMiel(){
         return (tabNomsMiels);
    }

    public String getNomMiel(int k){
        return (tabNomsMiels[k]);
    }

    public String [] gettabPrixMiel(){
        return (tabPrixMiels);
    }

    public String getPrixMielEnStr(int k){
        return (tabPrixMiels[k]);
    }

    public float getPrixMielEnFloat(int k){
        String prix = tabPrixMiels[k];
        float p = Float.parseFloat( prix);
        return (p);
    }

    public int getNbrMiel(){
        Log.d("yitshak", "ds nbrmiel = " +tabNomsMiels.length);
        return(tabNomsMiels.length);
    }

}
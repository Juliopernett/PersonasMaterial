package com.example.personasmaterial;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Datos {
    private static  String db = "Personas";

    private static DatabaseReference databaseReference =
            FirebaseDatabase.getInstance().getReference();

    public  static ArrayList<Persona> personas = new ArrayList<>();

    public static  void agregar(Persona p){
        /*Estructura propia de una base de datos no relacional*/
        databaseReference.child(db).child(p.getId()).setValue(p);
    }

    public  static  void editar(Persona p){
        databaseReference.child(db).child(p.getId()).setValue(p);
    }

    public  static  void eliminar(Persona p){
        databaseReference.child(db).child(p.getId()).removeValue();
    }

    /*manda una peticion al servidor y me trae una llave unica*/
    public static String gesID(){
        return databaseReference.push().getKey();
    }

    public  static  void setPersonas(ArrayList<Persona> personas){
        Datos.personas=personas;
    }

    public static ArrayList<Persona> optenet(){
        return Datos.personas;
    }
}

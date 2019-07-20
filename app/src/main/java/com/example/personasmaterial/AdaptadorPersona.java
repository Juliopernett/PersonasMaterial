package com.example.personasmaterial;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorPersona extends  RecyclerView.Adapter<AdaptadorPersona.PersonaViewHolder> {
    private ArrayList<Persona> personas;
    private  OnPersonaClickListener clickListener;

    public  AdaptadorPersona(ArrayList<Persona>personas, OnPersonaClickListener clickListener){
        this.personas=personas;
        this.clickListener=clickListener;
    }

    @Override
    public PersonaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       //vas a usar el layaut que ya cree
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_persona, viewGroup, false);
        return new PersonaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonaViewHolder personaViewHolder, int i) {
        final Persona p = personas.get(i);
        personaViewHolder.foto.setImageResource(p.getFoto());
        personaViewHolder.nombre.setText(p.getNombre());
        personaViewHolder.apellido.setText(p.getApellido());

        PersonaViewHolder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onPersonaClick(p);

            }
        });
    }

    @Override
    public int getItemCount() {
        return personas.size();
    }

    public static class PersonaViewHolder extends RecyclerView.ViewHolder{
        public static View v;
        private ImageView foto;
        private TextView nombre;
        private TextView apellido;


        public  PersonaViewHolder(View itemView){
            super(itemView);
            v = itemView;
            foto = v.findViewById(R.id.foto);
            nombre = v.findViewById(R.id.lblNombre);
            apellido = v.findViewById(R.id.lblApellido);
        }
    }
    /*hay un evento que tiene que ejecutarse obligatoriamente*/
    public interface  OnPersonaClickListener{
         void onPersonaClick (Persona p);
    }
}

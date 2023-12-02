package com.example.myapps;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class UsuarioAdapter extends RecyclerView.Adapter<UsuarioAdapter.UsuarioViewHolder> {

    private List<Usuario> usuariosList;

    public UsuarioAdapter(List<Usuario> usuariosList) {
        this.usuariosList = usuariosList;
    }

    @NonNull
    @Override
    public UsuarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_usuario, parent, false);
        return new UsuarioViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull UsuarioViewHolder holder, int position) {
        Usuario usuario = usuariosList.get(position);


        int nombre = Integer.parseInt(usuario.getNombre());
        int apellido = Integer.parseInt(usuario.getApellido());


        int suma = nombre + apellido;


        holder.nombreTextView.setText("Suma: " + String.valueOf(suma));
        holder.apellidoTextView.setText("");
        holder.fechaTextView.setText("");
    }


    @Override
    public int getItemCount() {
        return usuariosList.size();
    }

    public static class UsuarioViewHolder extends RecyclerView.ViewHolder {
        TextView nombreTextView, apellidoTextView, fechaTextView;

        public UsuarioViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreTextView = itemView.findViewById(R.id.nombreTextView);
            apellidoTextView = itemView.findViewById(R.id.apellidoTextView);
            fechaTextView = itemView.findViewById(R.id.fechaTextView);
        }
    }
}


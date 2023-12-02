package com.example.myapps;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;

public class Fragmento4 extends Fragment {

    private EditText nombreEditText, apellidoEditText, ciudadEditText;
    private Button guardarButton;

    private OnDatosGuardadosListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragmento4, container, false);

        nombreEditText = view.findViewById(R.id.editTextNombre);
        apellidoEditText = view.findViewById(R.id.editTextApellido);
        ciudadEditText = view.findViewById(R.id.editTextCiudad);
        guardarButton = view.findViewById(R.id.buttonGuardar);

        guardarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarDatos();
            }
        });

        return view;
    }

    private void guardarDatos() {
        String nombre = nombreEditText.getText().toString();
        String apellido = apellidoEditText.getText().toString();
        String ciudad = ciudadEditText.getText().toString();


        if (!nombre.isEmpty() && !apellido.isEmpty() && !ciudad.isEmpty()) {

            ArrayList<String> datosList = new ArrayList<>();
            datosList.add("Nombre: " + nombre);
            datosList.add("Apellido: " + apellido);
            datosList.add("Ciudad: " + ciudad);


            nombreEditText.getText().clear();
            apellidoEditText.getText().clear();
            ciudadEditText.getText().clear();


            if (listener != null) {
                listener.onDatosGuardados(datosList);
            }

            Toast.makeText(getActivity(), "Datos guardados", Toast.LENGTH_SHORT).show();
        } else {

            Toast.makeText(getActivity(), "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

    public interface OnDatosGuardadosListener {
        void onDatosGuardados(ArrayList<String> datos);
    }

    public void setOnDatosGuardadosListener(OnDatosGuardadosListener listener) {
        this.listener = listener;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);


        if (context instanceof OnDatosGuardadosListener) {
            listener = (OnDatosGuardadosListener) context;
            setOnDatosGuardadosListener(listener);
        } else {
            throw new ClassCastException(context.toString() + " ");
        }
    }
}

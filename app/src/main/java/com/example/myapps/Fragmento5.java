package com.example.myapps;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
public class Fragmento5 extends Fragment {

    private TextView textViewDatos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragmento5, container, false);
        textViewDatos = view.findViewById(R.id.textViewDatos);


        mostrarDatos(((MainActivity) requireActivity()).getDatosTemporales());

        return view;
    }

    public void mostrarDatos(ArrayList<String> datos) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String dato : datos) {
            stringBuilder.append(dato).append("\n");
        }
        textViewDatos.setText(stringBuilder.toString());
    }
}

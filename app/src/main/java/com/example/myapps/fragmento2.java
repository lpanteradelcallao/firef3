package com.example.myapps;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class fragmento2 extends Fragment {

    private EditText nombreEditText, apellidoEditText, fechaEditText;
    private Button guardarButton;

    public fragmento2() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragmento2, container, false);


        FirebaseApp.initializeApp(requireContext());


        nombreEditText = view.findViewById(R.id.nombreEditText);
        apellidoEditText = view.findViewById(R.id.apellidoEditText);
        fechaEditText = view.findViewById(R.id.fechaEditText);
        guardarButton = view.findViewById(R.id.guardarButton);


        guardarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarDatosFirebase();
            }
        });

        return view;
    }

    private void guardarDatosFirebase() {

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("usuarios");


        String userId = databaseReference.push().getKey();


        Usuario usuario = new Usuario(
                nombreEditText.getText().toString(),
                apellidoEditText.getText().toString(),
                fechaEditText.getText().toString()
        );


        databaseReference.child(userId).setValue(usuario);


        nombreEditText.setText("");
        apellidoEditText.setText("");
        fechaEditText.setText("");
    }

}

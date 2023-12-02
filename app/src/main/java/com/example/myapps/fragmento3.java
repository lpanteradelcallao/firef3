package com.example.myapps;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;

public class fragmento3 extends Fragment {


    private RecyclerView recyclerView;
    private UsuarioAdapter usuarioAdapter;
    private List<Usuario> usuariosList;

    public fragmento3() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragmento3, container, false);

        // Inicializar la lista de usuarios y el adaptador
        usuariosList = new ArrayList<>();
        usuarioAdapter = new UsuarioAdapter(usuariosList);

        // Configurar RecyclerView
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(usuarioAdapter);

        // Obtener datos de Firebase
        obtenerDatosFirebase();

        return view;
    }

    private void obtenerDatosFirebase() {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("usuarios");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                usuariosList.clear();

                // Iterar a través de los datos y agregar a la lista
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Usuario usuario = snapshot.getValue(Usuario.class);
                    usuariosList.add(usuario);
                }

                // Notificar al adaptador sobre el cambio en los datos
                usuarioAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Manejar errores de lectura desde Firebase
            }
        });
    }
}
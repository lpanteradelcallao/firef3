package com.example.myapps;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Fragmento4.OnDatosGuardadosListener {

    private Toolbar toolbar1;
    private ArrayList<String> datosTemporales = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar1 = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar1);
        getSupportFragmentManager().beginTransaction().add(R.id.frame1, new fragmento1()).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menufracmento1:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame1, new fragmento1()).commit();
                return true;
            case R.id.menufracmento2:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame1, new fragmento2()).commit();
                return true;
            case R.id.menufracmento3:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame1, new fragmento3()).commit();
                return true;
            case R.id.menufracmento4:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame1, new Fragmento4()).commit();
                return true;
            case R.id.menufracmento5:

                getSupportFragmentManager().beginTransaction().replace(R.id.frame1, new Fragmento5()).commit();


                mostrarFragmento5ConDatosTemporales();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onDatosGuardados(ArrayList<String> datos) {
        datosTemporales = new ArrayList<>(datos);


    }

    private void mostrarFragmento5ConDatosTemporales() {

        getSupportFragmentManager().beginTransaction().replace(R.id.frame1, new Fragmento5()).commit();
        Fragment fragmento5 = getSupportFragmentManager().findFragmentById(R.id.frame1);
        if (fragmento5 instanceof Fragmento5) {
            ((Fragmento5) fragmento5).mostrarDatos(datosTemporales);
        }
    }

    public ArrayList<String> getDatosTemporales() {
        return new ArrayList<>(datosTemporales);
    }
}
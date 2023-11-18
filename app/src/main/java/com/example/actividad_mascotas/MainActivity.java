package com.example.actividad_mascotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private List<Mascota> mascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar datos de ejemplo
        mascotas = new ArrayList<>();
        mascotas.add(new Mascota("Mascota 1", 3,R.drawable.mascota1));
        mascotas.add(new Mascota("Mascota 2", 5,R.drawable.mascota2));
        mascotas.add(new Mascota("Mascota 3", 2, R.drawable.mascota3));
        mascotas.add(new Mascota("Mascota 4", 2, R.drawable.mascota4));
        mascotas.add(new Mascota("Mascota 5", 2, R.drawable.mascota5));
        // Configurar RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MascotaAdapter adapter = new MascotaAdapter(mascotas, new MascotaAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Mascota mascota) {
                // Lógica para manejar clics en elementos de la lista
                Toast.makeText(MainActivity.this, "Hiciste clic en " + mascota.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(adapter);

        // Configurar Action View (botón de estrella)
        ImageView starButton = findViewById(R.id.starButton);
        starButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abrir la actividad de mascotas favoritas
                Intent intent = new Intent(MainActivity.this, FavoritasMascotas.class);
                startActivity(intent);
            }
        });
    }
}
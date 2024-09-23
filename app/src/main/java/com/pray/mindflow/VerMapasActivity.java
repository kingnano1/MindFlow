package com.pray.mindflow;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class VerMapasActivity extends AppCompatActivity {
    private RecyclerView rvMapsList;
    private MapItemAdapter mapItemAdapter;
    private List<MapItem> mapItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapas_mentales_existentes);

        rvMapsList = findViewById(R.id.rvMapsList);
        rvMapsList.setLayoutManager(new LinearLayoutManager(this));

        // Ejecutar la carga de datos en segundo plano
        new LoadMapItemsTask().execute();
    }

    // Clase AsyncTask para cargar los datos en segundo plano
    private class LoadMapItemsTask extends AsyncTask<Void, Void, List<MapItem>> {
        @Override
        protected List<MapItem> doInBackground(Void... voids) {
            // Simulamos la carga de datos (esto podría ser una consulta a una base de datos, etc.)
            List<MapItem> mapItemList = new ArrayList<>();
            mapItemList.add(new MapItem("mapas de clase"));
            mapItemList.add(new MapItem("mapas de materia"));
            mapItemList.add(new MapItem("mapas de ideas"));
            return mapItemList;
        }

        @Override
        protected void onPostExecute(List<MapItem> mapItems) {
            // Una vez cargados los datos, los asignamos al adaptador
            mapItemAdapter = new MapItemAdapter(mapItems);
            rvMapsList.setAdapter(mapItemAdapter);
        }
    }

    // Método para manejar el botón "Menu Principal"
    public void onClickMenuPrincipal(View view) {
        Intent intent = new Intent(this, MenuPrincipal.class);
        startActivity(intent);
    }
}


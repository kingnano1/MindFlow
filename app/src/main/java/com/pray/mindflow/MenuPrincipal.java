package com.pray.mindflow;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MenuPrincipal extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_principal);
    }

    public void onClickCrearMapa(View view) {
        Intent intent = new Intent(this, CrearMapaActivity.class);
        startActivity(intent);
    }

    public void onClickVerMapas(View view) {
        Intent intent = new Intent(this, VerMapasActivity.class);
        startActivity(intent);
    }

    public void onClickSincronizar(View view) {
        Intent intent = new Intent(this, SincronizarActivity.class);
        startActivity(intent);
    }

    public void onClickCerrarSesion(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
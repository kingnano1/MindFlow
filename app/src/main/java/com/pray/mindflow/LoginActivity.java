package com.pray.mindflow;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText usernameEditText;
    private EditText passwordEditText;
    private Spinner roleSpinner;
    private CheckBox rememberMeCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        roleSpinner = findViewById(R.id.spinnerRoles);
        rememberMeCheckBox = findViewById(R.id.rememberMe);

        String[] roles = {"Administrador", "Usuario"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, roles);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        roleSpinner.setAdapter(adapter);
    }

    public void onClickAcceder(View view) {
        String user = usernameEditText.getText().toString().trim();
        String pass = passwordEditText.getText().toString().trim();
        String rol = roleSpinner.getSelectedItem().toString();
        boolean rememberMe = rememberMeCheckBox.isChecked();

        if (user.isEmpty()) {
            Toast.makeText(this, "El campo de usuario está vacío", Toast.LENGTH_SHORT).show();
            return;
        }
        if (pass.isEmpty()) {
            Toast.makeText(this, "El campo de contraseña está vacío", Toast.LENGTH_SHORT).show();
            return;
        }

        if ((user.equals("profesor") && pass.equals("1234") && rol.equals("Usuario")) ||
            (user.equals("alexander") && pass.equals("1234") && rol.equals("Administrador"))) {
            if (rememberMe) {
                // Handle remember me functionality
                Toast.makeText(this, "Recordando usuario", Toast.LENGTH_SHORT).show();
            }
            Intent intent = new Intent(this, MenuPrincipal.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Credenciales Incorrectas", Toast.LENGTH_SHORT).show();
        }
    }
}
package com.example.nico_.reot;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class DatosArboles1 extends AppCompatActivity {
    private static final String TAG = "Ingreso como censista";

    @InjectView(R.id.input_numeroFrente) EditText _numeroFrenteText;
    @InjectView(R.id.input_numeroArbol) EditText _numeroArbolText;
    @InjectView(R.id.input_especie) EditText _especieText;


    @InjectView(R.id.btn_arboles2) Button _arbolesButton2;
    @InjectView(R.id.link_login) TextView _loginLink;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_arboles1);
        ButterKnife.inject(this);

        _arbolesButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });

        _loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the registration screen and return to the Login activity
                finish();
            }
        });
    }



    public void signup() {
        Log.d(TAG, "Signup");

        if (!validate()) {
            onSignupFailed();
            return;
        }

        _arbolesButton2.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(DatosArboles1.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Generando planilla...");
        progressDialog.show();

        String numero = _numeroFrenteText.getText().toString();
        String arbol = _numeroArbolText.getText().toString();
        String especie = _especieText.getText().toString();

        // TODO: Implement your own signup logic here.

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onSignupSuccess or onSignupFailed
                        // depending on success
                        onSignupSuccess();
                        // onSignupFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);
    }


    public void onSignupSuccess() {
        _arbolesButton2.setEnabled(true);
        setResult(RESULT_OK, null);

        Intent datosArboles2 = new Intent(DatosArboles1.this, DatosArboles2.class);
        startActivity(datosArboles2);
        //
        //
        //
        // finish();
    }

    public void onSignupFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        _arbolesButton2.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String numero = _numeroFrenteText.getText().toString();
        String arbol = _numeroArbolText.getText().toString();
        String especie = _especieText.getText().toString();

        if (numero.isEmpty()) {
            _numeroFrenteText.setError("Ingrese numero de frente");
            valid = false;
        } else {
            _numeroFrenteText.setError(null);
        }

        if (arbol.isEmpty()) {
            _numeroArbolText.setError("Debe ingresar el numero de arbol");
            valid = false;
        } else {
            _numeroArbolText.setError(null);
        }

        if (especie.isEmpty()) {
            _especieText.setError("Indique la especie");
            valid = false;
        } else {
            _especieText.setError(null);
        }




        return valid;
    }
}

package com.sourcey.materiallogindemo;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.Bind;

public class Formulario extends AppCompatActivity {
    private static final String TAG = "Ingreso como censista";

    @Bind(R.id.input_nombre) EditText _nombreText;
    @Bind(R.id.input_calle) EditText _calleText;
    @Bind(R.id.input_par) EditText _parText;
    @Bind(R.id.btn_arboles) Button _arbolesButton;
    @Bind(R.id.link_login) TextView _loginLink;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        ButterKnife.bind(this);

        _arbolesButton.setOnClickListener(new View.OnClickListener() {
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

        _arbolesButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(Formulario.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Generando planilla...");
        progressDialog.show();

        String nombre = _nombreText.getText().toString();
        String calle = _calleText.getText().toString();
        String par = _parText.getText().toString();

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
        _arbolesButton.setEnabled(true);
        setResult(RESULT_OK, null);
        finish();
    }

    public void onSignupFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        _arbolesButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String nombre = _nombreText.getText().toString();
        String calle = _calleText.getText().toString();
        String par = _parText.getText().toString();

        if (nombre.isEmpty() || nombre.length() < 7) {
            _nombreText.setError("Ingrese su nombre y apellido");
            valid = false;
        } else {
            _nombreText.setError(null);
        }

        if (calle.isEmpty() || nombre.length() < 7) {
            _calleText.setError("Ingrese la calle a censar");
            valid = false;
        } else {
            _calleText.setError(null);
        }

        if (par.isEmpty()) {
            _parText.setError("ingrese la paridad de la calle pP/iI");
            valid = false;
        } else {
            _parText.setError(null);
        }

        boolean solucion = false;

        if ((par.equals("p"))|| (par.equals("P")) || (par.equals("I")) || (par.equals("i"))) {
            solucion = true;
        valid = true;}

        if (!solucion){  _parText.setError("ingrese la paridad de la calle pP/iI");
            valid = false;
        } else {
            _parText.setError(null);
        }



        return valid;
    }
}

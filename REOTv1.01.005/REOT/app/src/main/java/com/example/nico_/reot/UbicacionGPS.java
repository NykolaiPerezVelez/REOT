package com.example.nico_.reot;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class UbicacionGPS extends AppCompatActivity {
        private static final String TAG = "Ingreso como censista";


        @InjectView(R.id.btn_arboles)
        Button _arbolesButton;


        @InjectView(R.id.latitud)
        TextView _latitud;

        @InjectView(R.id.longitud)
        TextView _longitud;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_ubicacion_gps);
            ButterKnife.inject(this);

            _arbolesButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    signup();
                }
            });

           ;
        }


        public void signup() {
            Log.d(TAG, "Signup");

            if (!validate()) {
                onSignupFailed();
                return;
            }

            _arbolesButton.setEnabled(false);

            final ProgressDialog progressDialog = new ProgressDialog(UbicacionGPS.this,
                    R.style.AppTheme_Dark_Dialog);
            progressDialog.setIndeterminate(true);
            progressDialog.setMessage("Generando planilla...");
            progressDialog.show();


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

            Intent datosArboles1 = new Intent(UbicacionGPS.this, Camara.class);
            startActivity(datosArboles1);
            //
            //
            //
            // finish();
        }

        public void onSignupFailed() {
            Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

            _arbolesButton.setEnabled(true);
        }

        public boolean validate() {
            boolean valid = true;


            return valid;
        }
    }


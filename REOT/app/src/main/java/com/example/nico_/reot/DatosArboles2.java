package com.example.nico_.reot;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import butterknife.ButterKnife;
import butterknife.InjectView;



public class DatosArboles2 extends AppCompatActivity {
    private static final String TAG = "Ingreso como censista";


    String[] estadoSanitario = {"S", "E", "D", "M"};
    String[] inclinacion = {"NO", "LI", "MI"};
    String[] ahuecamiento = {"<50%", ">50%", "No"};
    String[] cables = {"PD", "PE", "IA"};
    String[] luminaria = {"PD", "PE", "IA"};
    String[] danioMuros = {"SI", "NO"};
    String[] veredas = {"NO", "L", "I"};
    String[] podas = {"NO", "L", "S"};

    @InjectView(R.id.btn_arboles2) Button _arbolesButton2;
    @InjectView(R.id.link_login) TextView _loginLink;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_arboles2);
        ButterKnife.inject(this);



        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, estadoSanitario);
        MaterialBetterSpinner materialDesignSpinner1 = (MaterialBetterSpinner)
                findViewById(R.id.spinner1);
        materialDesignSpinner1.setAdapter(arrayAdapter1);



        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, inclinacion);
        MaterialBetterSpinner materialDesignSpinner2 = (MaterialBetterSpinner)
                findViewById(R.id.spinner2);
        materialDesignSpinner2.setAdapter(arrayAdapter2);


        ArrayAdapter<String> arrayAdapter3 = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, ahuecamiento);
        MaterialBetterSpinner materialDesignSpinner3 = (MaterialBetterSpinner)
                findViewById(R.id.spinner3);
        materialDesignSpinner3.setAdapter(arrayAdapter3);


        ArrayAdapter<String> arrayAdapter4 = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, cables);
        MaterialBetterSpinner materialDesignSpinner4 = (MaterialBetterSpinner)
                findViewById(R.id.spinner4);
        materialDesignSpinner4.setAdapter(arrayAdapter4);


        ArrayAdapter<String> arrayAdapter5 = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, luminaria);
        MaterialBetterSpinner materialDesignSpinner5 = (MaterialBetterSpinner)
                findViewById(R.id.spinner5);
        materialDesignSpinner5.setAdapter(arrayAdapter5);


        ArrayAdapter<String> arrayAdapter6 = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, danioMuros);
        MaterialBetterSpinner materialDesignSpinner6 = (MaterialBetterSpinner)
                findViewById(R.id.spinner6);
        materialDesignSpinner6.setAdapter(arrayAdapter6);


        ArrayAdapter<String> arrayAdapter7 = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, veredas);
        MaterialBetterSpinner materialDesignSpinner7 = (MaterialBetterSpinner)
                findViewById(R.id.spinner7);
        materialDesignSpinner7.setAdapter(arrayAdapter7);

        ArrayAdapter<String> arrayAdapter8 = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, podas);
        MaterialBetterSpinner materialDesignSpinner8 = (MaterialBetterSpinner)
                findViewById(R.id.spinner8);
        materialDesignSpinner8.setAdapter(arrayAdapter8);



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

        final ProgressDialog progressDialog = new ProgressDialog(DatosArboles2.this,
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
        _arbolesButton2.setEnabled(true);
        setResult(RESULT_OK, null);

        Intent datosArboles3 = new Intent(DatosArboles2.this, DatosArboles3.class);
        startActivity(datosArboles3);
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




        return valid;
    }
}
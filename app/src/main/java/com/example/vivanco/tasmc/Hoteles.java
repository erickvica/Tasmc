package com.example.vivanco.tasmc;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;


public class Hoteles extends ActionBarActivity implements View.OnClickListener {

    Spinner huespedes;
    Spinner habitaciones;
    Spinner categorias;
    String[] ophuesped = new String[]{"1 persona", "2 personas", "3 personas", "4 personas", "5 personas"};
    String[] ophabita = new String[]{"1 habitacion", "2 habitaciones", "3 habitaciones", "4 habitaciones", "5 habitaciones"};
    String[] opcatego = new String[]{"1 estrella", "2 estrellas", "3 estrellas", "4 estrellas", "5 estrellas"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoteles);
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar_hotel);
        setSupportActionBar(toolbar);

        //Habilita el boton para ir a la actividad principal en el Toolbar

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //spinner huespedes
        huespedes = (Spinner) findViewById(R.id.huespedes);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ophuesped);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        huespedes.setAdapter(dataAdapter);

        //spinner habitaciones
        habitaciones = (Spinner) findViewById(R.id.habitaciones);
        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ophabita);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        habitaciones.setAdapter(dataAdapter1);

        //spinner hotel estrellas
        categorias = (Spinner) findViewById(R.id.categoria);
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opcatego);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorias.setAdapter(dataAdapter2);

    }

    public void onStart() {
        super.onStart();
        EditText fechain = (EditText) findViewById(R.id.fechain);
        EditText fechaout = (EditText) findViewById(R.id.fechaout);

        fechain.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    DateDialog dialog = new DateDialog(v);
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    dialog.show(ft, "DatePicker");
                }
            }
        });
        fechaout.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    DateDialog dialog = new DateDialog(v);
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    dialog.show(ft, "DatePicker");
                }
            }
        });

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        //Si el id seleccionado es igual al del home regresa a la principal
        if (id == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

    }
}

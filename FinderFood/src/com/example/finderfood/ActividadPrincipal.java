package com.example.finderfood;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.content.Intent;

public class ActividadPrincipal extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_principal);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_actividad_principal, menu);
        return true;
    }
    
    public void lanzar(View view) {
        Intent i = new Intent(this, actividad2.class );
        startActivity(i);
  }
}

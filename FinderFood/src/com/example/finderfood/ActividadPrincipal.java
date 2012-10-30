package com.example.finderfood;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;
import android.content.Intent;

public class ActividadPrincipal extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_principal);
        
		//Menu de seleccion Tipo
		Spinner sp=(Spinner) findViewById(R.id.spinner1);
		ArrayAdapter<?> adapter = ArrayAdapter.createFromResource(this, R.array.Tipo, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sp.setAdapter(adapter);
		
		sp.setOnItemSelectedListener(new OnItemSelectedListener(){
			public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id){
				//Toast.makeText(parentView.getContext(), "Has elegido  "+ parentView.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();
				
			}
			
			public void onNothingSelected(AdapterView<?> parentView){}
		});
		
		//Fin Menu seleccion Rangos
		
		//Menu de seleccion Tipo
		Spinner sp2=(Spinner) findViewById(R.id.spinner2);
		ArrayAdapter<?> adapter2 = ArrayAdapter.createFromResource(this, R.array.Rango, android.R.layout.simple_spinner_item);
		adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sp2.setAdapter(adapter2);
		
		sp.setOnItemSelectedListener(new OnItemSelectedListener(){
			public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id){
				//Toast.makeText(parentView.getContext(), "Has elegido  "+ parentView.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();
				
			}
			
			public void onNothingSelected(AdapterView<?> parentView){}
		});
		
		//Fin Menu seleccion Rangos
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_actividad_principal, menu);
        return true;
    }
    
    public void lanzar(View view) {
        Intent i = new Intent(this, listarestaurantes.class );
        startActivity(i);
  }
}

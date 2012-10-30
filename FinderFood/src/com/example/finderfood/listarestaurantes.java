package com.example.finderfood;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class listarestaurantes extends Activity {

	 
	 public  void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
	     setContentView(R.layout.lista_restaurantes);
		 
	 //Lista Restaurantes
	 ListView lista=(ListView) findViewById(R.id.listView1); 
	 ArrayAdapter <?> adaptador = ArrayAdapter.createFromResource(this, R.array.Restaurante, android.R.layout.simple_list_item_1);
	 lista.setAdapter(adaptador);
	 
	 lista.setOnItemClickListener(new OnItemClickListener() {
		 public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id){
			 
			 
			 //Toast.makeText(parentView.getContext(), "Has elegido  "+ parentView.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();
				
			}

		public void onNothingSelected(AdapterView<?> parentView){}
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			lanzar(arg1);
			// TODO Auto-generated method stub
			
		}
	     });
	 }
	 
	  public void lanzar(View view) {
	        Intent i = new Intent(this, restaurante.class );
	        startActivity(i);
	  }
}

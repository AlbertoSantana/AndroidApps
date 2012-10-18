package com.example.testgps;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Listado extends ListActivity {
	String pruebas[]={"Lugar 1","Lugar 2","Lugar 3","Lugar 4","Lugar 5","...","Lugar n-1"};
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,pruebas));		
		
	}
	protected void onListItemClick(ListView list, View view, int position, long id){
		super.onListItemClick(list, view, position, id);		
	}
}

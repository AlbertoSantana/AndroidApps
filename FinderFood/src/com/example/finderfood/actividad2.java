package com.example.finderfood;
import java.util.List;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;
import com.google.android.maps.*;

public class actividad2 extends MapActivity {
	private MapView mapView;
	private static final int latitudeE6 = 19240000;
	private static final int longitudeE6 = -99120000;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.actividad2);
		
		//Menu de seleccion
		Spinner sp=(Spinner) findViewById(R.id.spinner1);
		ArrayAdapter<?> adapter = ArrayAdapter.createFromResource(this, R.array.Tipo, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sp.setAdapter(adapter);
		
		sp.setOnItemSelectedListener(new OnItemSelectedListener(){
			public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id){
				Toast.makeText(parentView.getContext(), "Has elegido  "+ parentView.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();
				
			}
			
			public void onNothingSelected(AdapterView<?> parentView){}
		});
		
		//Fin Menu seleccion
		//Mapa
		
		mapView = (MapView) findViewById(R.id.mapa);
        mapView.setBuiltInZoomControls(true);
 
        List<Overlay> mapOverlays = mapView.getOverlays();
        Drawable drawable = this.getResources().getDrawable(R.drawable.ic_launcher);
		MyOverlay itemizedOverlay = new MyOverlay(drawable, this);
 
		GeoPoint point = new GeoPoint(latitudeE6, longitudeE6);
		OverlayItem overlayitem = new OverlayItem(point, "Hola",
				"!Te saludamos desde Ciudad de México!");
 
		itemizedOverlay.addOverlay(overlayitem);
		mapOverlays.add(itemizedOverlay);
 
		MapController mapController = mapView.getController();
 
		mapController.animateTo(point);
		mapController.setZoom(6);
		
		//Fin Mapa
		

		

	}

	protected boolean isRouteDisplayed(){
		return false;
	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
	
}



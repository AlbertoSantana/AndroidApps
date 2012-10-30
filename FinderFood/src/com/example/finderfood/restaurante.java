package com.example.finderfood;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
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

public class restaurante extends MapActivity {
	private MapView mapView;
	private static final int latitudeE6 = 19240000;
	private static final int longitudeE6 = -99120000;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.restaurante);
		
		
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
		mapView.postInvalidate();
		
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
	
    public void lanzar(View view) {
        Intent i = new Intent(this, listarestaurantes.class );
        startActivity(i);
  
    }
}



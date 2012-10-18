package com.example.testgps;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends MapActivity {

	private MapView map = null;
	private MapController mapController;
	private MyLocationOverlay myLocationOverlay;
	private MapView mapView; 
	private double latitud;
	private double longitud;
	private ImageButton boton;
	OnClickListener viewClickListener;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        LocationManager milocManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);              
    
        LocationListener milocListener = new MiLocationListener();
		milocManager.requestLocationUpdates( LocationManager.GPS_PROVIDER, 0, 0, milocListener);
        
        map = (MapView)findViewById(R.id.map);
		map.setBuiltInZoomControls(true);
        
        boton = (ImageButton) findViewById(R.id.imageButton1);
        
        registerForContextMenu(boton);              
                
        inicializeMap();
    }
    
                      
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
     
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.popupmenu, menu);
        menu.setHeaderTitle("Near2Me").setHeaderIcon(R.drawable.near2me);
        menu.getItem(0).setTitle("Mapa").setIcon(R.drawable.map);
        menu.getItem(1).setTitle("Listado").setIcon(R.drawable.lista);
        menu.getItem(2).setTitle("Configuraciones").setIcon(R.drawable.settings32x32);        
       
    }
    
    public boolean onContextItemSelected(MenuItem item) {
    	 
        switch (item.getItemId()) {
            case R.id.menu1:
            	
                return true;
            case R.id.menu2:
            	try {
    				Class<?> clazz = Class.forName("com.example.testgps.Listado");
    				Intent intent = new Intent(this, clazz);
    				startActivity(intent);
    			} catch (ClassNotFoundException e) {				
    				e.printStackTrace();
    			}
                return true;
            case R.id.menu3:
                
                return true;    
            default:
                return super.onContextItemSelected(item);
        }
    }
   
    ////////////////////////////////
    @Override
    protected boolean isRouteDisplayed() {
        return false;
    }
    
    private void inicializeMap(){
    	   mapView = (MapView) findViewById(R.id.map);
           mapView.setBuiltInZoomControls(true);        
           mapController = mapView.getController();
           mapController.setZoom(16);  
           if(latitud != 0 && longitud != 0){
           int lat = (int) (latitud * 1E6);
           int lon = (int) (longitud * 1E6);
           
           mapController.animateTo(new GeoPoint(lat,lon));
           mapController.setCenter(new GeoPoint(lat,lon));
           }
           centerMyPosition();              
   }
    
   private void centerMyPosition(){
	    
        myLocationOverlay = new MyLocationOverlay(this, mapView);
        mapView.getOverlays().add(myLocationOverlay);
        myLocationOverlay.enableCompass();
        myLocationOverlay.enableMyLocation();
        
        myLocationOverlay.runOnFirstFix(new Runnable() {
            public void run() {
                mapController.animateTo(myLocationOverlay.getMyLocation());
                
            }
        });
        
}
   public class MiLocationListener implements LocationListener{

	   public void onLocationChanged(Location loc){
	   		latitud = loc.getLatitude();
   			longitud = loc.getLongitude();
   		}
   		public void onProviderDisabled(String provider){
	   		Toast.makeText( getApplicationContext(),"Gps Desactivado",Toast.LENGTH_SHORT ).show();
   		}
   		public void onProviderEnabled(String provider){
   			Toast.makeText( getApplicationContext(),"Gps Activo",Toast.LENGTH_SHORT ).show();
   		}
   		public void onStatusChanged(String provider, int status, Bundle extras){}
		
   }
}

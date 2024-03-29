package com.example.finderfood;

import java.net.URISyntaxException;
import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.View;
 
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;
public class MyOverlay extends ItemizedOverlay {
	 
	private ArrayList mapOverlays = new ArrayList();
 
	private Context context;
 
	public MyOverlay(Drawable defaultMarker) {
		  super(boundCenterBottom(defaultMarker));
	}
 
	public MyOverlay(Drawable defaultMarker, Context context) {
		  this(defaultMarker);
		  this.context = context;
	}
 
	@Override
	protected OverlayItem createItem(int i) {
		return (OverlayItem) mapOverlays.get(i);
	}
 
	@Override
	public int size() {
		return mapOverlays.size();
	}
 
	@Override
	protected boolean onTap(int index) {
		OverlayItem item = (OverlayItem) mapOverlays.get(index);
		AlertDialog.Builder dialog = new AlertDialog.Builder(context);
		dialog.setTitle(item.getTitle());
		dialog.setMessage(item.getSnippet());
		
		//dialog.show();
		
		
        
		return true;
	}
	

	




	public void addOverlay(OverlayItem overlay) {
		mapOverlays.add(overlay);
	    this.populate();
	}
 
}
package com.vertechxa.mymapsapp;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private static final String TAG = "MapsActivity";
    private GoogleMap mMap;
    private LatLng mountEverest = new LatLng(28.001377, 86.928129);
    private LatLng mountKilimanjaro = new LatLng(-3.075558, 37.344363);
    private LatLng theAlps = new LatLng(47.368955, 9.702579);

    // create marker for each
    private Marker everestMarker;
    private Marker kilimanjaroMarker;
    private Marker theAlpsMarker;

    private MarkerOptions everestMarkerOption;
    private MarkerOptions kilimanjaroMarkerOption;
    private MarkerOptions theAlpsMarkerOption;

    private List<MarkerOptions> markerOptionsList = new ArrayList<MarkerOptions>();
    private List<Marker> markerList = new ArrayList<Marker>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        everestMarkerOption = new MarkerOptions().position(mountEverest).title("Everst")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE));
        markerOptionsList.add(everestMarkerOption);

        kilimanjaroMarkerOption = new MarkerOptions().position(mountKilimanjaro).title("KiLiManjaro")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET));
        markerOptionsList.add(kilimanjaroMarkerOption);

        theAlpsMarkerOption = new MarkerOptions().position(theAlps).title("The APLS")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
        markerOptionsList.add(theAlpsMarkerOption);





//        everestMarker = mMap.addMarker(new MarkerOptions().position(mountEverest)
//                .title("Everest")
//                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
//        markerList.add(everestMarker);
//
//        kilimanjaroMarker = mMap.addMarker(new MarkerOptions().position(mountKilimanjaro)
//                .title("KiLiManjaro")
//                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
//        markerList.add(kilimanjaroMarker);
//
//        theAlpsMarker = mMap.addMarker(new MarkerOptions().position(theAlps)
//                .title("The Alps")
//                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
//        markerList.add(theAlpsMarker);

        for (MarkerOptions markerOptions : markerOptionsList) {
            Log.d(TAG, "onMapReady: " + markerOptions.getTitle());
            LatLng latLng = new LatLng(markerOptions.getPosition().latitude, markerOptions.getPosition().longitude);
            mMap.addMarker(markerOptions);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 4));
        }

//        LatLng phoenix = new LatLng(18.562351, 73.916775);
//        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(-34, 151);
//
//        mMap.addMarker(new MarkerOptions().position(phoenix).title("Marker in Phoinix Mall")
//                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
//                .alpha(1.0f));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(phoenix));
//        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(phoenix, 13)); // 1 - 20
    }
}

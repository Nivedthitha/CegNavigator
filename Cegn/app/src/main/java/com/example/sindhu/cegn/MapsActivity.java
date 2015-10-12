package com.example.sindhu.cegn;

import android.content.IntentSender;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener ,LocationListener {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private GoogleApiClient mGoogleApiClient;
    public static final String TAG = MapsActivity.class.getSimpleName();
    private final static int CONNECTION_FAILURE_RESOLUTION_REQUEST = 9000;
    private LocationRequest mLocationRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setUpMapIfNeeded();
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();

        // Create the LocationRequest object
        mLocationRequest = LocationRequest.create()
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
                .setInterval(10 * 1000)        // 10 seconds, in milliseconds
                .setFastestInterval(1000); // 1 second, in milliseconds
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
        mGoogleApiClient.connect();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mGoogleApiClient.isConnected()) {
            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
            mGoogleApiClient.disconnect();
        }
    }


    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
                mMap.setMyLocationEnabled(true);
            }

        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void handleNewLocation(Location location) {
        Log.d(TAG, location.toString());
        //double currentLatitude = location.getLatitude();
        //double currentLongitude = location.getLongitude();
        // LatLng latLng = new LatLng(13.012956, 80.235208);
        //LatLng latLng = new LatLng(currentLatitude, currentLongitude);
        //MarkerOptions options = new MarkerOptions()
        //      .position(latLng)
        //     .title("I am here!");
        //mMap.addMarker(options);
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

    }
    private void setUpMap() {
        mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
        LatLng latLng = new LatLng(13.012956, 80.235208);
        //LatLng latLng = new LatLng(currentLatitude, currentLongitude);
        MarkerOptions options = new MarkerOptions()
                .position(latLng)
                .title("IT Department");
        mMap.addMarker(options);
        mMap.addMarker(new MarkerOptions().position(new LatLng(13.009621, 80.232301)).title("GuestHouse").snippet("CEG"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(13.012036, 80.233482)).title("Center for Water Resources").snippet("CEG"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(13.011681, 80.235670)).title("CPDE").snippet("CEG"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(13.012862, 80.236368)).title("Alumini Building").snippet("CEG"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(13.012297, 80.237322)).title("Anna University Gym").snippet("CEG"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(13.012475, 80.234522)).title("Institute Of Ocean Management").snippet("CEG"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(13.010949, 80.236507)).title("Indian Bank ATM").snippet("CEG"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(13.012140, 80.235134)).title("Science And Humanities Block").snippet("CEG"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(13.012956, 80.235209)).title("IT Department").snippet("CEG"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(13.010635, 80.234072)).title("Soil Mechanics Department").snippet("CEG"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(13.008921, 80.232612)).title("DOTE").snippet("CEG"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(13.010520, 80.231443)).title("Center For Distance Education").snippet("CEG"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(13.011179, 80.232452)).title("Department of Mechanical Engineering").snippet("CEG"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(13.011419, 80.233020)).title("Tag Auditorium").snippet("CEG"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(13.013700, 80.234524)).title("Kurinji Hostel").snippet("CEG"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(13.010732, 80.231790)).title("Thazham Hostel").snippet("CEG"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(13.009746, 80.232442)).title("DOTE Canteen").snippet("CEG"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(13.011262, 80.232971)).title("Henry Maudslay Hall").snippet("CEG"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(13.013052, 80.234438)).title("2nd Block Hostel").snippet("CEG"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(13.013227, 80.234926)).title("Coffee Shop").snippet("CEG"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(13.010917, 80.235563)).title("Engineering College Guindy").snippet("CEG"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.addMarker(new MarkerOptions().position(new LatLng(13.013110, 80.236911)).title("Girls Hostel").snippet("CEG"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(13.013679, 80.238024)).title("Girls Mess").snippet("CEG"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(13.013638, 80.238544)).title("Senior Nonveg Mess").snippet("CEG"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(13.013314, 80.238786)).title("Centre For University Industry Collaboration").snippet("CEG"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(13.014249, 80.236313)).title("Gurunath Store").snippet("CEG"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(13.016199, 80.236718)).title("Environmental Science").snippet("CEG"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(13.013510, 80.235680)).title("KP").snippet("CEG"));


        mMap.animateCamera(CameraUpdateFactory.zoomTo(16));
    }

    @Override
    public void onConnected(Bundle bundle) {
        Log.i(TAG, "Location services connected.");
        Location location = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
        if (location == null) {
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
        }
        else {
            handleNewLocation(location);
        }
    }

    @Override
    public void onConnectionSuspended(int i) {
        Log.i(TAG, "Location services suspended. Please reconnect.");
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        if (connectionResult.hasResolution()) {
            try {
                // Start an Activity that tries to resolve the error
                connectionResult.startResolutionForResult(this, CONNECTION_FAILURE_RESOLUTION_REQUEST);
            } catch (IntentSender.SendIntentException e) {
                e.printStackTrace();
            }
        } else {
            Log.i(TAG, "Location services connection failed with code " + connectionResult.getErrorCode());
        }
    }

    @Override
    public void onLocationChanged(Location location) {

    }
}

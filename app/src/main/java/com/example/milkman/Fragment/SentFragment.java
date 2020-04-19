package com.example.milkman.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.milkman.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * A simple {@link Fragment} subclass.
 */
//public class SentFragment extends Fragment implements OnMapReadyCallback {
public class SentFragment extends Fragment {
    private MapView mapView;
    private GoogleMap mGoogleMap;
    CameraPosition cameraPosition;

    //String
    public SentFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sent, container, false);
        //mapView = view.findViewById(R.id.mapView1);

        return view;
    }

   /* @Override
    public void onMapReady(GoogleMap googleMap) {

        if (mapView.getVisibility() == View.VISIBLE) {
            MapsInitializer.initialize(this.getContext());
            mGoogleMap = googleMap;
            mGoogleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            mGoogleMap.getUiSettings().setAllGesturesEnabled(false);
            mGoogleMap.addMarker(new MarkerOptions().position(new LatLng(28.612912, 77.227321)).title("Delhi"));
            cameraPosition = CameraPosition.builder()
                    .target(new LatLng(28.612912, 77.227321))
                    .zoom(16)
                    .bearing(0)
                    .tilt(45)
                    .build();
            mGoogleMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        }
    }*/

}

package com.febatis.bustop.fragment;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.febatis.bustop.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapaFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_mapa, container, false);

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.frg);  //use SuppoprtMapFragment for using in fragment instead of activity  MapFragment = activity   SupportMapFragment = fragment
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

                mMap.clear(); //clear old markers



                CameraPosition googlePlex = CameraPosition.builder()
                        .target(new LatLng(-23.928465, -46.412413))
                        .zoom(15)
                        .bearing(0)
                        .tilt(0)
                        .build();

                mMap.moveCamera(CameraUpdateFactory.newCameraPosition(googlePlex));


                mMap.addMarker(new MarkerOptions()
                        .position(new LatLng(-23.928849, -46.411432))
                        .title("911")
                        .icon(bitmapDescriptorFromVector(getActivity(), R.drawable.onibus_map_icon)));

                mMap.addMarker(new MarkerOptions()
                        .position(new LatLng(-23.925850, -46.406231))
                        .title("912")
                        .snippet("Muito Lotado")
                        .icon(bitmapDescriptorFromVector(getActivity(), R.drawable.onibus_map_icon)));


                mMap.addMarker(new MarkerOptions()
                        .position(new LatLng(-23.924297, -46.413497))
                        .title("911")
                        .icon(bitmapDescriptorFromVector(getActivity(), R.drawable.onibus_map_icon)));
            }
        });

        return rootView;
    }

    private BitmapDescriptor bitmapDescriptorFromVector(Context context, int vectorResId) {
        Drawable vectorDrawable = ContextCompat.getDrawable(context, vectorResId);
        vectorDrawable.setBounds(0, 0, vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight());
        Bitmap bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        vectorDrawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }

    public static MapaFragment newInstance() {
        return new MapaFragment();
    }

}

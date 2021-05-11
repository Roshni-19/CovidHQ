package com.example.covidhq;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.covidhq.models.MyLocation;
import com.example.covidhq.models.OxygenListItem;
import com.example.covidhq.models.OxygenModel;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Oxygen extends AppCompatActivity implements AdapterView.OnItemSelectedListener  {

    OxygenModel oxygenModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        Button link, linkselected;

        final String[] admin = new String[1];

        TextView mylocationlink;


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oxygen);

        oxygenModel = new OxygenModel();
        oxygenModel.oxygens.add(new OxygenListItem("Tamil Nadu","https://stopcorona.tn.gov.in/beds.php"));
        oxygenModel.oxygens.add(new OxygenListItem("Gurgaon","http://covidggn.com/"));
        oxygenModel.oxygens.add(new OxygenListItem("Delhi","https://coviddelhi.com"));
        oxygenModel.oxygens.add(new OxygenListItem("Thane","https://covidthane.org/availabiltyOfHospitalBeds.html"));
        oxygenModel.oxygens.add(new OxygenListItem("Bengaluru","https://covidbengaluru.com/"));
        oxygenModel.oxygens.add(new OxygenListItem("Andhra Pradesh","https://covidaps.com"));
        oxygenModel.oxygens.add(new OxygenListItem("Telangana","https://covidtelangana.com"));
        oxygenModel.oxygens.add(new OxygenListItem("West Bengal","https://covidwb.com"));
        oxygenModel.oxygens.add(new OxygenListItem("Pune","https://covidpune.com"));
        oxygenModel.oxygens.add(new OxygenListItem("Ahmedabad","https://covidamd.com"));
        oxygenModel.oxygens.add(new OxygenListItem("Vadodara","https://covidbaroda.com"));
        oxygenModel.oxygens.add(new OxygenListItem("Nagpur","http://nsscdcl.org/covidbeds/AvailableHospitals.jsp"));
        oxygenModel.oxygens.add(new OxygenListItem("Nashik","https://covidnashik.com"));
        oxygenModel.oxygens.add(new OxygenListItem("Madhya Pradesh","https://covidmp.com"));
        oxygenModel.oxygens.add(new OxygenListItem("Uttar Pradesh","http://dgmhup.gov.in/en/CovidReport"));
        oxygenModel.oxygens.add(new OxygenListItem("Rajasthan","https://covidinfo.rajasthan.gov.in/COVID19HOSPITALBEDSSTATUSSTATE.aspx"));
        oxygenModel.oxygens.add(new OxygenListItem("Bhopal","https://bhopalcovidbeds.in/"));
        oxygenModel.oxygens.add(new OxygenListItem("Haryana","https://coronaharyana.in/"));
        oxygenModel.oxygens.add(new OxygenListItem("Maharashtra","https://covidbeed.com"));
        oxygenModel.oxygens.add(new OxygenListItem("Gujarat","https://covidgandhinagar.com"));
        mylocationlink = findViewById(R.id.mylocationlink);


        link = findViewById(R.id.link);
        linkselected = findViewById(R.id.linkselected);

        ArrayList<String> arrayList = new ArrayList<>();

        for (OxygenListItem o: oxygenModel.oxygens
             ) {
            arrayList.add(o.getStateName());
        }

        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,arrayList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


        MyLocation.LocationResult locationResult = new MyLocation.LocationResult(){
            @Override
            public void gotLocation(Location location){

                Geocoder geocoder;
                geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());

                try {
                    List<Address> addresses;
                    addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                    admin[0] = addresses.get(0).getAdminArea().toString();

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        OxygenListItem ob1 = oxygenModel.oxygens.stream().filter(statename -> admin[0].equals(statename.getStateName())).findAny().orElse(null);
                        mylocationlink.setText(ob1.getLink());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        };

        MyLocation myLocation = new MyLocation();
        myLocation.getLocation(this, locationResult);


        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String urlString = mylocationlink.getText().toString();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlString));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setPackage("com.android.chrome");
                startActivity(intent);

            }
        });


        linkselected.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {

                String state = spinner.getSelectedItem().toString();
                OxygenListItem ob1 = oxygenModel.oxygens.stream().filter(statename -> state.equals(statename.getStateName())).findAny().orElse(null);


                assert ob1 != null;
                String urlString = ob1.getLink();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlString));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setPackage("com.android.chrome");
                startActivity(intent);
            }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}






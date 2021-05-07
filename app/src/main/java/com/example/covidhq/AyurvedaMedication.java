package com.example.covidhq;

import android.os.Bundle;
import android.view.*;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class AyurvedaMedication extends Fragment {

    TextView ayurvedha1, ayurvedha2, ayurvedha3 ;

    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {



        return inflater.inflate(R.layout.activity_ayurveda_medication, viewGroup, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        ayurvedha1 = view.findViewById(R.id.ayurvedha1);
        ayurvedha2 = view.findViewById(R.id.ayurvedha2);
        ayurvedha3 = view.findViewById(R.id.ayurvedha3);


        ayurvedha1.setText(R.string.ayurveda_medication_1);
        ayurvedha2.setText(R.string.tabbed_ayurveda_medication);
        ayurvedha3.setText(R.string.ayurveda_medication_2);
    }
}

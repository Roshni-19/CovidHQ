package com.example.covidhq;

import android.os.Bundle;
import android.view.*;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class SiddhaMedication extends Fragment {

    TextView siddha1, siddha2, siddha3;

    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_siddha_medication, viewGroup, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        siddha1 = view.findViewById(R.id.siddha1);
        siddha2 = view.findViewById(R.id.siddha2);
        siddha3 = view.findViewById(R.id.siddha2);


        siddha1.setText(R.string.siddha_medications_1);
        siddha2.setText(R.string.tabbed_siddha_medication);
        siddha3.setText(R.string.siddha_medication_2);
    }
}

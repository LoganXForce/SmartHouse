package com.example.esp8266control.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.esp8266control.Inicio;
import com.example.esp8266control.Jardin;
import com.example.esp8266control.MainActivity;
import com.example.esp8266control.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HomeFragment extends Fragment {
    Button jardin;
    Button btnPabierto;
    Button btnPcerrado;
    Button btnSon;
    Button btnSoff;
    Button btnEon;
    Button btnEoff;
    Button btnLon;
    Button btnLoff;
    Button btnAon;
    Button btnAoff;
    Button btnA2on;
    Button btnA2off;
    DatabaseReference dref;
    String status;
    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        Button buttonClickJardin = (Button)root.findViewById(R.id.jardin);
        buttonClickJardin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Jardin.class);
                startActivity(intent);
            }
        });
        Button buttonClick0 = (Button)root.findViewById(R.id.btnPabierto);
        buttonClick0.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("Puerta");
                myRef.setValue(1);
            }
        });
        Button buttonClick1 = (Button)root.findViewById(R.id.btnPcerrado);
        buttonClick1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("Puerta");
                myRef.setValue(0);
            }
        });
        Button buttonClick2 = (Button)root.findViewById(R.id.btnSon);
        buttonClick2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("Sala");
                myRef.setValue(1);
            }
        });
        Button buttonClick3 = (Button)root.findViewById(R.id.btnSoff);
        buttonClick3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("Sala");
                myRef.setValue(0);
            }
        });
        Button buttonClick4 = (Button)root.findViewById(R.id.btnEon);
        buttonClick4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("Luz");
                myRef.setValue(1);
            }
        });
        Button buttonClick5 = (Button)root.findViewById(R.id.btnEoff);
        buttonClick5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("Luz");
                myRef.setValue(0);
            }
        });
        Button buttonClick6 = (Button)root.findViewById(R.id.btnLon);
        buttonClick6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("LuzB");
                myRef.setValue(1);
            }
        });
        Button buttonClick7 = (Button)root.findViewById(R.id.btnLoff);
        buttonClick7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("LuzB");
                myRef.setValue(0);
            }
        });
        Button buttonClick8 = (Button)root.findViewById(R.id.btnAon);
        buttonClick8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("Piso1");
                myRef.setValue(1);
            }
        });
        Button buttonClick9 = (Button)root.findViewById(R.id.btnAoff);
        buttonClick9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("Piso1");
                myRef.setValue(0);
            }
        });
        Button buttonClick10 = (Button)root.findViewById(R.id.btnA2on);
        buttonClick10.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("Aire");
                myRef.setValue(1);
            }
        });
        Button buttonClick11 = (Button)root.findViewById(R.id.btnA2off);
        buttonClick11.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("Aire");
                myRef.setValue(0);
            }
        });
        final TextView textView = root.findViewById(R.id.text_home);


        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        dref= FirebaseDatabase.getInstance().getReference();
        return root;
    }
}
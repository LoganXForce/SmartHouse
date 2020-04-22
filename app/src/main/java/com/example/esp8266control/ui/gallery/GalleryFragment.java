package com.example.esp8266control.ui.gallery;

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

import com.example.esp8266control.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class GalleryFragment extends Fragment {
    Button btnPabierto;
    Button btnPcerrado;
    Button btnSon;
    Button btnSoff;
    Button btnEon;
    Button btnEoff;
    Button btnLon;
    Button btnLoff;


    DatabaseReference dref;
    String status;
    private GalleryViewModel galleryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        Button buttonClick0 = (Button)root.findViewById(R.id.btnPabierto);
        buttonClick0.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("Piso2");
                myRef.setValue(1);
            }
        });
        Button buttonClick1 = (Button)root.findViewById(R.id.btnPcerrado);
        buttonClick1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("Piso2");
                myRef.setValue(0);
            }
        });
        Button buttonClick2 = (Button)root.findViewById(R.id.btnSon);
        buttonClick2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("AireB");
                myRef.setValue(1);
            }
        });
        Button buttonClick3 = (Button)root.findViewById(R.id.btnSoff);
        buttonClick3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("AireB");
                myRef.setValue(0);
            }
        });
        Button buttonClick4 = (Button)root.findViewById(R.id.btnEon);
        buttonClick4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("LuzC");
                myRef.setValue(1);
            }
        });
        Button buttonClick5 = (Button)root.findViewById(R.id.btnEoff);
        buttonClick5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("LuzC");
                myRef.setValue(0);
            }
        });
        Button buttonClick6 = (Button)root.findViewById(R.id.btnLon);
        buttonClick6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("LuzD");
                myRef.setValue(1);
            }
        });
        Button buttonClick7 = (Button)root.findViewById(R.id.btnLoff);
        buttonClick7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("LuzD");
                myRef.setValue(0);
            }
        });

        final TextView textView = root.findViewById(R.id.text_gallery);
        galleryViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        dref= FirebaseDatabase.getInstance().getReference();
        return root;
    }
}
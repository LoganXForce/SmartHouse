package com.example.esp8266control;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    Button on;
    Button off;
    TextView Humedad;
    DatabaseReference dref;
    String status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            on =  findViewById(R.id.on);
            off =  findViewById(R.id.off);
            Humedad =  findViewById(R.id.Humedad);
            dref= FirebaseDatabase.getInstance().getReference();
            dref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                status=dataSnapshot.child("Humedad").getValue().toString();
                Humedad.setText(status);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
            on.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = database.getReference("Puerta");
                    myRef.setValue(1);
                }
            });
            off.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = database.getReference("Puerta");
                    myRef.setValue(0);
                }
            });
        }

        public void Menu(View View){
            Intent MenuPrincipal = new Intent(this, Inicio.class);
            startActivity(MenuPrincipal);
        }


    }


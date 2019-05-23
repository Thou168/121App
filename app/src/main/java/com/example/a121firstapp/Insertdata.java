package com.example.a121firstapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a121firstapp.Class_item.item_add_pro;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Insertdata extends AppCompatActivity {

    EditText key,image,name,price;
    Button btninsert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertdata);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table = database.getReference("Product");

        key = (EditText)findViewById(R.id.edt_key);
        image = (EditText)findViewById(R.id.img_view);
        name = (EditText)findViewById(R.id.edt_name);
        price = (EditText)findViewById(R.id.edt_price);

        btninsert = (Button)findViewById(R.id.btninsert);
        btninsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                table.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.child(key.getText().toString()).exists()){
                            Toast.makeText(Insertdata.this,"already data",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            item_add_pro add_pro = new item_add_pro(image.getText().toString(),name.getText().toString(),price.getText().toString());
                            table.child(key.getText().toString()).setValue(add_pro);
                            Toast.makeText(Insertdata.this,"Successfull",Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}

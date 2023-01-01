package com.example.practical05;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<String> cart = new ArrayList<>();
    public static ArrayList<Integer> cost = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.option1,menu);
        return true;
    }
//    public void onClickPasta(View view){
//        Intent i=new Intent(getApplicationContext(),PastaPage.class);
//        startActivity(i);
//
//    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch(item.getItemId())
        {
            case R.id.item1:
                Toast.makeText(this,"Pasta is selected",Toast.LENGTH_SHORT).show();
                Intent i=new Intent(getApplicationContext(),PastaPage.class);
                startActivity(i);
                return true;
            case R.id.item2:
                Toast.makeText(this,"Pizza is selected",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.pizzaopt1:
                Toast.makeText(this,"Veg Pizza is selected",Toast.LENGTH_SHORT).show();
                Intent i1=new Intent(getApplicationContext(),VegPizzaPage.class);
                startActivity(i1);
                return true;
            case R.id.pizzaopt2:
                Toast.makeText(this,"Non-veg Pizza is selected",Toast.LENGTH_SHORT).show();
                Intent i2=new Intent(getApplicationContext(),NonVegPizzaPage.class);
                startActivity(i2);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }

    }
}
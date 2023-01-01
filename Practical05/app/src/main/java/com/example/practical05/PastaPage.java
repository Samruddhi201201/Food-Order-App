package com.example.practical05;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;

public class PastaPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //ArrayList arrayList=new ArrayList();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasta_page);
        ImageView iv1=(ImageView) findViewById(R.id.imageView2);
        ImageView iv2=(ImageView) findViewById(R.id.imageView4);
        iv1.setOnCreateContextMenuListener(this);
        iv1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                PopupMenu popupMenu=new PopupMenu(PastaPage.this,iv1);
                popupMenu.getMenuInflater().inflate(R.menu.mpasta,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        Toast.makeText(PastaPage.this,"Added to Cart",Toast.LENGTH_SHORT).show();
                        MainActivity.cart.add("White Pasta 120/-");
                        MainActivity.cost.add(120);
                        return true;

                    }
                });
                popupMenu.show();
            }
        });
//        red pasta popup code
        iv2.setOnCreateContextMenuListener(this);
        iv2.setOnClickListener(new View.OnClickListener(){
            public void  onClick(View view){
                PopupMenu popupMenu=new PopupMenu(PastaPage.this,iv2);
                popupMenu.getMenuInflater().inflate(R.menu.mpasta2,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        Toast.makeText(PastaPage.this,"Added to Cart",Toast.LENGTH_SHORT).show();
                        MainActivity.cart.add("Red Sauce Pasta 100/-");
                        MainActivity.cost.add(100);
                        return true;
                    }
                });
                popupMenu.show();
            }
        });
        //passing arraylist to Cart activity
//        Intent i = new Intent(this,Cart.class);
//        i.putExtra("mylist", arrayList);

        Intent intent =new Intent(PastaPage.this,Cart.class);
        intent.putStringArrayListExtra("arrayList ",MainActivity.cart);
        //cost bhi add karo
        //adding context menulisteners inside oncreate
        ImageView iv01=(ImageView) findViewById(R.id.imageView2);
        iv01.setOnCreateContextMenuListener(this);

        ImageView iv02=(ImageView) findViewById(R.id.imageView4);
        iv02.setOnCreateContextMenuListener(this);



    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.customize,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.customize:
                Intent i01=new Intent(PastaPage.this,CustomizePage.class);
                startActivity(i01);
                return true;
        }
        return false;
    }
}
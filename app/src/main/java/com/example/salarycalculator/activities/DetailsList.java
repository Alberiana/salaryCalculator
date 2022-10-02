//package com.example.salarycalculator;
//
//import android.app.AlertDialog;
//import android.content.DialogInterface;
//import android.content.Intent;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.os.AsyncTask;
//import android.os.Bundle;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.ListAdapter;
//import android.widget.ListView;
//import android.widget.SimpleAdapter;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//
//public class DetailList extends AppCompatActivity {
//
//    ListView lvView;
//    UsersAdapter adapter;
//    DatabaseHelper mDataBaseHelper;
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main_menu, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//
//        if(item.getItemId()==R.id.addNew){
//            Intent intent=new Intent(DetailsOfList.this, MainActivity.class);
//            startActivity(intent);
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.list_layout);
//
//        ListView mListView = (ListView) findViewById(R.id.userList);
//        mDataBaseHelper = new DatabaseHelper(this);
//
//        ArrayList<String> arrayList = new ArrayList<>();
//        Cursor data = mDataBaseHelper.getData();
//
//        if(data.getCount() == 0)
//        {
//            Toast.makeText(this, "The database was empty", Toast.LENGTH_SHORT).show();
//        }
//        else {
//            while (data.moveToNext()) {
//                arrayList.add(data.getString(1));
//                arrayList.add(data.getString(2));
//                arrayList.add(data.getString(3));
//                arrayList.add(data.getString(4));
//                arrayList.add(data.getString(5));
//                ListAdapter listAdapter = new ArrayAdapter<>(DetailsOfList.this, android.R.layout.simple_list_item_1, arrayList);
//                mListView.setAdapter(listAdapter);
////
////                mListView.setOnItemLongClickListener((adapterView, view, listItem, l) -> {
////                    new AlertDialog.Builder(DetailsOfList.this)
////                            .setTitle("Do you want to remove " + arrayList.get(listItem) + " from list")
////                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
////                                @Override
////                                public void onClick(DialogInterface dialogInterface, int i) {
////                                    arrayList.remove(listItem);
////                                    listAdapter.notify();
////                                }
////                            }).setNegativeButton("No", (dialogInterface, i) -> dialogInterface.dismiss()).create().show();
////                    return false;
////                });
//            };
//        }
//
//
//    }
//}
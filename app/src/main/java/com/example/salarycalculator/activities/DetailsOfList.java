package com.example.salarycalculator.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.salarycalculator.DatabaseHelper;
import com.example.salarycalculator.R;
import com.example.salarycalculator.UsersTable;
import com.example.salarycalculator.adapters.UsersAdapter;
import com.example.salarycalculator.models.UsersModel;

public class DetailsOfList extends AppCompatActivity {

    ListView lvView;
    UsersAdapter adapter;
    Animation animation=null;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.addNew) {
            Intent intent = new Intent(DetailsOfList.this, MainActivity_rl.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);
        lvView = findViewById(R.id.userList);
        adapter = new UsersAdapter(DetailsOfList.this);
        lvView.setAdapter(adapter);
        animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.anim);
        animation.setDuration(200);
        lvView.setAnimation(animation);
        animation=null;
        lvView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                lvView.removeViewAt(i);
                adapter.notifyDataSetChanged();
                return true;
            }
        });

        new LoadDataAsync().execute();
    }

    private void getDbData() {
        lvView = findViewById(R.id.userList);
        SQLiteDatabase objDb = new DatabaseHelper(DetailsOfList.this).getWritableDatabase();
        Cursor c = objDb.query(UsersTable.TABLE_NAME,
                new String[]{"id", UsersTable.NAME, UsersTable.surname,
                        UsersTable.pagabr, UsersTable.kontributi_pensional,
                        UsersTable.pagae_tatueshme},
                "", null, "", "", "");
        if (c.getCount() > 0) {
            c.moveToFirst();
            while (c.isAfterLast() == false) {
                adapter.dataset.add(new UsersModel(c.getInt(0),
                        c.getString(1),
                        c.getString(2),
                        c.getString(3),
                        c.getString(4),
                        c.getString(5)
                ));

                c.moveToNext();
            }
            lvView.setOnItemLongClickListener((adapterView, view, listItem, l) -> {
                new AlertDialog.Builder(DetailsOfList.this)
                        .setTitle("Do you want to remove from list? ")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                adapter.dataset.remove(listItem);
                                adapter.notifyDataSetChanged();
                            }
                        }).setNegativeButton("No", (dialogInterface, i) -> dialogInterface.dismiss()).create().show();
                return false;
            });
        }
    }
    public class LoadDataAsync extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            getDbData();
            return null;
        }
        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            adapter.notifyDataSetChanged();
        }
    }
}
package com.google.profile;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class ListTree extends AppCompatActivity {

    ListView lvTree;
    ArrayList<Tree> arrayTree;
    TreeAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        lvTree = (ListView) findViewById(R.id.lv_tree);
        arrayTree = new ArrayList<>();

        arrayTree.add(new Tree("Cây Đa", R.drawable.da));
        arrayTree.add(new Tree("Cây Dừa", R.drawable.dua));
        arrayTree.add(new Tree("Cây Si", R.drawable.si));
        arrayTree.add(new Tree("Cây Xương Rồng", R.drawable.xuong_rong));
        arrayTree.add(new Tree("Cây Xấu Hổ", R.drawable.xau_ho));

        adapter = new TreeAdapter(ListTree.this, R.layout.activity_row_list, arrayTree);

        lvTree.setAdapter(adapter);

        lvTree.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                XacNhanXoa(i);
                return false;
            }
        });

        lvTree.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        Intent intent_CayDa = new Intent(ListTree.this, CayDa.class);
                        startActivity(intent_CayDa);
                        break;
                    case 1:
                        Intent intent_CayDua = new Intent(ListTree.this, CayDua.class);
                        startActivity(intent_CayDua);
                        break;
                    case 2:
                        Intent intent_CaySi = new Intent(ListTree.this, CaySi.class);
                        startActivity(intent_CaySi);
                        break;
                    case 3:
                        Intent intent_CayXuongRong = new Intent(ListTree.this, CayXuongRong.class);
                        startActivity(intent_CayXuongRong);
                        break;
                    case 4:
                        Intent intent_CayXauHo = new Intent(ListTree.this, CayXauHo.class);
                        startActivity(intent_CayXauHo);
                        break;
                }
            }
        });

        BottomNavigationView navigationView = findViewById(R.id.list_bottom_nav);

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_profile:
                        Intent intent_profile = new Intent(ListTree.this, ProfileActivity.class);
                        startActivity(intent_profile);
                        break;
                }
                return true;
            }
        });
    }

    public void XacNhanXoa(int position) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Thông Báo!");
        alertDialog.setMessage("Bạn có muốn xóa cây này?");

        alertDialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                arrayTree.remove(position);
                adapter.notifyDataSetChanged();
            }
        });

        alertDialog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alertDialog.show();
    }
}

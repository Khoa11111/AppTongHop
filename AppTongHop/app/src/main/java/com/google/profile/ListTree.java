package com.google.profile;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

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

        arrayTree.add(new Tree("Cây Đa","đẹp", R.drawable.da));
        arrayTree.add(new Tree("Cây Dừa","đẹp", R.drawable.dua));
        arrayTree.add(new Tree("Cây Si","đẹp", R.drawable.si));

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
                if (arrayTree.get(i).equals(0)){
                    Intent intent = new Intent(ListTree.this, CayDa.class);
                    startActivity(intent);
                } ;
            }
        });
    }
    public void XacNhanXoa(int position){
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

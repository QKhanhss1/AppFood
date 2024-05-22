package com.example.contentproviders;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Contacts;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.contentproviders.model.Contact;

import java.util.ArrayList;

public class Danhba extends AppCompatActivity {

    private static final int REQUES_CODE_ASK_PERMISSION = 1001;
    ListView lvdanhba;
    ArrayList<Contact> dsDanhBa;
    ArrayAdapter<Contact> adapterDanhba;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.danhba);
        addcontrol();
        showonCOntactFromDevice();
    }

    private void showonCOntactFromDevice() {
        if (checkSelfPermission(Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted. Ask for permission.
            requestPermissions(new String[]{Manifest.permission.READ_CONTACTS}, REQUES_CODE_ASK_PERMISSION);
        } else {
            //Lay contact trong dien thaoi
            Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
            //Tra ve 1 cursor quan ly du lieu trong dien thaoi
            Cursor cursor = getContentResolver().query(uri, null, null, null, null);
            dsDanhBa.clear();
            while (cursor.moveToNext()) {
                //Lay thong tin trong dien thoai
                String tenCotName = ContactsContract.Contacts.DISPLAY_NAME;
                //Lay thogn tin sodienthaoi
                String tenCotPhone = ContactsContract.CommonDataKinds.Phone.NUMBER;
                //Lay vi tri cot
                int viTriCotName = cursor.getColumnIndex(tenCotName);
                int viTriCotPhone = cursor.getColumnIndex(tenCotPhone);
                //Lay du lieu trong cac cot ra
                String name = cursor.getString(viTriCotName);
                String phone = cursor.getString(viTriCotPhone);

                //Dua vao mang
                Contact contact = new Contact(name, phone);
                dsDanhBa.add(contact);
                adapterDanhba.notifyDataSetChanged();
            }
        }
    }
    private void addcontrol() {
        lvdanhba = findViewById(R.id.lvDanhba);
        dsDanhBa = new ArrayList<>();
        adapterDanhba = new ArrayAdapter<>(
                Danhba.this, android.R.layout.simple_list_item_1,dsDanhBa
        );
        lvdanhba.setAdapter(adapterDanhba);
    }
}

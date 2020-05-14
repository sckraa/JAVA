package com.example.smsstats;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactFragment extends Fragment {

    private ArrayList<Contact> listContact = new ArrayList<Contact>();
    private ContactAdapter contactAdapter = new ContactAdapter(listContact);
    private Boolean creation = true;

    public ContactFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LocalBroadcastManager.getInstance(getContext()).registerReceiver(broadcastReceiver, new IntentFilter("DATA_ACTION"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_contacts, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerViewContacts = view.findViewById(R.id.recyclerView_contacts);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerViewContacts.setLayoutManager(layoutManager);

        if( this.creation ) {
            this.retrieveContacts(getContext().getContentResolver());
            contactAdapter.notifyDataSetChanged();
            creation = false;
        }

        recyclerViewContacts.setAdapter(contactAdapter);
    }

    private void retrieveContacts(ContentResolver contentResolver)
    {
        if(ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED){
            if(shouldShowRequestPermissionRationale(Manifest.permission.READ_CONTACTS))
            {
                
            }
            else
            {
                this.askForPermission();
            }
        }
        else {
            final Cursor cursor = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);

            if (cursor == null) {
                return;
            }
            if (cursor.moveToFirst()) {
                do {
                    
                    final long id = cursor.getLong(cursor.getColumnIndex(ContactsContract.Data._ID));
                    final int hasPhoneNumber = cursor.getInt(cursor.getColumnIndex(ContactsContract.Data.HAS_PHONE_NUMBER));
                    
                    if (hasPhoneNumber > 0) {

                        String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Data.DISPLAY_NAME));
                        String phone = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

                        if (phone.contains(" ")){
                            phone = phone.replaceAll("\\s", "");
                        }

                        Contact contact = new Contact(name, phone);

                        listContact.add(contact);
                    }

                } while (cursor.moveToNext());
            }
            cursor.close();
        }
    }

    private void askForPermission()
    {
        requestPermissions(new String[] {Manifest.permission.READ_CONTACTS }, 2);
    }

    private final BroadcastReceiver broadcastReceiver = new BroadcastReceiver()
    {
        @Override
        public void onReceive(Context context, Intent intent)
        {
            if ("DATA_ACTION".equals(intent.getAction()))
            {
                try {
                    ArrayList<String> listSmsAuthor = intent.getStringArrayListExtra("listSmsAuthor");
                    for (int i = 0; i < listContact.size(); i++) {
                        for (int j = 0; j < listSmsAuthor.size(); j++) {
                            if (listContact.get(i).getPhone().equals(listSmsAuthor.get(j))) {
                                listContact.get(i).setSmsCount(j + 1);
                            }
                        }

                    }
                    contactAdapter.notifyDataSetChanged();
                }
                catch (Exception e) {
                    Log.d("info", "no info about contacts");
                }
            }
        }
    };

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(broadcastReceiver);
    }
}


package com.example.smsstats;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder>{

    private ArrayList<Contact> listData;

    public ContactAdapter(ArrayList<Contact> listData) {
        this.listData = listData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.fragment_contacts_item, parent, false);
        
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Contact contact = listData.get(position);

        holder.textView.setText(contact.getName());
        holder.textPhone.setText(contact.getPhone());
        holder.textSms.setText(contact.getSmsCount() + " sms ");
    }


    @Override
    public int getItemCount() {
        return listData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;
        public TextView textPhone;
        public TextView textSms;
        public LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            this.textView = (TextView) itemView.findViewById(R.id.textView_contacts_item);
            this.textPhone = (TextView) itemView.findViewById(R.id.textView_contact_phone);
            this.textSms = (TextView) itemView.findViewById(R.id.textView_contact_smsCount);

            linearLayout = (LinearLayout)itemView.findViewById(R.id.linearLayout);
        }
    }
}


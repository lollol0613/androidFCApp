package com.example.raina.poketbuddy;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class FriendListAdapter extends RecyclerView.Adapter<FriendListAdapter.ViewHolder> {

    ArrayList<Friend> friendList;

    public FriendListAdapter(ArrayList<Friend> friendlist) {
        this.friendList = friendlist;
    }


    @Override
    public FriendListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.friend_cell_row,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mTxtName.setText(friendList.get(position).getName());
        holder.mTxtPhone.setText(friendList.get(position).getPhone_number());


    }

    @Override
    public int getItemCount() {
        return friendList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener {
        // each data item is just a string in this case
        public TextView mTxtName,mTxtPhone;
        public Button mBtnCall,mBtnSMS,mBtnDelete,mBtnLocation;

        public ViewHolder(View view) {
            super(view);

            view.setOnClickListener(this);
            view.setOnLongClickListener(this);


            this.mTxtPhone = view.findViewById(R.id.userPhone);
            this.mTxtName = view.findViewById(R.id.userTitle);

            this.mBtnCall = view.findViewById(R.id.btnCall);
            this.mBtnSMS = view.findViewById(R.id.btnSMS);
            this.mBtnLocation = view.findViewById(R.id.btnMap);
            this.mBtnDelete = view.findViewById(R.id.btnDelete);
        }

        @Override
        public void onClick(View view) {
            clickListener.onItemClick(view,getAdapterPosition());
        }

        @Override
        public boolean onLongClick(View view) {
            clickListener.onItemLongClick(view,getAdapterPosition());
            return false;
        }
    }


    public static ClickListener clickListener;

    public void setOnItemClickListener(ClickListener listener)
    {
        FriendListAdapter.clickListener = listener;
    }

    public interface ClickListener {
        void onItemClick (View v, int Position);
        void onItemLongClick (View v, int Position);
    }
}


package com.example.luxevistaresort;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;
import android.widget.Toast;
import java.util.ArrayList;


public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.RoomViewHolder> {
    Context context;
    List<Room> roomList;
    List<Room> roomListFull;
    public RoomAdapter(Context context, List<Room> roomList) {
        this.context = context;
        this.roomList = roomList;
        this.roomListFull = new ArrayList<>(roomList);
    }

    @NonNull
    @Override
    public RoomAdapter.RoomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_room,parent,false);

        return new RoomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RoomAdapter.RoomViewHolder holder, int position) {
        Room room = roomList.get(position);
        holder.textRoom.setText(room.getName());
        // For now, using Glide to load image from URL or placeholder if needed
        Glide.with(context)
                .load(room.getImage()) // could be a URL or resource
                .placeholder(R.drawable.room1);



        holder.bookButton.setOnClickListener(v ->
                Toast.makeText(context, "Booked: " + room.getName(), Toast.LENGTH_SHORT).show()
        );


    }

    @Override
    public int getItemCount() {
        return roomList.size();
    }
    // 💬 New: Filter Logic
    public void filterList(String text) {
        roomList.clear();
        if (text.isEmpty()) {
            roomList.addAll(roomListFull);
        } else {
            text = text.toLowerCase();
            for (Room room : roomListFull) {
                if (room.getName().toLowerCase().contains(text)) {
                    roomList.add(room);
                }
            }
        }
        notifyDataSetChanged();
    }

    public static class RoomViewHolder extends RecyclerView.ViewHolder {

 ImageView iconRoom;
TextView textRoom;
 Button bookButton;

        public RoomViewHolder(@NonNull View itemView) {
 super(itemView);
 iconRoom = itemView.findViewById(R.id.icon_room1);
 textRoom = itemView.findViewById(R.id.text_room1);
 bookButton = itemView.findViewById(R.id.BTN_BOOK);
 }
 }
}

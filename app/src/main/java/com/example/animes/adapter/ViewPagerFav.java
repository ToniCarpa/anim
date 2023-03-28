/*
package com.example.animes.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animejson.R;
import com.example.animejson.model.Anime;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ViewPagerFav extends RecyclerView.Adapter<ViewPagerFav.ViewPagerViewHolder> {
    private Context context;
    private List<Anime> itemsList;

    public ViewPagerFav(Context context, List<Anime> items) {
        this.context = context;
        this.itemsList = itemsList;
    }

    @NonNull
    @Override
    public ViewPagerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_fav_detail, parent, false );
        return new ViewPagerViewHolder(view);    }

    @Override
    public void onBindViewHolder(@NonNull ViewPagerViewHolder holder, int position) {
        holder.name.setText(itemsList.get(position).getName());
        holder.oriname.setText(itemsList.get(position).getOriginalname());
        holder.year.setText(itemsList.get(position).getYear());
        holder.type.setText(itemsList.get(position).getType());
        try {
            Picasso.get().load(itemsList.get(position).getImage())
                    .fit()
                    .centerCrop()
                    .into(holder.image);
        } catch (NullPointerException e) {
            Log.d("Null Pointer: " , e.toString());
        }
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    public class ViewPagerViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;
        TextView oriname;
        TextView year;
        TextView type;
        public ViewPagerViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.favImgRowFav);
            name = itemView.findViewById(R.id.favTitRoxTxt);
            oriname = itemView.findViewById(R.id.favOriNameRowTxt);
            year = itemView.findViewById(R.id.favYearRowTxt);
            type = itemView.findViewById(R.id.favTypeRowTxt);
        }
    }
}
*/

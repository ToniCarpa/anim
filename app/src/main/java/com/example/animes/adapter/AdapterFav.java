/*
package com.example.animes.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animejson.R;
import com.example.animejson.model.Anime;
import com.example.animejson.view.DetailFavorite;
import com.example.animes.R;
import com.example.animes.model.Anime;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AdapterFav extends RecyclerView.Adapter<AdapterFav.FavViewHolder> {
    Context context;
    List<Anime> listAnime;

    public AdapterFav(Context context, List<Anime> listAnime) {
        this.context = context;
        this.listAnime = listAnime;
    }

    @NonNull
    @Override
    public FavViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.row_fav_detail, parent, false);
        return new FavViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavViewHolder holder, int position) {
        holder.name.setText(listAnime.get(position).getName());
        holder.oriname.setText(listAnime.get(position).getOriginalname());
        holder.description.setText(listAnime.get(position).getDescription());
        holder.year.setText(listAnime.get(position).getYear());
        holder.type.setText(listAnime.get(position).getType());
        holder.favorite.setImageResource(R.drawable.ic_baseline_favorite_24);

        Picasso.get().load(listAnime.get(position).getImage())
                .fit()
                .centerCrop()
                .into(holder.image);

        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailFavorite.class);
                intent.putParcelableArrayListExtra("animeList", (ArrayList) listAnime);
                intent.putExtra("position", holder.getAdapterPosition());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listAnime.size();
    }

    public class FavViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;
        TextView oriname;
        TextView description;
        TextView year;
        TextView type;
        ImageView favorite;
        ConstraintLayout constraintLayout;

        public FavViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.favImgRowFav);
            name = itemView.findViewById(R.id.favTitRoxTxt);
            oriname = itemView.findViewById(R.id.favOriNameRowTxt);
            description = itemView.findViewById(R.id.favDescRowTxt);
            year = itemView.findViewById(R.id.favYearRowTxt);
            type = itemView.findViewById(R.id.favTypeRowTxt);
            favorite = itemView.findViewById(R.id.favFavRowFav);
            constraintLayout = itemView.findViewById(R.id.rowFavLayout);
        }
    }
}
*/

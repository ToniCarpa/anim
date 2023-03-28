
package com.example.animes.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animes.R;
import com.example.animes.model.Anime;
import com.example.animes.view.DetailActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AdapterList extends RecyclerView.Adapter<AdapterList.ListViewHolder> {
    private Context context;
    private List<Anime> animes;

    public AdapterList(Context context, List<Anime> animes) {
        this.context = context;
        this.animes = animes;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.row_list, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        holder.name.setText(animes.get(position).getName());
        holder.description.setText(animes.get(position).getDescription());
        holder.year.setText(animes.get(position).getYear());
        holder.type.setText(animes.get(position).getType());

        Picasso.get().load(animes.get(position).getImage())
                .fit()
                .centerCrop()
                .into(holder.image);

        holder.favorite.setImageResource(R.drawable.ic_baseline_favorite_border_24);

        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putParcelableArrayListExtra("animeList", (ArrayList) animes);
                intent.putExtra("position", holder.getAdapterPosition());
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                }
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return animes.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;
        TextView description;
        TextView year;
        TextView type;
        ImageView favorite;
        ConstraintLayout constraintLayout;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.rowListImage);
            name = itemView.findViewById(R.id.rowTitList);
            description = itemView.findViewById(R.id.rowDescList);
            year = itemView.findViewById(R.id.rowYearList);
            type = itemView.findViewById(R.id.rowDemotxtList);
            favorite = itemView.findViewById(R.id.rowImageFavList);
            constraintLayout = itemView.findViewById(R.id.rowListLayout);
        }
    }
}


package io.mechatron.thesis.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import io.mechatron.thesis.R;
import io.mechatron.thesis.models.Reservation;

/**
 * Created by migz on 1/2/17.
 */

public class ReservationsAdapter extends RecyclerView.Adapter<ReservationsAdapter.ViewHolder> {

    private List<Reservation> reservations;

    public ReservationsAdapter() {
        reservations = new ArrayList<>();
        reservations.add(new Reservation("http://www.litorehotel.com/web/en/images/placeholders/1920x1200-0.jpg", "Awesome Place", 23235.0534, 34));
        reservations.add(new Reservation("http://www.college-hotel.com/client/cache/contenu/_500____college-hotelp1diapo1_718.jpg", "Er", 23235.0534, 34));
        reservations.add(new Reservation("https://media-cdn.tripadvisor.com/media/photo-s/02/39/a9/e9/warwick-seattle-hotel.jpg", "Er", 23235.0534, 34));
        reservations.add(new Reservation("http://www.claytoncrownhotel.com/wp-content/uploads/2015/02/exec_room.jpg", "Er", 23235.0534, 34));
        reservations.add(new Reservation("http://hotelinnvestor.com/content/uploads/2015/09/grand-hotel-excelsior_masthead.jpg", "Er", 23235.0534, 34));
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_reservation, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Reservation reservation = reservations.get(position);

        holder.name.setText(reservation.name);
        holder.reviews.setText(String.format("%d reviews", reservation.reviews));
        holder.price.setText(String.format("PHP%.2f", reservation.price));

        // load image
        Glide.with(holder.itemView.getContext()).load(reservation.imageUrl).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return reservations.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView name;
        TextView price;
        TextView reviews;

        public ViewHolder(View itemView) {
            super(itemView);

            image = (ImageView) itemView.findViewById(R.id.image);
            name = (TextView) itemView.findViewById(R.id.name);
            price = (TextView) itemView.findViewById(R.id.price);
            reviews = (TextView) itemView.findViewById(R.id.reviews);
        }
    }

}

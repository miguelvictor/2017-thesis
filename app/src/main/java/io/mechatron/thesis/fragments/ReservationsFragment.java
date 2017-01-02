package io.mechatron.thesis.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.mechatron.thesis.R;
import io.mechatron.thesis.adapters.ReservationsAdapter;

/**
 * Created by migz on 1/2/17.
 */

public class ReservationsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        RecyclerView list = (RecyclerView) inflater.inflate(R.layout.fragment_reservations, container, false);

        list.setLayoutManager(new LinearLayoutManager(getActivity()));
        list.setAdapter(new ReservationsAdapter());

        return list;
    }
}

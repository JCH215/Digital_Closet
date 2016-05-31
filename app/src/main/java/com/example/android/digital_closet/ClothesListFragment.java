package com.example.android.digital_closet;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.digital_closet.dummy.DummyContent;


public class ClothesListFragment extends Fragment {

    private int mColumnCount = 1;


    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ClothesListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_clothes_item_list, container, false);

        FloatingActionButton addFloatingActionButton = (FloatingActionButton) view.findViewById(R.id.addItemFab);
        addFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddClothesFragment addClothesFragment = new AddClothesFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container, addClothesFragment);
                fragmentTransaction.addToBackStack("addClothes");
                fragmentTransaction.commit();
            }
        });
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.list);
        // Set the adapter

        Context context = recyclerView.getContext();

        if (mColumnCount <= 1) {
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
        } else {
            recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
        }
        recyclerView.setAdapter(new MyClothesItemRecyclerViewAdapter(DummyContent.ITEMS));

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }


}

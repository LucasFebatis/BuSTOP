package com.febatis.bustop.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.febatis.bustop.R;
import com.febatis.bustop.adapter.HistoricoAdapter;
import com.febatis.bustop.model.Historico;

import java.util.ArrayList;

public class HistoricoFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    ArrayList<Historico> myDataset;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_historico, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        setupData();
        setupRecyclerView();
    }

    public static HistoricoFragment newInstance() {
        return new HistoricoFragment();
    }

    void setupData() {
        myDataset = new ArrayList<>();

        myDataset.add(new Historico());
        myDataset.add(new Historico());
        myDataset.add(new Historico());

    }

    void setupRecyclerView() {
        recyclerView = getActivity().findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        mAdapter = new HistoricoAdapter(myDataset);
        recyclerView.setAdapter(mAdapter);
    }
}

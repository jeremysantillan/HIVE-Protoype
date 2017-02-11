package com.santillanj.hiveproto.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.santillanj.hiveproto.Adapters.AllServicesAdapter;
import com.santillanj.hiveproto.Model.CateringServices;
import com.santillanj.hiveproto.R;

import java.util.ArrayList;

/**
 * Created by Jeremy on 2/10/2017.
 */

public class Recommended extends Fragment{

    private AllServicesAdapter mAdapter;
    private RecyclerView recyclerView;

    private String TAG = "AllServicesFragment";
    private String KEY_LAYOUT_MANAGER ="layoutManager";
    private static final int GRID_COLUMNS = 2;

    protected RecyclerView.LayoutManager mLayoutManager;
    protected LayoutManagerType mCurrentLayoutManagerType;

    private enum LayoutManagerType {
        GRID_LAYOUT_MANAGER
    }


    public Recommended() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recommended, container, false);
        view.setTag(TAG);

        recyclerView = (RecyclerView) view.findViewById(R.id.mRecommendedRecycler);

        mLayoutManager = new GridLayoutManager(getActivity(), GRID_COLUMNS);
        mCurrentLayoutManagerType = LayoutManagerType.GRID_LAYOUT_MANAGER;

        if (savedInstanceState != null) {
            mCurrentLayoutManagerType = (LayoutManagerType) savedInstanceState.getSerializable(KEY_LAYOUT_MANAGER);
        }
        setRecyclerViewLayoutManager(mCurrentLayoutManagerType);

        ArrayList<CateringServices> cateringlist = addData();
        mAdapter = new AllServicesAdapter(cateringlist);
        recyclerView.setAdapter(mAdapter);


        return view;
    }


    public void setRecyclerViewLayoutManager(LayoutManagerType layoutManagerType) {
        int scrollPosition = 0;

        // If a layout manager has already been set, get current scroll position.
        if (recyclerView.getLayoutManager() != null) {
            scrollPosition = ((GridLayoutManager) recyclerView.getLayoutManager())
                    .findFirstCompletelyVisibleItemPosition();
        }

        switch (layoutManagerType) {
            case GRID_LAYOUT_MANAGER:
                mLayoutManager = new GridLayoutManager(getActivity(),GRID_COLUMNS);
                mCurrentLayoutManagerType = LayoutManagerType.GRID_LAYOUT_MANAGER;
                break;
        }

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.scrollToPosition(scrollPosition);
    }


    public ArrayList<CateringServices> addData(){
        //feed cards
        ArrayList<CateringServices> list= new ArrayList<>();
        for(int i=0; i<10; i++){
            for(int x=1; x<5; x++){
                CateringServices item = new CateringServices(x);
                list.add(item);
            }
        }

        return list;
    }


}
package com.example.user.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class GameResultFragment extends Fragment {


    public GameResultFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game_result, container, false);
    }
    @Override
    public void onResume()
    {
        super.onResume();
        MainFragment frag =(MainFragment)getFragmentManager().findFragmentById(R.id.fragMain);
        frag.mEdtCountSet=(EditText)getActivity().findViewById(R.id.edtCountSet);
        frag.mEdtCountPlayerWin=(EditText)getActivity().findViewById(R.id.edtCountPlayerWin);
        frag.mEdtCountComWin=(EditText)getActivity().findViewById(R.id.edtCountComWint);
        frag.mEdtCountDraw=(EditText)getActivity().findViewById(R.id.edtCountDraw);

    }

}

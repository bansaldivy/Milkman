package com.example.milkman.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.milkman.Activity.navigation;
import com.example.milkman.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReceivedFragment extends Fragment {
    Button received;

    public ReceivedFragment() {
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
        final View view = inflater.inflate(R.layout.fragment_received, container, false);
        received = view.findViewById(R.id.btn_received);

        received.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity().getApplicationContext(), navigation.class));
                getActivity().finish();
            }
        });
        return view;
    }

}

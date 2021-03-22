package com.example.ouifit;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ConnectionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ConnectionFragment extends Fragment {
     EditText txtLogin;
     EditText txtPassword;
     Button btnConnect;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstance){
       View rootView = inflater.inflate(R.layout.fragment_connection_activity,container,true);

       txtLogin =(EditText) rootView.findViewById(R.id.login);
       txtPassword = (EditText) rootView.findViewById(R.id.password);

       btnConnect = (Button) rootView.findViewById(R.id.btConnection);
       btnConnect.setOnClickListener(btnConnectListener);

        return rootView;
    }
    private View.OnClickListener btnConnectListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            //TODO redirection vers MainActivity
/*
            Intent i = new Intent(ConnectionFragment.this, MainActivity.class);
            startActivity(i);
*/
        }
    };



































/*
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ConnectionActivity() {
        // Required empty public constructor
    }*/

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ConnectionActivity.
     **/
    /*s
    // TODO: Rename and change types and number of parameters
    public static ConnectionActivity newInstance(String param1, String param2) {
        ConnectionActivity fragment = new ConnectionActivity();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_connection_activity, container, false);
    }*/
}
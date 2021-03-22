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
 * Use the {@link ConnectionFragment#//newInstance} factory method to
 * create an instance of this fragment.
 */
public class ConnectionFragment extends Fragment {
    private EditText Login;
    private EditText Password;
    private Button btnConnect;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstance) {
        View rootView = inflater.inflate(R.layout.fragment_connection_activity, container, true);

        Login = (EditText) rootView.findViewById(R.id.login);
        Password = (EditText) rootView.findViewById(R.id.password);

        btnConnect = (Button) rootView.findViewById(R.id.btConnection);
        btnConnect.setOnClickListener(btnConnectListener);

        return rootView;
    }

    private View.OnClickListener btnConnectListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

   /* @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btnConnect) {
            //on récupère tout les champs
            String LoginText = login.getText().toString();
            String passwordText = email.getText().toString();

            //on vérifie si le MDP1 est le même que le MDP2
            boolean concordance = MDP1Text.equals(MDP2Text);
            //création d'un nouveau sportif
            if (concordance) {
                try {
                    identifiant++;
                    //ajout d'un nouvel utilisateur à la BDD
                    BDD.openE();
                    BDD.maBDD.execSQL("Insert Into " + BDD.TABLE_NAME + "( " + BDD.IDENTIFIANT + ", " + BDD.NOM_PERSONNE + ", " + BDD.EMAIL + ", " + BDD.PASSWORD + ") " +
                            "VALUES ( '" + identifiant + "', '" + nomText + "', '" + emailText + "', '" + MDP1Text + "');");

                    //remise à zéro des champs du formulaire
                    nom.setText(null);
                    email.setText(null);
                    mdp1.setText(null);
                    mdp2.setText(null);
                    //renvoies à la page d'acceuil connecté
                    Intent i = new Intent(InscriptionActivity.this, MainConnectActivity.class);
                    startActivity(i);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            Intent i = new Intent(ConnectionFragment.this, MainActivity.class);
            startActivity(i);

        }
    }*/

}



































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

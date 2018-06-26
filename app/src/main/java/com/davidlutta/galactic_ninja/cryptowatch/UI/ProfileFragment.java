package com.davidlutta.galactic_ninja.cryptowatch.UI;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.davidlutta.galactic_ninja.cryptowatch.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {
    @Bind(R.id.logOutButton) Button mLogOutButton;
    @Bind(R.id.nameTextView)
    TextView mUserName;
    @Bind(R.id.EmailTextView) TextView mUserEmail;

    public static ProfileFragment newInstance(){
        ProfileFragment fragment = new ProfileFragment();
        return fragment;
    }
    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root=inflater.inflate(R.layout.fragment_profile, container, false);
        ButterKnife.bind(this,root);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            String name = user.getDisplayName();
            String email = user.getEmail();
            mUserName.setText(name);
            mUserEmail.setText(email);
        }
        return root;
    }

//    @Override
//    public void onClick(View view){
//        switch (view.getId()){
//            case R.id.logOutButton:
//                logOut();
//                break;
//        }
//    }
//

    @OnClick(R.id.logOutButton) void logOut(){
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(getActivity(), Login_Activity.class);
        startActivity(intent);
    }



}

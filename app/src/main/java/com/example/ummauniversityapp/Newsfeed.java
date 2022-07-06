package com.example.ummauniversityapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Newsfeed#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Newsfeed extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Newsfeed() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Newsfeed.
     */
    // TODO: Rename and change types and number of parameters
    public static Newsfeed newInstance(String param1, String param2) {
        Newsfeed fragment = new Newsfeed();
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



    private DatabaseReference databaseReference;
    private FirebaseDatabase firebaseDatabase;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_newsfeed, container, false);


        ListView listView = v.findViewById(R.id.feeds);
        ArrayList<News> feeds = new ArrayList<News>();


        firebaseDatabase = FirebaseDatabase.getInstance();

        databaseReference = firebaseDatabase.getReference("feeds");


//        databaseReference.child("1234").setValue(new News("Umma University ","Faisal","6/29/2022","https://firebasestorage.googleapis.com/v0/b/ummaapp-144be.appspot.com/o/ummaUniversity.jpg?alt=media&token=73ecd713-4f31-4f47-82f4-7b7088b4b9e1"));

        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                feeds.clear();

                for(DataSnapshot snapshot1 : snapshot.getChildren()){

                    News news = snapshot1.getValue(News.class);
                    feeds.add(news);

                }



//                feeds.add(new News("Fee Compensation - Part 1","Vc office","10/20/2022","https://images.pexels.com/photos/2582937/pexels-photo-2582937.jpeg?auto=compress&cs=tinysrgb&w=300"));
//                feeds.add(new News("Fee Compensation - Part 2","Vc office","10/20/2022","https://images.pexels.com/photos/2582937/pexels-photo-2582937.jpeg?auto=compress&cs=tinysrgb&w=300"));

                if(getContext() != null){
                    Collections.reverse(feeds);
                    CustomAdapter customAdapter = new CustomAdapter(requireContext(),R.layout.cards,feeds);
                    listView.setAdapter(customAdapter);
                    TextView t = v.findViewById(R.id.connection);
                    t.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Fail to get data.", Toast.LENGTH_SHORT).show();


            }
        };

        databaseReference.addValueEventListener(valueEventListener);






        return v;
    }



}
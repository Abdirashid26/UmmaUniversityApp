package com.example.ummauniversityapp;

import static androidx.core.content.ContextCompat.getSystemService;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Images#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Images extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Images() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Images.
     */
    // TODO: Rename and change types and number of parameters
    public static Images newInstance(String param1, String param2) {
        Images fragment = new Images();
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


    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;


    NotificationManagerCompat notificationManagerCompat;
    Notification notification;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_images, container, false);


        firebaseDatabase = FirebaseDatabase.getInstance();

        databaseReference = firebaseDatabase.getReference("news");

        ListView listView = v.findViewById(R.id.news);
        ArrayList<Feed> feeds = new ArrayList<Feed>();

//        databaseReference.child("13").setValue(new Feed("Admin","10/7/2022","EXAMS DATE will begin on 25th of july and end after one week !"));



        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                feeds.clear();
                for ( DataSnapshot snapshot1: snapshot.getChildren() ){

                    Feed news1 = snapshot1.getValue(Feed.class);
                    feeds.add(news1);

                }

                if(getContext() != null){
                    Collections.reverse(feeds);
                    NewsAdapter customAdapter = new NewsAdapter(requireContext(),R.layout.newscard,feeds);
                    listView.setAdapter(customAdapter);
                    TextView t = v.findViewById(R.id.connection);
                    t.setVisibility(View.INVISIBLE);
                }



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Fail to get data.", Toast.LENGTH_SHORT).show();

            }
        });


////        Building Notification
//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
//            NotificationChannel channel = new NotificationChannel("myCh","Mychannell",NotificationManager.IMPORTANCE_HIGH);
//            channel.enableLights(true);
//            channel.enableLights(true);
//            channel.enableVibration(true);
//            NotificationManager manager = getSystemService(getContext(),NotificationManager.class);
//            manager.createNotificationChannel(channel);
//        }
//
//        Feed f = snapshot.getValue(Feed.class);
//
//        Toast.makeText(getContext(), f.getTitle(), Toast.LENGTH_SHORT).show();
//
//        NotificationCompat.Builder builder = new NotificationCompat.Builder(getContext(),"myCh");
//
//        builder.setSmallIcon(R.drawable.ic_baseline_feed_24).setContentTitle("Umma NewsFeed");
//        builder.setContentText(f.getTitle());
//        builder.setPriority(NotificationCompat.PRIORITY_HIGH);
//
//        notification = builder.build();
//        notificationManagerCompat = NotificationManagerCompat.from(getContext());
//
//        notificationManagerCompat.notify(1,notification);



        return v;

    }




}
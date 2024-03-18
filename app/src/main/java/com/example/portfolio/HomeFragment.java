package com.example.portfolio;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private LinearLayout socialising;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Initialize your views
        socialising = view.findViewById(R.id.Social_media);

        FloatingActionButton fab = view.findViewById(R.id.Social_icon);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleSocialMediaIcons();
            }
        });

        // Facebook Icon Click
        ImageView facebookIcon = view.findViewById(R.id.facebook);
        facebookIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.facebook.com/abishek.patel.18461/");

            }
        });

        // Instagram Icon Click
        ImageView instagramIcon = view.findViewById(R.id.instagram);
        instagramIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.instagram.com/abishek.patel.18461/");

            }
        });

        // LinkedIn Icon Click
        ImageView linkedinIcon = view.findViewById(R.id.linkedin);
        linkedinIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLinkedInPage(); // Implement this method to open your LinkedIn page
            }
        });

        return view;
    }
    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }

    private void toggleSocialMediaIcons() {
        if (socialising.getVisibility() == View.VISIBLE) {
            socialising.setVisibility(View.GONE);
        } else {
            socialising.setVisibility(View.VISIBLE);
        }
    }



    private void openLinkedInPage() {
        // Add code to open your LinkedIn page
        String linkedinPageUrl = "https://www.linkedin.com/in/abishek-patel-44888625b";

        try {
            // Try to open the Facebook app
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("Lin://link/linked?href=" + linkedinPageUrl));
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            // If the Facebook app is not installed, open in a web browser
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(linkedinPageUrl));
            startActivity(intent);
        }
    }


}

package com.example.portfolio;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Button button;
    private ImageView imageView;

    public ProfileFragment() {

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
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

        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        button = view.findViewById(R.id.btncamera);
        imageView = view.findViewById(R.id.imageprofile);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle button click event here
                Intent open_camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(open_camera, 100);
            }
        });

        AppCompatButton button3 = view.findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String phoneNumber = getString(R.string.number);
                dialPhoneNumber(phoneNumber);
            }
        });

        AppCompatButton button4 = view.findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // When the Gmail button is clicked, open the Gmail app or email client
                composeEmail(getString(R.string.gmail_address), getString(R.string.email_subject));
            }
        });

        AppCompatButton button5 = view.findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // When the Location button is clicked, open Google Maps with your house location
                openLocationInGoogleMaps();
            }
        });

        AppCompatButton studentButton = view.findViewById(R.id.button2);
        studentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // When the "Student" button is clicked, show options for GitHub and online certification
                showOptionsPopup(v);
            }
        });
        return view;
    }


    private void dialPhoneNumber(String phoneNumber) {
        Intent dialIntent = new Intent(Intent.ACTION_DIAL);
        dialIntent.setData(Uri.parse("tel:" + phoneNumber));
        startActivity(dialIntent);
    }

    private void composeEmail(String emailAddress, String subject) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", emailAddress, null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        startActivity(Intent.createChooser(emailIntent, "Send email..."));
    }


    private void openLocationInGoogleMaps() {
        // Replace latitude and longitude with your actual house location
        Uri gmmIntentUri = Uri.parse("geo:0,0?q=your_latitude,your_longitude(Label)");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");

        if (mapIntent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivity(mapIntent);
        } else {
            // Handle the case where Google Maps app is not installed
            // You can open the location in a web browser as an alternative
            openLocationInWebBrowser();
        }
    }

    private void openLocationInWebBrowser() {
        // Replace latitude and longitude with your actual house location
        Uri webIntentUri = Uri.parse("https://www.google.com/maps/@27.6630307,85.3451984,16z?entry=ttu");
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webIntentUri);
        startActivity(webIntent);
    }


    private void showOptionsPopup(View v) {
        PopupMenu popupMenu = new PopupMenu(getContext(), v);
        popupMenu.getMenuInflater().inflate(R.menu.student_options_menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.menu_github) {
                    // Handle GitHub option
                    openGitHub();
                    return true;
                } else if (item.getItemId() == R.id.Personal_Portfolio) {
                    // Handle online certification option
                    Personal_Portfolio();
                    return true;
                } else {
                    return false;
                }
            }
        });

        popupMenu.show();
    }

    private void openGitHub() {

        Uri githubUri = Uri.parse("https://github.com/");
        Intent githubIntent = new Intent(Intent.ACTION_VIEW, githubUri);
        startActivity(githubIntent);
    }

    private void Personal_Portfolio() {

        Uri certificationUri = Uri.parse("https://ap20000.github.io/abhishek/");
        Intent certificationIntent = new Intent(Intent.ACTION_VIEW, certificationUri);
        startActivity(certificationIntent);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap photo = (Bitmap)data.getExtras().get("data");
        imageView.setImageBitmap(photo);
    }
}
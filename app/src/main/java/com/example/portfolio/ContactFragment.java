package com.example.portfolio;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ContactFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ContactFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ContactFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ContactFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ContactFragment newInstance(String param1, String param2) {
        ContactFragment fragment = new ContactFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact, container, false);



        Button submitButton = view.findViewById(R.id.SendButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show pop-up message
                showMessage("Message was sent Sucessfull!");

                // Clear all text views
                clearTextFields();
            }
        });

        return view;
    }

    private void showMessage(String message) {
        // Use AlertDialog or Toast to show the pop-up message
        // For AlertDialog:
        new AlertDialog.Builder(requireContext())
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, null)
                .show();

    }

    private void clearTextFields() {
        // Find your text views and clear them
        // Example:
         TextView Name = requireView().findViewById(R.id.txtName);
         Name.setText("");

        TextView subject = requireView().findViewById(R.id.txtsubject);
        subject.setText("");

        TextView email = requireView().findViewById(R.id.txtemail);
        email.setText("");

        TextView Message = requireView().findViewById(R.id.txtmessage);
        Message.setText("");

    }
}
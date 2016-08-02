package com.augmentis.ayp.keep_walking;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Date;
import java.util.UUID;

public class UpdateFragment extends Fragment {
    EditText inputTitleText;
    TextView dateText;
    Button saveButton;
    private Date dateKeepWalking;
    boolean flagAdd = false;
    private KeepWalking keepWalking;


    private static final String KEEPWALKING_ID = "ID";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_update_fragment, container, false);
        inputTitleText = (EditText) v.findViewById(R.id.title_input_text);
        dateText = (TextView) v.findViewById(R.id.date_input_text);
        dateKeepWalking = new Date(); // อัพเดทเวลาปัจจุบัน
        dateText.setText(dateKeepWalking.toString());


        UUID _id = (UUID) getArguments().getSerializable(KEEPWALKING_ID);

        if (_id == null)
        {
            flagAdd = true;
        }
        else
        {
            keepWalking = KeepWalkingLab.getInstance(getActivity()).getKeepWalkingById(_id);
            inputTitleText.setText(keepWalking.getTitle());
        }

        saveButton = (Button) v.findViewById(R.id.save_input_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flagAdd == true)
                {
                    KeepWalking keepwalking = new KeepWalking();
                    keepwalking.setTitle(inputTitleText.getText().toString());
                    keepwalking.setKeepWalkingDate(dateKeepWalking);
                    KeepWalkingLab keepWalkingLab = KeepWalkingLab.getInstance(getActivity());       //สร้าง object ใหม่ เพื่อใช้ ArrayList
                    keepWalkingLab.getKeepWalkingList().add(keepwalking);
                }
                else
                {
                    keepWalking.setTitle(inputTitleText.getText().toString());
                    keepWalking.setKeepWalkingDate(dateKeepWalking);
                }

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });
        return v;
    }

}

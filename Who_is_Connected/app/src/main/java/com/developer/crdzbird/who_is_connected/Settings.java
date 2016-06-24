package com.developer.crdzbird.who_is_connected;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Settings extends AppCompatActivity {


    private RadioGroup choose254Mode;
    private RadioButton fast;
    private RadioButton slow;
    private int modeId;
    private Context context = this;

    private Button btnSaveMode;
    private Button btnInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


        btnSaveMode = (Button) findViewById(R.id.settings_save254mode_button);
        choose254Mode = (RadioGroup) findViewById(R.id.settings_choose254mode);
        fast = (RadioButton) findViewById(R.id.settings_254fast_mode);
        slow = (RadioButton) findViewById(R.id.settings_254slow_mode);
        btnInfo = (Button) findViewById(R.id.settings_infobtn);


        SavedData data = new SavedData();

            if (data.load254Mode(this) == 1) {
                choose254Mode.check(R.id.settings_254fast_mode);
                modeId = 1;
            } else if (data.load254Mode(this) == 2) {
                choose254Mode.check(R.id.settings_254slow_mode);
                modeId = 2;
            }


        choose254Mode.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (fast.isChecked()) {
                    modeId = 1;
                } else {
                    modeId = 2;
                }


            }
        });




        btnSaveMode.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                SavedData data = new SavedData();
                data.save254Mode(context, modeId);
                Toast toast = Toast.makeText(getApplicationContext(),
                        "saved!", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        btnInfo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(Settings.this, Information.class);
                startActivity(intent);

            }
        });



    }
}

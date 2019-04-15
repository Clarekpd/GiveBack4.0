package com.example.giveback;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class LoginActivity extends Activity {

    private RadioGroup radioGroupUser;
    private RadioButton selectedOption;
    private EditText inputUsername, inputPassword;
    private Button loginAuthentication;

    //compared to user typed username and password to authenticate
    private String correctUsernameDonor = "usernamedonor";
    private String correctPasswordDonor = "passworddonor";
    private String correctUsernameOrg = "usernameorg";
    private String correctPasswordOrg = "passwordorg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        radioGroupUser = (RadioGroup) findViewById(R.id.radio_group_user);

        inputUsername = (EditText) findViewById(R.id.input_username);
        inputPassword = (EditText) findViewById(R.id.input_password);

        loginAuthentication = (Button) findViewById(R.id.login_authentication);

        loginAuthentication.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                //get selected radiobutton from radioGroupUser
                int selectedId = radioGroupUser.getCheckedRadioButtonId();
                //assigns selected radiobutton's id to radiobutton selectedOption
                selectedOption = (RadioButton) findViewById(selectedId);


                //check if selected radioButton, username, and password are all authentic
                if(selectedOption.getText().toString().equals("donor") &&
                        inputUsername.toString().equals(correctUsernameDonor) &&
                        inputPassword.toString().equals(correctPasswordDonor)) {
                    Toast.makeText(getApplicationContext(), "Redirecting...", Toast.LENGTH_SHORT).show();


                }else if(selectedOption.getText().toString().equals("organization") &&
                        inputUsername.toString().equals(correctUsernameOrg) &&
                        inputPassword.toString().equals(correctPasswordOrg)) {
                    Toast.makeText(getApplicationContext(), "Redirecting...", Toast.LENGTH_SHORT).show();
                    setContentView(R.layout.activity_main);


                }else{
                    Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();
                }



            }

        });
    }

}

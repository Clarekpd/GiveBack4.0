package com.example.giveback;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.v7.app.AppCompatActivity;

import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroupUser;
    private RadioButton selectedOption;
    private EditText inputUsername, inputPassword;
    private Button loginAuthentication;

    //compared to user typed username and password to
    private static final String correctUsernameDonor = "du";
    private String correctPasswordDonor = "dp";
    private String correctUsernameOrg = "ou";
    private String correctPasswordOrg = "op";

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
                if(selectedOption.getText().toString().equals("Donor") &&
                        inputUsername.getText().toString().equals(correctUsernameDonor) &&
                        inputPassword.getText().toString().equals(correctPasswordDonor)) {

                    Toast.makeText(getApplicationContext(), "Redirecting...", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, AfterLogin.class);
                    startActivity(intent);


                }else if(selectedOption.getText().toString().equals("Organization") &&
                        inputUsername.getText().toString().equals(correctUsernameOrg) &&
                        inputPassword.getText().toString().equals(correctPasswordOrg)) {

                    Toast.makeText(getApplicationContext(), "Redirecting...", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, AfterLogin.class);
                    startActivity(intent);

                }else{
                    Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();
                }

            }

        });
    }

}
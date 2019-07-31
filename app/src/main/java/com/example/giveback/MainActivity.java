package com.example.giveback;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroupUser;
    private RadioButton selectedOption;
    private EditText inputUsername, inputPassword;
    private Button loginAuthentication;

    //compared to user typed donorUsername and donorPassword to
//    private static final String correctUsernameDonor = "du";
//    private String correctPasswordDonor = "dp";
    public String correctUsernameDonor = "du";
    public String correctPasswordDonor = "dp";
    private String correctUsernameOrg = "ou";
    private String correctPasswordOrg = "op";

    private boolean userIsDonor;

    Bundle bundle = new Bundle();


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("donors").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {

            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        Donor donor = (Donor) document.toObject(Donor.class);
                        //Toast.makeText(getApplicationContext(),donor.donorUsername + " " + donor.donorPassword, Toast.LENGTH_LONG).show();
                        correctUsernameDonor = donor.donorUsername;
                        correctPasswordDonor = donor.donorPassword;
                    }
                } else {
                    Toast.makeText(getApplicationContext(),"Error getting credentials",Toast.LENGTH_LONG).show();
                }
            }

        });

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        radioGroupUser = findViewById(R.id.radio_group_user);

        inputUsername = findViewById(R.id.input_username);
        inputPassword = findViewById(R.id.input_password);

        loginAuthentication = findViewById(R.id.login_authentication);

        loginAuthentication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get selected radiobutton from radioGroupUser
                int selectedId = radioGroupUser.getCheckedRadioButtonId();
                //assigns selected radiobutton's id to radiobutton selectedOption
                selectedOption = findViewById(selectedId);

                //check if selected radioButton, donorUsername, and donorPassword are all authentic
                if (selectedOption.getText().toString().equals("Donor") &&
                        inputUsername.getText().toString().equals(correctUsernameDonor) &&
                        inputPassword.getText().toString().equals(correctPasswordDonor)) {

                    userIsDonor = true;

                    Toast.makeText(getApplicationContext(), "Redirecting...", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, AfterLogin.class);
                    bundle.putBoolean("userType", userIsDonor);
                    intent.putExtras(bundle);
                    startActivity(intent);


                } else if (selectedOption.getText().toString().equals("Organization") &&
                        inputUsername.getText().toString().equals(correctUsernameOrg) &&
                        inputPassword.getText().toString().equals(correctPasswordOrg)) {

                    userIsDonor = false;

                    Toast.makeText(getApplicationContext(), "Redirecting...", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, AfterLogin.class);
                    bundle.putBoolean("userType", userIsDonor);
                    intent.putExtras(bundle);
                    startActivity(intent);


                } else {
                    Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();
                }

            }

        });

    }
}

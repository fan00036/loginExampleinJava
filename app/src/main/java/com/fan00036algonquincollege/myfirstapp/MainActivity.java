package com.fan00036algonquincollege.myfirstapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginButton =(Button) findViewById(R.id.login);
        Button forgotPasswordButton=(Button) findViewById(R.id.forgotpassword);

        forgotPasswordButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(getApplicationContext(),"forgotPasswordButton :: onClick()", Toast.LENGTH_SHORT).show();

            }
        } );

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "loginButton :: onClick()", Toast.LENGTH_SHORT).show();


                //userEmail<TextView>
                TextView userEmailText = (TextView) findViewById(R.id.userEmail);
                String userEmail = userEmailText.getText().toString();

                //validate userEmail


                if(userEmail.isEmpty()) {
                    userEmailText.setError("Enter your username");
                    userEmailText.requestFocus();
                    Toast.makeText(getApplicationContext(),"username cannot be empty,enter your username", Toast.LENGTH_LONG).show();

                }
                else if(userEmail.length()!=8){
                    userEmailText.setError("invalid username");
                    userEmailText.requestFocus();
                    Toast.makeText(getApplicationContext(),userEmail + "(invalid; username must be 8 characters)", Toast.LENGTH_LONG).show();

                }
                else if(Character.isUpperCase(userEmail.charAt(0)) ||  Character.isUpperCase(userEmail.charAt(1))){
                    userEmailText.setError("invalid username");
                    userEmailText.requestFocus();
                    Toast.makeText(getApplicationContext(),userEmail + "(invalid; first 2 characters of username must be are lower-case alphabetical characters)", Toast.LENGTH_LONG).show();
                    return;
                }

                Pattern inputP = Pattern.compile("[^a-zA-Z0-9]");
                boolean special = inputP.matcher(userEmail).find();
                if(special){
                    userEmailText.setError("invalid username");
                    userEmailText.requestFocus();
                    Toast.makeText(getApplicationContext(),"(invalid; username cannot be with any special characters)", Toast.LENGTH_LONG).show();
                    return;
                }


                //password<textView>
                TextView passwordText =(TextView) findViewById(R.id.password);
                String password = passwordText.getText().toString();

                //validate password
                if(password.isEmpty()){
                    passwordText.setError("Enter your password");
                    passwordText.requestFocus();
                    Toast.makeText(getApplicationContext(),"password cannot be empty,enter your password", Toast.LENGTH_LONG).show();

                }
                else if(password.length()<5){
                    passwordText.setError("invalid password");
                    passwordText.requestFocus();
                    Toast.makeText(getApplicationContext(),userEmail + "(invalid; password must be greater than 4 characters)", Toast.LENGTH_LONG).show();
                    return;
                }


                CheckBox rememberMe = (CheckBox)findViewById(R.id.rememberme);
                Boolean rememberMeChecked = rememberMe.isChecked();


                 //success
                Toast.makeText(getApplicationContext(), "userEmail: " + userEmail, Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(),"Password: " + password, Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(),"rememberMe is: " + rememberMeChecked,Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

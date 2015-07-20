package wsu.csc5991.socially;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActLogin extends Activity 
{		
		Button btnSignup, btnLogin;
		EditText etName, etPassword;
		String name, password;
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
		setContentView(R.layout.laylogin);
		
		etName = (EditText) findViewById(R.id.etName);
		etPassword = (EditText) findViewById(R.id.etPassword);
		
		btnLogin = (Button) findViewById(R.id.btnLogin);
		btnLogin.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
				SharedPreferences prefs = getPreferences(MODE_PRIVATE);
				name =  (etName.getText().toString());
				password =  (etPassword.getText().toString());
				String verify_name = prefs.getString("Username", null);
				String verify_password = prefs.getString("Password", null);		
				System.out.println("Name Verify: " +
 					 verify_name);
				System.out.println("Password Verify: " +
 						verify_password);
				if(verify_name == name && verify_password == password)
				{
					CharSequence check = "Log in successful";
					Toast toast = Toast.makeText(getApplicationContext(), check, Toast.LENGTH_LONG);
					toast.show();
					//TODO login menu
					
				}
				else
				{
					// failed log in
					CharSequence error = "Username or Password is incorrect.";
					Toast toast = Toast.makeText(getApplicationContext(), error, Toast.LENGTH_LONG);
					toast.show();
				}
			}
		});
		
		btnSignup = (Button) findViewById(R.id.btnSignup);
        // signup button pressed
        btnSignup.setOnClickListener(new View.OnClickListener()
        {
        	@Override
        	public void onClick(View v)
        	{
        		System.out.println("Signup button clicked");
        		Intent launchactivity= new Intent(ActLogin.this,ActSignup.class);                               
        		startActivity(launchactivity);
        	}
        });	   
	    
	    }
	    
	    //----------------------------------------------------------------
	    // onStart
	    //----------------------------------------------------------------
		@Override
		protected void onStart()
		{
			super.onStart();
		}

	    //----------------------------------------------------------------
	    // onResume
	    //----------------------------------------------------------------
		@Override
		protected void onResume()
		{
			super.onResume();
		}

	    //----------------------------------------------------------------
	    // onPause
	    //----------------------------------------------------------------
		@Override
		protected void onPause()
		{
			super.onPause();
		}

	    //----------------------------------------------------------------
	    // onStop
	    //----------------------------------------------------------------
		@Override
		protected void onStop()
		{
			super.onStop();
		}

		//----------------------------------------------------------------
	    // onRestart
	    //----------------------------------------------------------------
		@Override
		protected void onRestart()
		{
			super.onRestart();
		}

	    //----------------------------------------------------------------
	    // onDestroy
	    //----------------------------------------------------------------
		@Override
		protected void onDestroy() 
		{
			super.onDestroy();
		}


}

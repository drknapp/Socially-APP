
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

import java.lang.String;





//Import Java packages
import java.text.DecimalFormat;

//--------------------------------------------------------------
//class ActOption2
// TODO set manifest file lock orientation : vertical for SignUpAct
//--------------------------------------------------------------
public class ActSignup extends Activity 
{

    //----------------------------------------------------------------
    // Constants
    //----------------------------------------------------------------

	// Declare application constants
	private static final String APP_NAME = "Socially";
	private static final String APP_VERSION = "1.0";

    // Declare format constants
    private static final DecimalFormat FORMAT_TIME_SEGMENT =
    		new DecimalFormat("00");
    private static final DecimalFormat FORMAT_YEAR_SEGMENT = 
    		new DecimalFormat("0000");

    //----------------------------------------------------------------
    // Variables
    //----------------------------------------------------------------

    // Declare variables
    // ...
    Spinner spMonth;
    Spinner spDay;
    Spinner spYear;
    ImageView iv1;
    Button btn1;
    int day, year;
    String name, password, confirm;
    String  month, year2, day2;
    EditText etName, etPassword, etPassConf;
    boolean check = true;

    //----------------------------------------------------------------
    // Activity overrides
    //----------------------------------------------------------------

    //----------------------------------------------------------------
    // onCreate
    //----------------------------------------------------------------
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.laysignup);
				
		//edit text variables
		etName = (EditText) findViewById(R.id.etName);
		etPassword = (EditText) findViewById(R.id.etPassword);
		etPassConf = (EditText) findViewById(R.id.etPassConf);
		
		// Define spinner adapter
		// Month Spinner
    	String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    	ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, 
				android.R.layout.simple_spinner_item, months);
		adapter.setDropDownViewResource(
				android.R.layout.simple_spinner_dropdown_item);
		
		// Define spinner control
		spMonth = (Spinner) findViewById(R.id.spMonth);
		spMonth.setAdapter(adapter);
		
		// Define spinner event
		spMonth.setOnItemSelectedListener(new OnItemSelectedListener()
		{
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) 
            {
				((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
		    	System.out.println("Spinner: \"" + 
		    			parent.getItemAtPosition(position) + 
		    			"\" selected.");
		    	// assign the month
		    	month = (String) parent.getItemAtPosition(position);
            }
            @Override
			public void onNothingSelected(AdapterView<?> parent)
            {
            	System.out.println("Spinner: no item selected.");
            }
        });
		
		// Define spinner adapter
		// Day spinner
		String[] days = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, 
		android.R.layout.simple_spinner_item, days);
		adapter2.setDropDownViewResource(
				android.R.layout.simple_spinner_dropdown_item);
			
		// Define spinner control
		spMonth = (Spinner) findViewById(R.id.spDay);
		spMonth.setAdapter(adapter2);
			
		// Define spinner event
		spMonth.setOnItemSelectedListener(new OnItemSelectedListener()
		{
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) 
		      {
				((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
		    	System.out.println("Spinner: \"" + 
		    			parent.getItemAtPosition(position) + 
		    			"\" selected.");
		    	// assign the day
		    	day2 = (String) parent.getItemAtPosition(position);
		    	day = Integer.valueOf(day2);
		      }
		     @Override
			public void onNothingSelected(AdapterView<?> parent)
		       {
		          	System.out.println("Spinner: no item selected.");
		       }
	     });		
	
	
	// Define spinner adapter
	// Day spinner
	String[] years = {"1900","1901","1902","1903","1904","1905","1906","1907","1908","1909","1910","1911","1912","1913","1914","1915","1916","1917","1918","1919","1920","1921","1922","1923","1924","1925","1926","1927","1928","1929","1930","1931","1932","1933","1934","1935","1936","1937","1938","1939","1940","1941","1942","1943","1944","1945","1946","1947","1948","1949","1950","1951","1952","1953","1954","1955","1956","1957","1958","1959","1960","1961","1962","1963","1964","1965","1966","1967","1968","1969","1970","1971","1972","1973","1974","1975","1976","1977","1978","1979","1980","1981","1982","1983","1984","1985","1986","1987","1988","1989","1990","1991","1992","1993","1994","1995","1996","1997","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015"};
	ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, 
	android.R.layout.simple_spinner_item, years);
	adapter3.setDropDownViewResource(
			android.R.layout.simple_spinner_dropdown_item);
	// Define spinner control
	spYear = (Spinner) findViewById(R.id.spYear);
	spYear.setAdapter(adapter3);
		
	// Define spinner event
	spYear.setOnItemSelectedListener(new OnItemSelectedListener()
		{
		@Override
		public void onItemSelected(AdapterView<?> parent, View view, int position, long id) 
	      {
			((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);  //change color of spinner text before click
	    	System.out.println("Spinner: \"" + 
	    			parent.getItemAtPosition(position) + 
	    			"\" selected.");
	    	// assign the year
	    	year2 = (String) parent.getItemAtPosition(position);
	    	year = Integer.valueOf(year2);
	       }
	     @Override
		public void onNothingSelected(AdapterView<?> parent)
	       {
	          	System.out.println("Spinner: no item selected.");
	       }
		});	
	
	
		//  onclick method, Dialog for saving info
	
	
		btn1 = (Button) findViewById(R.id.btn1);
		btn1.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View v)
			{
				
				
				// save credentials with shared preferences ### no access to server
						final SharedPreferences.Editor editor = getPreferences(MODE_PRIVATE).edit();
						//string variables for data
						name =  (etName.getText().toString());
						password =  (etPassword.getText().toString());
						confirm =  (etPassConf.getText().toString());
						System.out.println(name + " --> Name");
						System.out.println(password + " --> password");
						System.out.println(confirm + " --> confirm");
						//Check if passwords match
						if (etPassword.getText().toString().equals(etPassConf.getText().toString()) && password != "")
								check = true;
						else
						{
							CharSequence error = "Passwords don't match.";
							Toast toast = Toast.makeText(getApplicationContext(), error, Toast.LENGTH_LONG);
							toast.show();
							check = false;
						}
						
						// check if name and password were given. 
						// year/day/month are assigned to default
		 	    		AlertDialog.Builder builder = 
		 	    				new AlertDialog.Builder(v.getContext());
		 	    		builder.setTitle("Sign up Confirmation");
		 	    		builder.setMessage("Would you like to Save your Information?");
		 	    		// if yes; save
		 	    		builder.setPositiveButton("Yes", 
		 	    				new DialogInterface.OnClickListener()
		 	    		{
		 	    			public void onClick(DialogInterface dialog, int option)
		 	    			{
		 	    				System.out.println("Save dialog box: " +
		 	    						"\"Yes\" button pressed.");
		 	    				// save information with shared preferences
		 	    				System.out.println(etName + " edittextname");
		 	    				editor.putString("Username", name);
		 	    				editor.putString("Password", password);
		 	    				editor.putString("Month", month);
		 	    				editor.putInt("day", day);
		 	    				editor.putInt("Year", year);    		
		 	    				editor.apply();
		 	    				change();
		 	    			
		 	    			}
		 	    		});
		 	    		//if no, don't save
		 	    		builder.setNegativeButton("No", 
		 	    				new DialogInterface.OnClickListener()
		 	    		{
		 	    			public void onClick(DialogInterface dialog, int option)
		 	    			{
		 	    				System.out.println("Save dialog box: " +
		 	    						"\"No\" button pressed.");
		 	    			}
		 	    		});
		 	    		//if passwords match show dialog
		 	    		if (check == true)
		 	    			builder.show();
		 	    		
		 	    		
			}
			
		});
		
	}
	
	public void change()
	{
		//testing remove setContentView
		Intent launchactivity= new Intent(MainActivity.this,ActLogin.class);                               
		startActivity(launchactivity);
	
		setContentView(R.layout.laylogin);
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
    
    //----------------------------------------------------------------
    // General utilities
    //----------------------------------------------------------------


}

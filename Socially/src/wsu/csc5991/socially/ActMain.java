package wsu.csc5991.socially;

//Import Android packages
import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Handler;
import android.os.Message;
import android.graphics.drawable.Drawable;

//Import Java packages
import java.text.DecimalFormat;
import java.util.Timer;

public class ActMain extends Activity {
	
	//----------------------------------------------------------------
    // Variables
    //----------------------------------------------------------------
    // Declare control variables
    private View layBack;
    private Toast toast;
    
    // Variables to retrieve information 
    static Location loc0 = new Location("");
    private static Drawable image0;
    private static String name0;
    private double distancex0;
    private double distancey0;
    
    static Location loc1 = new Location("");
    private static Drawable image1;
    private static String name1;
    private double distancex1;
    private double distancey1;
    
    // Variables per container
    private static LinearLayout container0;
    private static ImageView ivImage0;
    private static TextView tvName0;
    private static TextView tvDistance0;
    private static Button btnMeet0;
    
    private static LinearLayout container1;
    private static ImageView ivImage1;
    private static TextView tvName1;
    private static TextView tvDistance1;
    private static Button btnMeet1;

    // Declare location variables
    //private static Location currentLocation = null;  // Set from GPS sensor
    
    // Declare distance variables
    static float dM0 = 100000;
    static float dM1 = 100000;
    private Timer timer;
    
    //----------------------------------------------------------------
    // onCreateOptionsMenu
    //----------------------------------------------------------------
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.layout.laymenu, menu);
        return true;
    }
    
    //----------------------------------------------------------------
    // onOptionsItemSelected
    // Menu hierarchy
    //   Help
    //   About
    //   Settings
    //----------------------------------------------------------------
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
    	int itemId = item.getItemId();
		if (itemId == R.id.itmHelp) {
			Intent intHelp = new Intent(this, ActHelp.class);
			startActivity(intHelp);
			return true;
		} else if (itemId == R.id.itmAbout) {
			Intent intAbout = new Intent(this, ActAbout.class);
			startActivity(intAbout);
			return true;
		} else if (itemId == R.id.itmSettings) {
			Intent intSettings = new Intent(this, ActSettings.class);
			startActivity(intSettings);
			return true;
		} else {
			return super.onOptionsItemSelected(item);
		}

    }

    //----------------------------------------------------------------
    // onCreate
    //----------------------------------------------------------------
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.laymain);
		
		//Adjust shadow from under that action bar
		getActionBar().setElevation(0);
		
		//Define control for background color change
		layBack = (View) findViewById(R.id.layBack);
		//-----------------------------------------------------------
		//Initialize background color based on stored values
		//-----------------------------------------------------------
		if (Boolean.valueOf(shared.Data.backValue)){
			layBack.setBackgroundColor(Color.parseColor("#FFFFFF"));
		}
		else if (!Boolean.valueOf(shared.Data.backValue)){
			layBack.setBackgroundColor(Color.parseColor("#303030"));;
		}
		
		//----------------------------------------------------------------
	    // Retrieve information
	    //----------------------------------------------------------------
		name0 = "Detroit City";
		distancex0 = 42.3354205;
		distancey0 = -83.1835290;
		image0 = getDrawable(R.drawable.pic2);
		name1 = "Wayne State";
		distancex1 = 42.3357003;
		distancey1 = -83.1810000;
		image1 = getDrawable(R.drawable.pic1);
		
		//Define container 1 controls
		container0 = (LinearLayout) findViewById(R.id.container0);
		ivImage0 = (ImageView) findViewById(R.id.ivImage0);
		tvName0 = (TextView) findViewById(R.id.tvName0);
		tvDistance0 = (TextView) findViewById(R.id.tvDistance0);
		btnMeet0 = (Button) findViewById(R.id.btnMeet0);
		
		//Define container 2 controls
		container1 = (LinearLayout) findViewById(R.id.container1);
		ivImage1 = (ImageView) findViewById(R.id.ivImage1);
		tvName1 = (TextView) findViewById(R.id.tvName1);
		tvDistance1 = (TextView) findViewById(R.id.tvDistance1);
		btnMeet1 = (Button) findViewById(R.id.btnMeet1);		
        
		
		// Calculate locations after getting user's gps coordinates
		loc0.setLatitude(distancex0);
		loc0.setLongitude(distancey0);
		
		loc1.setLatitude(distancex1);
		loc1.setLongitude(distancey1);
		
		if (shared.currentLocation == null){
			startGPS();
		}
		
		//start autotask
        if (timer != null) timer.cancel();
        timer = new Timer();
	    timer.schedule(new AutoTask(), 0, (1000)); //1000 = 1 sec
	}
	
	//----------------------------------------------------------------
    // onResume
    //----------------------------------------------------------------
	@Override
	protected void onResume()
	{
		super.onResume();
		
		if (Boolean.valueOf(shared.Data.backValue)){
			layBack.setBackgroundColor(Color.parseColor("#FFFFFF"));
		}
		else if (!Boolean.valueOf(shared.Data.backValue)){
			layBack.setBackgroundColor(Color.parseColor("#303030"));;
		}
	}
	
	//----------------------------------------------------------------
    // onBackPressed
    //----------------------------------------------------------------
	@Override
	public void onBackPressed(){
	}
	
	//----------------------------------------------------------------
	// Start GPS tracking
	//----------------------------------------------------------------
	public void startGPS(){
		// Acquire a reference to the system Location Manager
		LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
		// Define a listener that responds to location updates
		LocationListener locationListener = new LocationListener() {
		    public void onLocationChanged(Location location) {
		      // Called when a new location is found by the network location provider.
		    	shared.currentLocation = location;
		    }
		    public void onStatusChanged(String provider, int status, Bundle extras) {}

		    public void onProviderEnabled(String provider) {}

		    public void onProviderDisabled(String provider) {
		    }
		  };

		// Register the listener with the Location Manager to receive location updates from both the GPS and Network, in case one isn't available
		locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 500, 2f, locationListener);
		locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 500, 2f, locationListener);
	}
	
	//----------------------------------------------------------------
    // What to do when each of the "meet" buttons is clicked
    //----------------------------------------------------------------
	//----------------------------------------------------------------
    // onMeet0Clicked
    //----------------------------------------------------------------
    public void onMeet0Clicked(View view)
    {                
        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext(), AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);
        
		builder.setTitle("Confirmation");
		builder.setMessage("Send request to " + tvName0.getText() + "?");
		builder.setPositiveButton("Send", 
				new DialogInterface.OnClickListener()
		{
			public void onClick(DialogInterface dialog, int option)
			{
				toast = Toast.makeText(getApplicationContext(),"Request sent to " + tvName0.getText(), Toast.LENGTH_SHORT);
	    		toast.show();
			}
		});
		builder.setNegativeButton("Cancel", 
				new DialogInterface.OnClickListener()
		{
			public void onClick(DialogInterface dialog, int option)
			{
				toast = Toast.makeText(getApplicationContext(),"Request canceled", Toast.LENGTH_SHORT);
	    		toast.show();
			}
		});
		builder.setIcon(R.drawable.ic_launcher);
		builder.show();
    }
    
  //----------------------------------------------------------------
    // onMeet1Clicked
    //----------------------------------------------------------------
    public void onMeet1Clicked(View view)
    {                
        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext(), AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);
        
		builder.setTitle("Confirmation");
		builder.setMessage("Send request to " + tvName1.getText() + "?");
		builder.setPositiveButton("Send", 
				new DialogInterface.OnClickListener()
		{
			public void onClick(DialogInterface dialog, int option)
			{
				toast = Toast.makeText(getApplicationContext(),"Request sent to " + tvName1.getText(), Toast.LENGTH_SHORT);
	    		toast.show();
			}
		});
		builder.setNegativeButton("Cancel", 
				new DialogInterface.OnClickListener()
		{
			public void onClick(DialogInterface dialog, int option)
			{
				toast = Toast.makeText(getApplicationContext(),"Request canceled", Toast.LENGTH_SHORT);
	    		toast.show();
			}
		});
		builder.setIcon(R.drawable.ic_launcher);
		builder.show();
    }
    
    //----------------------------------------------------------------
    // updateControlsHandler
    //----------------------------------------------------------------
	public static Handler updateControlsHandler = new Handler()
    {

        //------------------------------------------------------------
        // handleMessage
        //------------------------------------------------------------
    	@Override
        public void handleMessage(Message msg) 
        {
    		if (shared.currentLocation != null){
    			dM0 = shared.currentLocation.distanceTo(loc0);
    			dM1 = shared.currentLocation.distanceTo(loc1);
    		}
    		
    		if (dM0 <= 300){
    			//Set container 1 controls from retrieved information
    			container0.setAlpha(1);
    			ivImage0.setBackground(image0);
    			tvName0.setText(name0);
    			if (dM0 <= 50){
    				tvDistance0.setText("1 minute away");
    			}
    			else if (dM0 > 50 && dM0 <= 100){
    				tvDistance0.setText("2 minutes away");
    			}
    			else if (dM0 > 100 && dM0 <= 150){
    				tvDistance0.setText("3 minutes away");
    			}
    			else if (dM0 > 150 && dM0 <= 200){
    				tvDistance0.setText("4 minutes away");
    			}
    			else if (dM0 > 200){
    				tvDistance0.setText("5 minutes away");
    			}
    			btnMeet0.setClickable(true);
    		}
    		
    		if (dM1 <= 300){
    			//Set container 2 controls from retrieved information
    			container1.setAlpha(1);
    			ivImage1.setBackground(image1);
    			tvName1.setText(name1);
    			if (dM1 <= 50){
    				tvDistance1.setText("1 minute away");
    			}
    			else if (dM1 > 50 && dM1 <= 100){
    				tvDistance1.setText("2 minutes away");
    			}
    			else if (dM1 > 100 && dM1 <= 150){
    				tvDistance1.setText("3 minutes away");
    			}
    			else if (dM1 > 150 && dM1 <= 200){
    				tvDistance1.setText("4 minutes away");
    			}
    			else if (dM1 > 200){
    				tvDistance1.setText("5 minutes away");
    			}
    			btnMeet1.setClickable(true);
    		}
        }

    };
}

//==============================================================
//
//  Class: Settings
//  Description:
//  	This class represents the settings activity.
//
//==============================================================
package wsu.csc5991.socially;

//Import Android packages
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

//--------------------------------------------------------------
//class ActSettings
//--------------------------------------------------------------
public class ActSettings extends Activity 
{
    //----------------------------------------------------------------
    // Variables
    //----------------------------------------------------------------
    private Switch swBack;
    private Toast toast;
    private View layBack;

    //----------------------------------------------------------------
    // onCreate
    //----------------------------------------------------------------
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.laysettings);
		
		getActionBar().setElevation(0);

		//Define controls
		swBack = (Switch) findViewById(R.id.swBack);
		layBack = (View) findViewById(R.id.layBack);
		
		swBack.setChecked(Boolean.valueOf(shared.Data.backValue));
		
		//initialize the background switch
		if (Boolean.valueOf(shared.Data.backValue)){
			layBack.setBackgroundColor(Color.parseColor("#FFFFFF"));
			swBack.setText(" Light");
		}
		else if (!Boolean.valueOf(shared.Data.backValue)){
			layBack.setBackgroundColor(Color.parseColor("#303030"));
			swBack.setText(" Dark");
		}

		//Show toast that the background changed, and change the current background color for this activity as well after saving the value
		swBack.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				toast = Toast.makeText(getApplicationContext(),"Background color changed", Toast.LENGTH_SHORT);
	    		toast.show();
	    		
	    		shared.Data.backValue = swBack.isChecked();
	    		if (Boolean.valueOf(shared.Data.backValue)){
	    			layBack.setBackgroundColor(Color.parseColor("#FFFFFF"));
	    			swBack.setText(" Light");
	    		}
	    		else if (!Boolean.valueOf(shared.Data.backValue)){
	    			layBack.setBackgroundColor(Color.parseColor("#303030"));
	    			swBack.setText(" Dark");
	    		}
			}
		});
	}

    //----------------------------------------------------------------
    // onResume
    //----------------------------------------------------------------
	@Override
	protected void onResume()
	{
		super.onResume();
		
		swBack.setChecked(Boolean.valueOf(shared.Data.backValue));
		
		if (Boolean.valueOf(shared.Data.backValue)){
			layBack.setBackgroundColor(Color.parseColor("#FFFFFF"));
			swBack.setText(" Light");
		}
		else if (!Boolean.valueOf(shared.Data.backValue)){
			layBack.setBackgroundColor(Color.parseColor("#303030"));
			swBack.setText(" Dark");
		}
	}
/*
    //----------------------------------------------------------------
    // onPause
    //----------------------------------------------------------------
	@Override
	protected void onPause()
	{
		super.onPause();
		
		shared.Data.backValue = swBack.isChecked();
	}

    //----------------------------------------------------------------
    // onStop
    //----------------------------------------------------------------
	@Override
	protected void onStop()
	{
		super.onStop();
		
		shared.Data.backValue = swBack.isChecked();
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
		
		shared.Data.backValue = swBack.isChecked();
	}*/
}

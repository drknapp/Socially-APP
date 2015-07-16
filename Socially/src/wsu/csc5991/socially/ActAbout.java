//==============================================================
//
//  Class: About
//  Description:
//  	This class represents the about activity
//
//==============================================================
package wsu.csc5991.socially;

//Import Android packages
import android.app.Activity;
import android.os.Bundle;

//--------------------------------------------------------------
//class ActAbout
//--------------------------------------------------------------
public class ActAbout extends Activity 
{    
    //----------------------------------------------------------------
    // onCreate
    //----------------------------------------------------------------
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		getActionBar().setElevation(0);
		
		if (Boolean.valueOf(shared.Data.backValue)){
			setContentView(R.layout.layabout);
		}
		else if (!Boolean.valueOf(shared.Data.backValue)){
			setContentView(R.layout.layaboutdark);
		}
	}
	
    //----------------------------------------------------------------
    // onResume
    //----------------------------------------------------------------
	@Override
	protected void onResume()
	{
		super.onResume();
		
		if (Boolean.valueOf(shared.Data.backValue)){
			setContentView(R.layout.layabout);
		}
		else if (!Boolean.valueOf(shared.Data.backValue)){
			setContentView(R.layout.layaboutdark);
		}
	}
}

//==============================================================
//
//  Class: Help
//  Description:
//  	This class represents the help activity.
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
//class ActHelp
//--------------------------------------------------------------
public class ActHelp extends Activity 
{
	//----------------------------------------------------------------
    // Variables
    //----------------------------------------------------------------
    private View layBack;
	
    //----------------------------------------------------------------
    // onCreate
    //----------------------------------------------------------------
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layhelp);
		
		getActionBar().setElevation(0);
		
		layBack = (View) findViewById(R.id.layBack);
		
		if (Boolean.valueOf(shared.Data.backValue)){
			layBack.setBackgroundColor(Color.parseColor("#FFFFFF"));
		}
		else if (!Boolean.valueOf(shared.Data.backValue)){
			layBack.setBackgroundColor(Color.parseColor("#303030"));
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
			layBack.setBackgroundColor(Color.parseColor("#FFFFFF"));
		}
		else if (!Boolean.valueOf(shared.Data.backValue)){
			layBack.setBackgroundColor(Color.parseColor("#303030"));
		}
	}
}

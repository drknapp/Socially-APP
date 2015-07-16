//==============================================================
//
//  Class: Launch Screen
//  Description:
//  	This class represents the launch activity. The user
//will be greeted with this screen upon launching the app.
//==============================================================
package wsu.csc5991.socially;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class ActLaunch extends Activity{
	//----------------------------------------------------------------
    // onCreate
    //----------------------------------------------------------------
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.laylaunch);
		getActionBar().setElevation(0);
	}
	
	//----------------------------------------------------------------
    // onUserInteraction
    //----------------------------------------------------------------
	@Override
	public void onUserInteraction() {
		super.onUserInteraction();
		Intent intMain = new Intent(this, ActMain.class);
		startActivity(intMain);
	}
	
	//----------------------------------------------------------------
    // onStop
    //----------------------------------------------------------------
	@Override
	public void onStop() {
		super.onStop();
		finish();
	}
}

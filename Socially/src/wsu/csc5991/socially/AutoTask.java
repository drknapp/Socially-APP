//==============================================================
//
//Class: AutoTask
//Description:
//	This class tells when the main activity to update the different
//  counters.
//==============================================================
package wsu.csc5991.socially;

//Import Java packages
import java.util.TimerTask;

//--------------------------------------------------------------------
//class AutoTask
//--------------------------------------------------------------------
public class AutoTask extends TimerTask
{
  
	//--------------------------------------------------------------------
	// Constructor
	//--------------------------------------------------------------------
	public AutoTask()
	{}
	
	//--------------------------------------------------------------------
	// run
	//--------------------------------------------------------------------
	public void run()
	{
      ActMain.updateControlsHandler.sendEmptyMessage(0);
  }
}

package foregroundappgrabber;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;

public class Grabber {
	public static ForeGroundAppGrabber createForeGroundAppGrabber(ContextWrapper contextwrapper){
		return new Grabber.ForeGroundAppGrabber(contextwrapper);
	}
	
	public static class ForeGroundAppGrabber{
		ActivityManager am;
		ForeGroundAppGrabber(ContextWrapper contextwrapper) {
			super();
			am = (ActivityManager) contextwrapper.getSystemService(Context.ACTIVITY_SERVICE);
		}
		
		public String getPackage(){
			return am.getRunningTasks(1).get(0).baseActivity.getPackageName();
		}
		

		public String getActivity(){
			return am.getRunningTasks(1).get(0).topActivity.getClassName();
		}
		
		public String getHomeActivity(){
			return am.getRunningTasks(1).get(0).baseActivity.getClassName();			
		}
		

		public String[] getPackgeAndActivity(){
			ComponentName n = am.getRunningTasks(1).get(0).baseActivity;
			return new String[]{n.getPackageName(),n.getClassName()};
		}
	}
}

package uk.co.whiteoctober.cordova;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PackageManager;

public class AppVersion extends CordovaPlugin {
  @Override
  public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
    
      
    
  
    
    cordova.getThreadPool().execute(new Runnable() {
    public void run() {
    

	
    try {
      if (action.equals("getAppName")) {
        PackageManager packageManager = cordova.getActivity().getPackageManager();
        ApplicationInfo app = packageManager.getApplicationInfo(cordova.getActivity().getPackageName(), 0);
        callbackContext.success((String)packageManager.getApplicationLabel(app));
        //return true;
      }
      if (action.equals("getPackageName")) {
        callbackContext.success(cordova.getActivity().getPackageName());
        //return true;
      }
      if (action.equals("getVersionNumber")) {
        PackageManager packageManager = cordova.getActivity().getPackageManager();
        callbackContext.success(packageManager.getPackageInfo(cordova.getActivity().getPackageName(), 0).versionName);
      //return true;
      }
      if (action.equals("getVersionCode")) {
        PackageManager packageManager = cordova.getActivity().getPackageManager();
        callbackContext.success(packageManager.getPackageInfo(cordova.getActivity().getPackageName(), 0).versionCode);
      //return true;
      }
      //return false;
    } catch (NameNotFoundException e) {
      callbackContext.success("N/A");
      //return true;
    }
    

    }
    });
    
    
    
    return true;
  }

}

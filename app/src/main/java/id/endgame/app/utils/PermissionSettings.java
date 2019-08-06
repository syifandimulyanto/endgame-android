package id.endgame.app.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class PermissionSettings {

    final private String TAG = "PermissionSettings";

    public Context mContext;


    public static Boolean done=false;
    public PermissionSettings(Context context) {
        this.mContext = context;
    }

    public void requestAccessFinePermission(Activity activity) {
        ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        done=true;
    }
    public void requestAccessCoarsePermission(Activity activity) {
        ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
        done=true;
    }



    public void requestCallPermission(Activity activity) {
        ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.CALL_PHONE}, 1);
        done=true;
    }

    public void requestCameraPermission(Activity activity) {
        ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.CAMERA}, 1);
        done=true;
    }

    public void requestReadStoragePermission(Activity activity) {
        ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        done=true;
    }

    public void requestStoragePermission(Activity activity) {
        ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        done=true;
    }

    public boolean hasAccessFineLocation() {
        if (ContextCompat.checkSelfPermission(mContext, android.Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            return false;
        }
        return true;
    }
    public  boolean hasAccessCoarseLocation() {
        if (ContextCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            return false;
        }
        return true;
    }


    public boolean hasCallPermission() {
        if (ContextCompat.checkSelfPermission(mContext, android.Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            return false;
        }
        return true;
    }

    public boolean hasCameraPermission() {
        if (ContextCompat.checkSelfPermission(mContext, android.Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            return false;
        }
        return true;
    }

    public boolean hasReadStoragePermission() {
        if (ContextCompat.checkSelfPermission(mContext, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            return false;
        }
        return true;
    }

    public boolean hasStoragePermission() {
        if (ContextCompat.checkSelfPermission(mContext, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            return false;
        }
        return true;
    }


    //wildcard
    public boolean lacksPermissions(String... permissions) {
        for (String permission : permissions) {
            if (lacksPermission(permission)) {
                return true;
            }
        }
        return false;
    }

    private boolean lacksPermission(String permission) {
        return ContextCompat.checkSelfPermission(mContext, permission) == PackageManager.PERMISSION_DENIED;
    }
}

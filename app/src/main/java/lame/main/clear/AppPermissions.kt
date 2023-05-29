package lame.main.clear

import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import android.provider.Settings
import android.content.Context
import android.content.Intent
import android.os.Environment
import android.app.Activity
import android.os.Build
import android.Manifest
import android.net.Uri

class AppPermissions(private val context: Context, private val activity: Activity): AppCompatActivity() {
	var requestCodeActivity: Int = 101
	var requestCodePermissions: Int = 100
	
	fun hasPermissions() {
		val permissions = mutableListOf(
			Manifest.permission.READ_EXTERNAL_STORAGE,
			Manifest.permission.ACCESS_NOTIFICATION_POLICY,
			Manifest.permission.CLEAR_APP_CACHE
		)
		if (Build.VERSION.SDK_INT >= 30) {
			permissions.add(Manifest.permission.MANAGE_EXTERNAL_STORAGE)
		} else {
			permissions.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
		}
		for (permission in permissions) {
			if (ContextCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
				requestPermissions()
				break
			}
		}
	}
	
	fun requestPermissions() {
		val permissions = mutableListOf(
			Manifest.permission.READ_EXTERNAL_STORAGE,
			Manifest.permission.ACCESS_NOTIFICATION_POLICY,
			Manifest.permission.CLEAR_APP_CACHE
		)
		if (Build.VERSION.SDK_INT >= 30) {
    		permissions.add(Manifest.permission.MANAGE_EXTERNAL_STORAGE)
			if (!Environment.isExternalStorageManager()) {
				try {
<<<<<<< HEAD
        			val intent: Intent = Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
        			intent.addCategory(Intent.CATEGORY_DEFAULT);
					intent.data = Uri.parse("package:${context.packageName}")
        			this.startActivityForResult(intent, requestCodeActivity);
				} catch (e: Exception) {
        			val intent: Intent = Intent(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION);
        			this.startActivityForResult(intent, requestCodeActivity);
=======
					val intent: Intent = Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
        			intent.addCategory(Intent.CATEGORY_DEFAULT);
					intent.data = Uri.parse("package:${activity.getPackageName()}")
        			activity.startActivityForResult(intent, requestCodeActivity);
				} catch (e: Exception) {
        			val intent: Intent = Intent(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION);
        			activity.startActivityForResult(intent, requestCodeActivity);
>>>>>>> f4ba5a5 (update)
				}
			}
		} else {
			permissions.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
		}
		ActivityCompat.requestPermissions(activity, permissions.toTypedArray(), requestCodePermissions)
	}
	
	override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
<<<<<<< HEAD
    	if (requestCode == requestCodeActivity) {
        	if (resultCode != Activity.RESULT_OK) {
            	finishAffinity()
        	}
		}
    	super.onActivityResult(requestCode, resultCode, data)
=======
		if (requestCode == requestCodeActivity) {
			if (resultCode != Activity.RESULT_OK) {
				finishAffinity()
			}
		}
		super.onActivityResult(requestCode, resultCode, data)
>>>>>>> f4ba5a5 (update)
	}
	
	override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
		when (requestCode) {
			requestCodePermissions -> {
				if (grantResults.isNotEmpty() && grantResults[0] != PackageManager.PERMISSION_GRANTED) {
					finishAffinity()
				}
			}
		}
	}
}
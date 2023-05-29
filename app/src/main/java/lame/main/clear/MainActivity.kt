package lame.main.clear

import androidx.appcompat.app.AppCompatActivity
<<<<<<< HEAD
<<<<<<< HEAD
import android.os.Bundle
=======
import android.content.Intent
import android.widget.ImageView
import android.Manifest
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import android.os.Bundle
import android.net.Uri
>>>>>>> 9938106 (update)
=======
import androidx.core.content.ContextCompat
import android.content.SharedPreferences
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import org.apache.commons.io.FileUtils
import android.provider.Settings
import android.widget.ImageView
import android.content.Context
import android.content.Intent
import android.os.Environment
import android.widget.Button
import android.widget.Toast
import android.app.Activity
import android.os.Bundle
import android.os.Build
import android.Manifest
import android.net.Uri
import java.io.File
>>>>>>> bb05e2e (update)

public class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_main)
<<<<<<< HEAD
<<<<<<< HEAD
    }
=======
		 
		 checkPermission()
		 githubRedirection()
    }
	
	fun githubRedirection() {
		val githubLogo: ImageView = findViewById(R.id.github)
		githubLogo.setOnClickListener {
			val url = "https://github.com/lamefate/LameCleaner"
			val intent = Intent(Intent.ACTION_VIEW)
			intent.data = Uri.parse(url)
			startActivity(intent)
		}
		
	}
	
	fun checkPermission() {
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
			ActivityCompat.requestPermissions(this,
            	arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE,
					Manifest.permission.ACCESS_NOTIFICATION_POLICY,
					Manifest.permission.CLEAR_APP_CACHE), 100)
		}
	}
	
=======
		 
		 hasPermissions()
		 githubHandler()
		 
		 val sharedPref = getSharedPreferences("app_settings", Context.MODE_PRIVATE)
		 if (sharedPref.contains("paths")) {
			val startBtn: Button = findViewById(R.id.clearBtn)
			val paths: MutableList<String> = checkPaths(sharedPref)
			startBtn.setOnClickListener {
				clearDirs(paths)
			}
		 }
    }
	
	fun clearDirs(paths: MutableList<String>) {
		if (paths.size >= 1) {
			for (path in paths) {
				val currentPath = File(path)
				if (currentPath.canWrite() && currentPath.canExecute()) {
					FileUtils.cleanDirectory(currentPath)
				} else {
					Toast.makeText(this, "Не удалось удалить: ${currentPath}", Toast.LENGTH_SHORT).show()
				}
			}
		} else {
			Toast.makeText(this, "Не добавлено ни одной папки.", Toast.LENGTH_SHORT).show()
		}
	}
	
	fun checkPaths(sharedPref: SharedPreferences): MutableList<String> {
		val paths = sharedPref.getString("paths", "")
		return paths!!.split(";").toMutableList()
	}
	
	fun githubHandler() {
		val githubLogo: ImageView = findViewById(R.id.github)
		githubLogo.setOnClickListener {
			val intent = Intent(Intent.ACTION_VIEW)
			intent.data = Uri.parse("https://github.com/lamefate/LameCleaner")
			startActivity(intent)
		}
	}
	
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
			if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
				requestPermissions()
				break
			}
		}
	}
	
	fun requestPermissions() {
		val permissions = mutableListOf<String>()
		permissions.add(Manifest.permission.READ_EXTERNAL_STORAGE)
		permissions.add(Manifest.permission.CLEAR_APP_CACHE)
		permissions.add(Manifest.permission.ACCESS_NOTIFICATION_POLICY)
		if (Build.VERSION.SDK_INT >= 30) {
    		permissions.add(Manifest.permission.MANAGE_EXTERNAL_STORAGE)
			if (!Environment.isExternalStorageManager()) {
				try {
        			val intent: Intent = Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
        			intent.addCategory(Intent.CATEGORY_DEFAULT);
					intent.data = Uri.parse("package:${this.packageName}")
        			this.startActivityForResult(intent, 101);
				} catch (e: Exception) {
        			val intent: Intent = Intent(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION);
        			this.startActivityForResult(intent, 101);
				}
			}
		} else {
			permissions.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
		}
		ActivityCompat.requestPermissions(this, permissions.toTypedArray(), 100) // 123 было
	}
	
	override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    	if (requestCode == 101) {
        	if (resultCode != Activity.RESULT_OK) {
            	finishAffinity()
        	}
		}
    	super.onActivityResult(requestCode, resultCode, data)
	}
	
>>>>>>> bb05e2e (update)
	override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
		when (requestCode) {
			100 -> {
				if (grantResults.isNotEmpty() && grantResults[0] != PackageManager.PERMISSION_GRANTED) {
					finishAffinity()
				}
			}
		}
	}
<<<<<<< HEAD
>>>>>>> 9938106 (update)
=======
>>>>>>> bb05e2e (update)
}
package lame.main.clear

import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import android.content.SharedPreferences
import androidx.core.app.ActivityCompat
import org.apache.commons.io.FileUtils
import android.widget.ImageView
import android.content.Context
import android.content.Intent
import android.os.Environment
import android.widget.Button
import android.widget.Toast
import android.os.Bundle
<<<<<<< HEAD
import android.os.Build
import android.Manifest
import android.net.Uri
=======
import android.net.Uri
import java.nio.file.Path
>>>>>>> f4ba5a5 (update)
import java.io.File

public class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_main)
		 
<<<<<<< HEAD
		 AppPermissions(this,this).hasPermissions()
		 githubHandler()
		 
		 val sharedPref = getSharedPreferences("app_settings", Context.MODE_PRIVATE)
		 if (sharedPref.contains("paths")) {
			val startBtn: Button = findViewById(R.id.clearBtn)
			val paths: MutableList<String> = checkPaths(sharedPref)
			startBtn.setOnClickListener {
				clearDirs(paths)
			}
		 }
=======
		 githubHandler()
		 clearHandler()
		 settingsHandler()
		 AppPermissions(this,this).hasPermissions()
>>>>>>> f4ba5a5 (update)
    }
	
	fun clearDirs(paths: MutableList<String>) {
		if (paths.size >= 1) {
<<<<<<< HEAD
			for (path in paths) {
				val currentPath = File(path)
				if (currentPath.canWrite() && currentPath.canExecute()) {
					FileUtils.cleanDirectory(currentPath)
				} else {
					Toast.makeText(this, "Не удалось удалить: ${currentPath}", Toast.LENGTH_SHORT).show()
				}
=======
			for (pathU in paths) {
				val currentPath = File(pathU)
				Toast.makeText(this, "Удалось: ${currentPath}", Toast.LENGTH_SHORT).show()
				FileUtils.cleanDirectory(currentPath)
>>>>>>> f4ba5a5 (update)
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
<<<<<<< HEAD
=======
	
	fun clearHandler() {
		val sharedPref = getSharedPreferences("app_settings", Context.MODE_PRIVATE)
		val startBtn: Button = findViewById(R.id.clearBtn)
		val paths: MutableList<String> = checkPaths(sharedPref)
		startBtn.setOnClickListener {
			if (sharedPref.contains("paths")) {
				clearDirs(paths)
			} else {
				with (sharedPref.edit())
				{
					putString("paths", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString())
					apply()
				}
				clearDirs(sharedPref.getString("paths", "")!!.split(";").toMutableList())
			}
		}
	}
	
	fun settingsHandler() {
		val settingsBtn: Button = findViewById(R.id.settingsBtn)
		settingsBtn.setOnClickListener {
			val intent: Intent = Intent(this, SettingsActivity::class.java)
			startActivity(intent)
		}
	}
>>>>>>> f4ba5a5 (update)
}
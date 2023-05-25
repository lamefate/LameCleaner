package lame.main.clear

import androidx.appcompat.app.AppCompatActivity
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

public class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_main)
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
	
	override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
		when (requestCode) {
			100 -> {
				if (grantResults.isNotEmpty() && grantResults[0] != PackageManager.PERMISSION_GRANTED) {
					finishAffinity()
				}
			}
		}
	}
>>>>>>> 9938106 (update)
}
package lame.main.clear

import androidx.documentfile.provider.DocumentFile
import androidx.appcompat.app.AppCompatActivity
import android.content.SharedPreferences
import android.content.Context
import android.content.Intent
import android.widget.Button
import android.widget.Toast
import android.app.Activity
import android.os.Bundle

import java.nio.file.Path
import android.net.Uri
import java.io.File

public class SettingsActivity: AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_settings)
		
		val addPath: Button = findViewById(R.id.addPath)
		addPath.setOnClickListener {
			addNewPath()
		}
	}
	
	fun addNewPath() {
		val intent: Intent = Intent(Intent.ACTION_OPEN_DOCUMENT_TREE)
		this.startActivityForResult(intent, 123)
	}
	
	override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
		super.onActivityResult(requestCode, resultCode, data)
		if (requestCode == 123 && resultCode == Activity.RESULT_OK && data != null) {
			val treeUri = data.data
			val docFile = DocumentFile.fromTreeUri(this, treeUri!!)
			val folderPath = docFile?.uri?.path
			if (folderPath != null) {
				val folder = File(folderPath)
				val folderAbsolutePath = folder.absolutePath
				val sharedPref = getSharedPreferences("app_settings", Context.MODE_PRIVATE)
				with(sharedPref.edit())
				{
					putString("paths", folderAbsolutePath.toString() + ";")
					apply()
				}
				Toast.makeText(this, "Добавлено!", Toast.LENGTH_SHORT).show()
			}
		}
	}

	override fun onBackPressed() {
		super.onBackPressed()
	}
}
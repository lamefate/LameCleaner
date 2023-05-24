package lame.main.clear

import androidx.appcompat.app.AppCompatActivity
import android.app.ActivityOptions
import android.widget.ImageView
import com.bumptech.glide.Glide
import android.content.Intent
import android.os.Handler
import android.os.Bundle

public class IntroScreen : AppCompatActivity() {
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_intro)
		
		runAnimation()
	}
	
	fun runAnimation()
	{
		val imageView: ImageView = findViewById(R.id.intro_view)
		Glide.with(this).asGif().load(R.raw.intro).into(imageView)
		
		Handler().postDelayed({
			val intent = Intent(this, MainActivity::class.java)
			startActivity(intent)
			finish()
		}, 1950)
	}
}
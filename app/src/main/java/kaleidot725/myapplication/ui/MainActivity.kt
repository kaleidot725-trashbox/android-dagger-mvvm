package kaleidot725.myapplication.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import kaleidot725.myapplication.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val wordGenerator = (application as MyApplication).appComponent.wordGenerator()
        val word = wordGenerator.generate()
        Toast.makeText(this, "MainActivity ${word}", Toast.LENGTH_SHORT).show()

        supportFragmentManager.beginTransaction().apply {
            add(R.id.container, MainFragment())
            commit()
        }
    }
}

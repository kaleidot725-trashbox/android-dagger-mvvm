package kaleidot725.myapplication.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kaleidot725.myapplication.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val wordGenerator = (application as MyApplication).appComponent.wordGenerator()
        val word = wordGenerator.generate()
        Toast.makeText(this, "MainActivity ${word}", Toast.LENGTH_SHORT).show()

        val mainViewModel = ViewModelProviders.of(this, MainViewModelFactory(wordGenerator)).get(MainViewModel::class.java)
        mainViewModel.word.observe(this, Observer {
            Toast.makeText(this, "MainViewModel(MainAcitivity) ${it}", Toast.LENGTH_SHORT).show()
        })
        mainViewModel.generate()

        supportFragmentManager.beginTransaction().apply {
            add(R.id.container, MainFragment())
            commit()
        }
    }
}

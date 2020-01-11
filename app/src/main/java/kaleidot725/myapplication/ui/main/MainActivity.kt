package kaleidot725.myapplication.ui.main

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import kaleidot725.myapplication.R
import kaleidot725.myapplication.di.requireAppComponent
import kaleidot725.myapplication.ui.Detail.DetailActivity

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels(factoryProducer = { requireAppComponent().viewModelFactory() })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val wordGenerator = requireAppComponent().wordGenerator()
        val word = wordGenerator.generate()
        Toast.makeText(this, "MainActivity ${word}", Toast.LENGTH_SHORT).show()

        viewModel.word.observe(this, Observer {
            Toast.makeText(this, "MainViewModel(MainAcitivity) ${it}", Toast.LENGTH_SHORT).show()
        })

        supportFragmentManager.beginTransaction().apply {
            add(R.id.container, MainFragment())
            commit()
        }

        val intent = Intent(this, DetailActivity::class.java)
        startActivity(intent)
    }
}

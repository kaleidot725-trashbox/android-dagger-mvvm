package kaleidot725.myapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kaleidot725.myapplication.R
import kaleidot725.myapplication.di.requireAppComponent

class MainFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels(factoryProducer = { requireAppComponent().viewModelFactory() })

    override fun onCreate(savedInstanceState: Bundle?) {
        val wordGenerator =  requireAppComponent().wordGenerator()
        val word = wordGenerator.generate()
        Toast.makeText(context, "MainFragment ${word}", Toast.LENGTH_SHORT).show()

        viewModel.word.observe(this, Observer {
            Toast.makeText(context, "MainViewModel(MainFragment) ${it}", Toast.LENGTH_SHORT).show()
        })
        viewModel.generate()

        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }
}

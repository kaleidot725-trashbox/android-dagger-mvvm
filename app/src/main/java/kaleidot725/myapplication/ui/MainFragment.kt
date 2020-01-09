package kaleidot725.myapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kaleidot725.myapplication.R

class MainFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val wordGenerator = (activity?.application as MyApplication).appComponent.wordGenerator()
        val word = wordGenerator.generate()
        Toast.makeText(context, "MainFragment ${word}", Toast.LENGTH_SHORT).show()

        val mainViewModel = ViewModelProviders.of(this, MainViewModelFactory(wordGenerator)).get(MainViewModel::class.java)
        mainViewModel.word.observe(this, Observer {
            Toast.makeText(context, "MainViewModel(MainFragment) ${it}", Toast.LENGTH_SHORT).show()
        })
        mainViewModel.generate()

        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }
}

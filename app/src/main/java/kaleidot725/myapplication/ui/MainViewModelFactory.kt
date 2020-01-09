package kaleidot725.myapplication.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kaleidot725.myapplication.model.WordGenerator

class MainViewModelFactory(private val wordGenerator : WordGenerator) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return MainViewModel(wordGenerator) as T
    }
}
package kaleidot725.myapplication.ui.Detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import kaleidot725.myapplication.R
import kaleidot725.myapplication.di.requireAppComponent
import kaleidot725.myapplication.model.Id
import kaleidot725.myapplication.ui.main.MainViewModel

class DetailActivity : AppCompatActivity() {

    private val viewModel: DetailViewModel by viewModels(factoryProducer = {
        requireAppComponent().detailComponent().create(Id(1)).viewModelFactory()
    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        Toast.makeText(this, "ID ${viewModel.id.value}", Toast.LENGTH_SHORT).show()
    }
}

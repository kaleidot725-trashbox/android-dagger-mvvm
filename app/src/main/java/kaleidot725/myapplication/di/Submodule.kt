package kaleidot725.myapplication.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.BindsInstance
import dagger.Module
import dagger.Subcomponent
import dagger.multibindings.IntoMap
import kaleidot725.myapplication.model.Id
import kaleidot725.myapplication.ui.Detail.DetailViewModel

@Module(subcomponents = [DetailComponent::class])
object DetailComponentModule

@Subcomponent(modules = [DetailModule::class])
interface DetailComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance id: Id): DetailComponent
    }

    fun viewModelFactory(): ViewModelProvider.Factory
}

@Module
interface DetailModule {
    @Binds
    @IntoMap
    @ViewModelKey(DetailViewModel::class)
    fun bindDetailViewModel(viewModel: DetailViewModel): ViewModel
}
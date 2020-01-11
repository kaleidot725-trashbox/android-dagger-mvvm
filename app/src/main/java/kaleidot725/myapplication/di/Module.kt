package kaleidot725.myapplication.di

import android.app.Activity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.*
import dagger.multibindings.IntoMap
import kaleidot725.myapplication.model.WordGenerator
import kaleidot725.myapplication.ui.MainViewModel
import kaleidot725.myapplication.MyApplication
import kotlin.reflect.KClass

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)

@Component(modules = [AppModule::class, BindModule::class])
interface AppComponent {
    fun wordGenerator(): WordGenerator
    fun viewModelFactory() : ViewModelProvider.Factory
}

@Module
object AppModule {
    @JvmStatic
    @Provides
    fun provideWordGenerator(): WordGenerator {
        return WordGenerator()
    }
}

@Module
interface BindModule {
    @Binds
    fun bindViewModelFactory(factory : ViewModelFactory) : ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindMainViewModel(viewModel: MainViewModel): ViewModel
}

fun Activity.requireAppComponent() = (application as MyApplication).appComponent
fun Fragment.requireAppComponent() = (activity?.application as MyApplication).appComponent

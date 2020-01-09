package kaleidot725.myapplication.di

import dagger.Component
import dagger.Module
import dagger.Provides
import kaleidot725.myapplication.model.WordGenerator

@Component(modules = [AppModule::class])
interface AppComponent {
    fun wordGenerator(): WordGenerator
}

@Module
object AppModule {
    @JvmStatic
    @Provides
    fun provideWordGenerator(): WordGenerator {
        return WordGenerator()
    }
}



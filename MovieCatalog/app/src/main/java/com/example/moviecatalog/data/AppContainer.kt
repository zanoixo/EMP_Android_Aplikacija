import android.content.Context
import com.example.moviecatalog.data.MovieCatalogDatabase
import com.example.moviecatalog.data.MovieCatalogRepository
import com.example.moviecatalog.data.MovieCatalogRepositoryImpl

//dependency injection
interface AppContainer {
    val movieCatalogRepository: MovieCatalogRepository
}

//...implementation...
//provides instance of StepRepositoryImpl
class AppDataContainer (private val context: Context) : AppContainer{

    override val movieCatalogRepository: MovieCatalogRepository by lazy {
        MovieCatalogRepositoryImpl(MovieCatalogDatabase.getDatabase(context).favoriteDao(),
            MovieCatalogDatabase.getDatabase(context).watchLaterDao()  )
    }

}

package kg.example.mangalib.domain.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import kg.example.mangalib.data.remote.model.MangalibDto
import kg.example.mangalib.domain.utils.Resourse
import kg.example.mangalib.domain.model.MangalibModel
import kg.example.mangalib.domain.model.ResultModel
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Query

interface MangaRepository {
     fun getAllTopManga():Flow<Resourse<List<ResultModel>>>

     fun getAllManga( s:String): Flow<PagingData<ResultModel>>

   //  fun Paging( limit:Int,offset:Int):Flow<PagingData<MangalibModel>>

     fun getAllMangaSearch(search:String):Flow<Resourse<List<ResultModel>>>

     fun getAllMangaId(id:Int):Flow<Resourse<List<ResultModel>>>
}
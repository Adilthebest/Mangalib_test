package kg.example.mangalib.data.remote

import androidx.paging.PagingData
import kg.example.mangalib.data.remote.model.MangalibDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import kg.example.mangalib.data.remote.model.ResultDto
import kg.example.mangalib.domain.model.Paging
import kg.example.mangalib.domain.model.ResultModel
import retrofit2.Response

interface ApiService {
    @GET("v1/top-manga")
    suspend fun getAllTopManga(): List<ResultDto>

    @GET("v1/manga")
    suspend fun getAllManga(
        @Query("limit") limit: Int,
        @Query("offset") offset: HashMap<String,String>,
    ): Response<MangalibDto>
    @GET("v1/manga/{id}")
    suspend fun getAllMangaId(
        @Path("id") id: Int
    ): List<ResultDto>

    @GET("v1/manga/")
    suspend fun getAllMangaSearch(
        @Query("search") search: String
    ): List<ResultDto>

    @GET("v1/manga/")
    suspend fun Paging3(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Paging

}
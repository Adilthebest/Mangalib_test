package kg.example.mangalib.data.repository

import android.nfc.tech.MifareUltralight.PAGE_SIZE
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kg.example.mangalib.data.base.BaseRepository
import kg.example.mangalib.data.mapper.toManga
import kg.example.mangalib.data.remote.ApiService
import kg.example.mangalib.domain.model.ResultModel
import kg.example.mangalib.domain.repository.MangaRepository
import kg.example.mangalib.domain.utils.MangaListPagingSource
import kg.example.mangalib.domain.utils.Resourse
import kotlinx.coroutines.flow.Flow
const val PAGE_SIZE  =8
class MangaRepositoryImpl(val api: ApiService) : MangaRepository, BaseRepository() {
    override fun getAllTopManga(): Flow<Resourse<List<ResultModel>>> = doReguest {
        api.getAllTopManga().map { it.toManga() }
    }

    override fun getAllManga(s: String): Flow<PagingData<ResultModel>> {

        return Pager(
            config = PagingConfig(
                pageSize = kg.example.mangalib.data.repository.PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                MangaListPagingSource()
            }
        ).flow

    }
    /*override fun Paging(limit: Int, offset: Int): Flow<PagingData<MangalibModel>> {

        return Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                MangaListPagingSource(api,s)
            }
        ).flow
    }*/

    override fun getAllMangaSearch(search: String): Flow<Resourse<List<ResultModel>>> = doReguest {
        api.getAllMangaSearch(search).map { it.toManga() }
    }

    override fun getAllMangaId(id: Int): Flow<Resourse<List<ResultModel>>> = doReguest {
        api.getAllMangaId(id).map { it.toManga() }
    }

}





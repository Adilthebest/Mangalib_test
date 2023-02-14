package kg.example.mangalib.domain.utils

import android.nfc.tech.MifareUltralight.PAGE_SIZE
import androidx.paging.PagingSource
import androidx.paging.PagingState
import kg.example.mangalib.data.mapper.toManga
import kg.example.mangalib.data.remote.ApiService
import kg.example.mangalib.data.remote.model.MangalibDto
import kg.example.mangalib.data.remote.model.ResultDto
import kg.example.mangalib.domain.model.Paging
import kg.example.mangalib.domain.model.ResultModel
import retrofit2.HttpException
import java.io.IOException

private const val START_PAGE_INDEX = 0
private const val PAGE_SIZE = 8


class MangaListPagingSource(
    private val productsParams: HashMap<String, String>,
    private val service: ApiService,
    val mapper: Paging
    ) : PagingSource<Int, ResultModel>() {


    override fun getRefreshKey(state: PagingState<Int, ResultModel>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val page = state.closestPageToPosition(anchorPosition) ?: null
        return page?.prevKey?.plus(1) ?: page?.nextKey?.minus(1)
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ResultModel> {
            val position = params.key ?: START_PAGE_INDEX

            return try {
                productsParams["offset"] = (position * kg.example.mangalib.domain.utils.PAGE_SIZE).toString()
                val response = service.getAllManga(10,productsParams)

                if (response.body() == null) {
                    return LoadResult.Error(Exception("body is null"))
                } else {

                    val data = response.body()!!

                    var nextPageNumber: Int? = null
                    if (data.next != null) {
                        nextPageNumber = position + 1
                    }

                    LoadResult.Page(
                        data = data.results.map { it.toManga()},
                        prevKey = null,
                        nextKey = nextPageNumber
                    )
                }
            } catch (exception: IOException) {
                LoadResult.Error(exception)
            } catch (exception: HttpException) {
                LoadResult.Error(exception)
            }
        }

    }
       /* val position = params.key ?: START_PAGE_INDEX

        return try {
            val hash = HashMap<String,String>()
            hash["offset"] = (position * PAGE_SIZE).toString()
            hash["limit"] = (kg.example.mangalib.domain.utils.PAGE_SIZE).toString()
            val response = service.getUnauthorizedProducts(hash)

            if (response.body() == null) {
                return PagingSource.LoadResult.Error(Exception("body is null"))
            } else {

                val data = response.body()!!

                var nextPageNumber: Int? = null
                if (data.next != null) {
                    nextPageNumber = position + 1
                }

                PagingSource.LoadResult.Page(
                    data = data.results.map { mapper(it,false) },
                    prevKey = null,
                    nextKey = nextPageNumber
                )
            }
        } catch (exception: IOException) {
            PagingSource.LoadResult.Error(exception)
        } catch (exception: HttpException) {
            PagingSource.LoadResult.Error(exception)
        }
    }*/

      /*  if (query.isEmpty()) {
            return LoadResult.Page(emptyList(), prevKey = null, nextKey = null)
        }
        return try {


            val page: Int = params.key ?: 1
            val pageSize: Int = params.loadSize.coerceAtMost(20)

            val response = service.getAllManga(20, 20, page)

            val result = checkNotNull(response).map { it.toManga() }
            val nextKey = if (result.size < pageSize) null else page + 1
            val prevKey = if (page == 1) null else page - 1
            return LoadResult.Page(result, prevKey, nextKey)
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }*/

/*return try {
    val page = params.key ?: 1
    val response =repository.Paging(10,page)

    LoadResult.Page(
        data = response.map { it.data },
        prevKey = null,
        nextKey = if (response.results.isEmpty()) response.count + 1 else null
    )
} catch (e: Exception) {
    LoadResult.Error(e)
}}*/
/* val position = params.key ?: INITIAL_LOAD_SIZE
val offset =
    if (params.key != null) ((position - 1) * NETWORK_PAGE_SIZE) + 1 else INITIAL_LOAD_SIZE
return try {

    val jsonResponse =
    val response = repository.
    val nextKey = if (response.isEmpty()) {
        null
    } else {
        // initial load size = 3 * NETWORK_PAGE_SIZE
        // ensure we're not requesting duplicating items, at the 2nd request
        position + (params.loadSize / NETWORK_PAGE_SIZE)
    }
    LoadResult.Page(
        data = response,
        prevKey = null, // Only paging forward.
        // assume that if a full page is not loaded, that means the end of the data
        nextKey = nextKey
    )
} catch (e: Exception) {
    LoadResult.Error(e)
}
}
*/



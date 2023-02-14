package kg.example.mangalib.presentation.ui.fragment.manga

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import kg.example.mangalib.domain.model.ResultModel
import kg.example.mangalib.domain.usecase.GetAllMangaUseCase
import kg.example.mangalib.domain.usecase.GetMangaSearchUseCase
import kg.example.mangalib.domain.utils.Resourse
import kg.example.mangalib.domain.utils.UiState
import kg.example.mangalib.presentation.ui.base.BaseViewModel
import kotlinx.coroutines.flow.*

class AllMangaViewModel(
    private val getAllMangaUseCase: GetAllMangaUseCase,
    private val getMangaSearchUseCase: GetMangaSearchUseCase,

) : BaseViewModel() {
    private val _getAllMangaSearch = MutableStateFlow<UiState<List<ResultModel>>>(UiState.Empty())
    val getMangaSearch = _getAllMangaSearch.asStateFlow()

    private val _cryptoList = MutableLiveData<PagingData<ResultModel>>()

    private val _getAllManga = MutableStateFlow<UiState<PagingData<ResultModel>>>(UiState.Empty())
    val getAllManga = _getAllManga.asStateFlow()


    /*suspend fun getCryptoList(): LiveData<PagingData<ResultModel>> {
            val response = getAllMangaUseCase.getAllManga().cachedIn(viewModelScope)
            _cryptoList.value = response.value
            return response

*/



    fun getMangaSearch(search:String) {
        getMangaSearchUseCase.getMangaSearch(search).onEach { result ->
            when (result) {
                is Resourse.Success -> {
                    _getAllMangaSearch.value = UiState.Success(result.data!!)

                }
                is Resourse.Error -> {
                    _getAllMangaSearch.value = UiState.Error(result.message!!)

                }
                is Resourse.Loading -> {
                    _getAllMangaSearch.value = UiState.Loading()

                }
            }
        }.launchIn(viewModelScope)
    }

}
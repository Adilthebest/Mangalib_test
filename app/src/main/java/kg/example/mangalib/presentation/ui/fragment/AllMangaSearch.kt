package kg.example.mangalib.presentation.ui.fragment

import kg.example.mangalib.domain.model.ResultModel

data class AllMangaSearch(
    val data:List<ResultModel>? = null,
    val error:String ="",
    val isLoading:Boolean = false
)

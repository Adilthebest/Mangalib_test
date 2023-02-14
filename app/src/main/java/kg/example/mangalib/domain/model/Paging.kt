package kg.example.mangalib.domain.model

import kg.example.mangalib.data.remote.model.MangalibDto
import kg.example.mangalib.data.remote.model.ResultDto

data class Paging (
    val result:List<MangalibDto>,
    val boolean: Boolean = true
        )
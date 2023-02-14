package kg.example.mangalib.domain.usecase

import kg.example.mangalib.domain.repository.MangaRepository

class GetAllMangaIdUseCase(private val repository: MangaRepository) {
    fun getAllMangaId(id:Int)=repository.getAllMangaId(id)
}
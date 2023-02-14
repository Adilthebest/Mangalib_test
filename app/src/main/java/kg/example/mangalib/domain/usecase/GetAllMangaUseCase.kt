package kg.example.mangalib.domain.usecase

import kg.example.mangalib.domain.repository.MangaRepository

class GetAllMangaUseCase(private val repository: MangaRepository) {
      fun getAllManga(s:String) = repository.getAllManga(s)

}
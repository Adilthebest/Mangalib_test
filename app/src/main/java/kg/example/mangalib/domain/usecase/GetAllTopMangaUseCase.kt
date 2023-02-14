package kg.example.mangalib.domain.usecase

import kg.example.mangalib.domain.repository.MangaRepository

class GetAllTopMangaUseCase(val repository:MangaRepository) {
      fun getAllMangaTop() = repository.getAllTopManga()


}
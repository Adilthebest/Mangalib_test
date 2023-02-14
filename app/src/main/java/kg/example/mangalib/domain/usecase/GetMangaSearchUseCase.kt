package kg.example.mangalib.domain.usecase

import kg.example.mangalib.domain.repository.MangaRepository

class GetMangaSearchUseCase(val repository: MangaRepository) {
    fun getMangaSearch(search:String) = repository.getAllMangaSearch(search)

}
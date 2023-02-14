package kg.example.mangalib.di

import kg.example.mangalib.domain.usecase.GetAllMangaIdUseCase
import kg.example.mangalib.domain.usecase.GetAllMangaUseCase
import kg.example.mangalib.domain.usecase.GetAllTopMangaUseCase
import kg.example.mangalib.domain.usecase.GetMangaSearchUseCase
import org.koin.dsl.module

val domainModule = module {
    factory <GetAllTopMangaUseCase>{
        GetAllTopMangaUseCase(repository = get( ))
    }
    factory {
        GetAllMangaUseCase(repository = get( ))
    }
    factory {
        GetMangaSearchUseCase(repository = get( ))
    }
    factory {
        GetAllMangaIdUseCase(repository = get( ))
    }
}
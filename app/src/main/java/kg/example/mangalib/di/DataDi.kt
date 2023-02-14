package kg.example.mangalib.di

import kg.example.mangalib.data.remote.ApiService
import kg.example.mangalib.data.repository.MangaRepositoryImpl
import kg.example.mangalib.domain.repository.MangaRepository
import org.koin.dsl.module

val dataModule = module {

    single <MangaRepository>{
        MangaRepositoryImpl(api = get())
    }
}
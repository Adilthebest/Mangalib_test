package kg.example.mangalib.data.mapper

import kg.example.mangalib.data.remote.model.MangalibDto
import kg.example.mangalib.domain.model.ResultModel
import kg.example.mangalib.data.remote.model.ResultDto
import kg.example.mangalib.domain.model.MangalibModel


fun ResultModel.toMangas() = ResultDto(


    chapters_quantity,
    created_at,
    en_name,
    description,
    genre, id, image, issue_year, likes, rating, ru_name, dir, type, updated_at

)


fun ResultDto.toManga(): ResultModel {
    return ResultModel(
        chapters_quantity,
        created_at,
        en_name,
        genre,
        id,
        image,
        issue_year,
        likes,
        rating,
        ru_name,
        dir,
        type,
        updated_at,
        description ?: ""
    )

}

fun MangalibDto.toDataMango() = kg.example.mangalib.domain.model.MangalibModel(
    count,
    next,
    previous,
    results.map { it.toManga() }
)

fun kg.example.mangalib.domain.model.MangalibModel.toDomainManga() = MangalibDto(
    count,
    next,
    previous,
    results.map { it.toMangas() }
)





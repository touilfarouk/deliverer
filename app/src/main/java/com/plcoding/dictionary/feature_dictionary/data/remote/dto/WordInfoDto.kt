package com.plcoding.dictionary.feature_dictionary.data.remote.dto

import com.plcoding.dictionary.feature_dictionary.data.local.entity.WordInfoEntity
import com.plcoding.dictionary.feature_dictionary.domain.model.WordInfo


data class WordInfoDto(
    val meanings: List<MeaningDto>,
    val origin: String?, // <-- make nullable
    val phonetic: String,
    val phonetics: List<PhoneticDto>,
    val word: String
) {
    fun toWordInfoEntity(): WordInfoEntity {
        return WordInfoEntity(
            meanings = meanings.map { it.toMeaning() },
            origin = this.origin ?: "", // <-- safely replace null with ""
            phonetic = phonetic,
            word = word
        )
    }
}
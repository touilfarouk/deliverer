package com.plcoding.dictionary.feature_dictionary.domain.model

data class WordInfo(
    val meanings: List<Meaning>,
    val origin: String?, // <-- make nullable
    val phonetic: String,
    val word: String
)

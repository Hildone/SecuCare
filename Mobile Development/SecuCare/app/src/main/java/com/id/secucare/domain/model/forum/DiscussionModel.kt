package com.id.secucare.domain.model.forum

data class DiscussionModel(
    val discName: String,
    val name: String,
    val date: String,
    val like: String,
    val comment: String,
    val save: String
) {
    companion object {
        fun fakes(): List<DiscussionModel> =
            (1..10).map {
                DiscussionModel(
                    discName = "DiscName $it",
                    name = "Name $it",
                    date = "Date $it",
                    like = "${120+it}",
                    comment = "${140+it}",
                    save = "${3+it}"
                )
            }

    }
}
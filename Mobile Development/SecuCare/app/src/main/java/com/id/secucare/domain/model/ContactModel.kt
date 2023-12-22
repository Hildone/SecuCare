package com.id.secucare.domain.model

data class ContactModel(
    val name: String,
    val phoneNumber: String
) {
    companion object {
        fun fakes(): List<ContactModel> {
            return (1..10).map {
                ContactModel("Name $it", phoneNumber = "phoneNumber $it")
            }
        }
    }
}
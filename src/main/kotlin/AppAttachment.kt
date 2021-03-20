package ru.netology

class AppAttachment(
    override val type: String = "app",
    val app: App = App(
        333, "name", "photo1", "photo2"
    )
) : Attachments {
    override fun toString(): String {
        return "$type - ${app.id}"
    }
}
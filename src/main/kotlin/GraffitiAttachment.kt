package ru.netology

class GraffitiAttachment(
    override val type: String = "graffiti",
    val graffiti: Graffiti = Graffiti(
        222, 2, "photo1", "photo2"
    )
) : Attachments {
    override fun toString(): String {
        return "$type - ${graffiti.id}"
    }
}
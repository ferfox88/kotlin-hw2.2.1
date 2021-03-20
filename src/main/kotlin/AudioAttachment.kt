package ru.netology

class AudioAttachment(
    override val type: String = "audio",
    val audio: Audio = Audio(
        111, 2, "artist", "title", 3,
        "url", 1, 1, 1, 1, true, true
    )
) : Attachments {
    override fun toString(): String {
        return "$type - ${audio.id}"
    }
}
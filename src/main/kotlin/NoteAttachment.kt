package ru.netology

class NoteAttachment(
    override val type: String = "note",
    val note: Note = Note(
        555, 23, "title", "text", 10, 3, 3, "url"
    )
) : Attachments {
    override fun toString(): String {
        return "$type - ${note.id}"
    }
}
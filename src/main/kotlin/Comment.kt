import ru.netology.*

data class Comment(
    val id: Int,
    val fromId: Int,
    val data: Int,
    val text: String,
    val donut: Donut,
    val replyToUser: Int,
    val replyToComment: Int,
    val attachments: Array<Attachments>?,
    val parentStack: Array<Int>?,
    val thread: Thread?
)
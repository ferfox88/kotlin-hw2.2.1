import ru.netology.*

fun main() {
    val service = WallService()
    val comments = Comments(2, true, true, true, true)
    val copyright = Copyright(1, "", "", "")
    val likes = Likes(1, false, true, false, false)
    val views = Views(5)
    val donut = Donut(true, 1, "", true, "all")

    val post = Post(
        41, 11, 13, 0, 11, "привет!",
        0, 1, true, comments, copyright, likes, null, views,
        PostType.post, null, arrayOf<Attachments>(AudioAttachment()), null, 0, null, true, true, true, true, true,
        false, donut, 0
    )

    val comment = Comment(
        1, 2, 1, "text", donut, 2, 2,
        arrayOf<Attachments>(AudioAttachment()), null, null
    )

    service.add(post)

    val result = service.createComment(comment)
    println(post.id)
}
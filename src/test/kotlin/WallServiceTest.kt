//import org.junit.jupiter.api.Test
import org.junit.Test
import org.junit.Assert.*
import ru.netology.*

class WallServiceTest {
    // создаём целевой сервис
    val service = WallService()

    @Test
    fun updateExistingTrue() {
        // заполняем несколькими постами
        val comments = Comments(2, true, true, true, true)
        val copyright = Copyright(1, "", "", "")
        val likes = Likes(1, false, true, false, false)
        //val reposts = Reposts(1, false)
        val views = Views(5)
        val donut = Donut(true, 1, "", true, "all")

        service.add(
            Post(
                1,
                11,
                13,
                0,
                11,
                "привет!",
                0,
                1,
                true,
                comments,
                copyright,
                likes,
                null,
                views,
                PostType.post,
                null,
                arrayOf<Attachments>(AudioAttachment(), NoteAttachment()),
                null,
                0,
                null,
                true,
                true,
                true,
                true,
                true,
                false,
                donut,
                0
            )
        )
        service.add(
            Post(
                2,
                11,
                13,
                0,
                11,
                "привет!",
                0,
                1,
                true,
                comments,
                copyright,
                likes,
                null,
                views,
                PostType.post,
                null,
                arrayOf<Attachments>(AudioAttachment()),
                null,
                0,
                null,
                true,
                true,
                true,
                true,
                true,
                false,
                donut,
                0
            )
        )
        service.add(
            Post(
                3,
                11,
                13,
                0,
                11,
                "привет!",
                0,
                1,
                true,
                comments,
                copyright,
                likes,
                null,
                views,
                PostType.post,
                null,
                arrayOf<Attachments>(AudioAttachment()),
                null,
                0,
                null,
                true,
                true,
                true,
                true,
                true,
                false,
                donut,
                0
            )
        )
        // создаём информацию об обновлении
        val update = Post(
            2, 11, 13, 0, 11, "привет!",
            0, 1, true, comments, copyright, likes, null, views,
            PostType.post, null, arrayOf<Attachments>(AudioAttachment()), null, 0, null, true, true, true, true, true,
            false, donut, 0
        )

        // выполняем целевое действие
        val result = service.update(update)

        // проверяем результат (используйте assertTrue или assertFalse)
        assertTrue(result)
    }

    @Test
    fun updateExistingFalse() {
        // заполняем несколькими постами
        val comments = Comments(2, true, true, true, true)
        val copyright = Copyright(1, "", "", "")
        val likes = Likes(1, false, true, false, false)
        //val reposts = Reposts(1, false)
        val views = Views(5)
        val donut = Donut(true, 1, "", true, "all")


        service.add(
            Post(
                1,
                11,
                13,
                0,
                11,
                "привет!",
                0,
                1,
                true,
                comments,
                copyright,
                likes,
                null,
                views,
                PostType.post,
                null,
                arrayOf<Attachments>(AudioAttachment()),
                null,
                0,
                null,
                true,
                true,
                true,
                true,
                true,
                false,
                donut,
                0
            )
        )
        service.add(
            Post(
                2,
                11,
                13,
                0,
                11,
                "привет!",
                0,
                1,
                true,
                comments,
                copyright,
                likes,
                null,
                views,
                PostType.post,
                null,
                arrayOf<Attachments>(AudioAttachment()),
                null,
                0,
                null,
                true,
                true,
                true,
                true,
                true,
                false,
                donut,
                0
            )
        )
        service.add(
            Post(
                3,
                11,
                13,
                0,
                11,
                "привет!",
                0,
                1,
                true,
                comments,
                copyright,
                likes,
                null,
                views,
                PostType.post,
                null,
                arrayOf<Attachments>(AudioAttachment()),
                null,
                0,
                null,
                true,
                true,
                true,
                true,
                true,
                false,
                donut,
                0
            )
        )
        // создаём информацию об обновлении
        val update = Post(
            5, 11, 13, 0, 11, "привет!",
            0, 1, true, comments, copyright, likes, null, views,
            PostType.post, null, arrayOf<Attachments>(AudioAttachment()), null, 0, null, true, true, true, true, true,
            false, donut, 0
        )

        // выполняем целевое действие
        val result = service.update(update)

        // проверяем результат (используйте assertTrue или assertFalse)
        assertFalse(result)
    }

    @Test
    fun addPost() {
        // заполняем несколькими постами
        val comments = Comments(2, true, true, true, true)
        val copyright = Copyright(1, "", "", "")
        val likes = Likes(1, false, true, false, false)
        //val reposts = Reposts(1, false)
        val views = Views(5)
        val donut = Donut(true, 1, "", true, "all")

        val post = Post(
            0, 11, 13, 0, 11, "привет!",
            0, 1, true, comments, copyright, likes, null, views,
            PostType.post, null, arrayOf<Attachments>(AudioAttachment()), null, 0, null, true, true, true, true, true,
            false, donut, 0
        )
        service.add(post)

        val result = post.id > 0

        assertTrue(result)
    }

    @Test
    fun addComments() {
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
        assertTrue(result)
    }

    @Test(expected = PostNotFoundException::class)
    fun addCommentsShouldThrow() {
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
            2, 2, 1, "text", donut, 2, 2,
            arrayOf<Attachments>(AudioAttachment()), null, null
        )

        service.add(post)
        service.createComment(comment)
    }
}

import ru.netology.*
import kotlin.Array

data class Post(
    var id: Int = 0,
    val ownerId: Int,
    val fromId: Int,
    val createdBy: Int,
    val date: Int,
    val text: String,
    val replyOwnerId: Int,
    val replyPostId: Int,
    val friendsOnly: Boolean,
    val comments: Comments,
    val copyright: Copyright,
    val likes: Likes,    //
    val reposts: Reposts?,
    val views: Views,
    val postType: PostType,
    val postSource: PostSource?, //
    val geo: Geo?, //
    val signerId: Int,
    val copyHistory: ArrayList<Reposts>?, //
    val canPin: Boolean,
    val canDelete: Boolean,
    val canEdit: Boolean,
    val isPinned: Boolean,
    val markedAsAds: Boolean,
    val isFavorite: Boolean,
    val donut: Donut,
    val postponedId: Int
)
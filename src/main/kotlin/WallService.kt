package ru.netology

import Comment
import Post
import PostNotFoundException

class WallService {
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()

    fun add(post: Post): Post {
        val idPost = if (posts.isNotEmpty()) posts.last().id + 1 else 1
        posts += post
        post.id = idPost
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index) in posts.withIndex()) {
            if (post.id == posts[index].id) {
                posts[index] = post.copy(
                    id = post.id,
                    fromId = post.fromId,
                    createdBy = post.createdBy,
                    text = post.text,
                    replyOwnerId = post.replyOwnerId,
                    replyPostId = post.replyPostId,
                    friendsOnly = post.friendsOnly,
                    comments = post.comments,
                    copyright = post.copyright,
                    likes = post.likes,
                    reposts = post.reposts,
                    views = post.views,
                    postType = post.postType,
                    postSource = post.postSource,
                    signerId = post.signerId,
                    geo = post.geo,
                    copyHistory = post.copyHistory,
                    canPin = post.canPin,
                    canDelete = post.canDelete,
                    canEdit = post.canEdit,
                    isPinned = post.isPinned,
                    markedAsAds = post.markedAsAds,
                    isFavorite = post.isFavorite,
                    donut = post.donut,
                    postponedId = post.postponedId
                )
                return true
            }
        }
        return false
    }

    fun createComment(comment: Comment): Boolean {
        for (post in posts) {
            if (post.id == comment.id) {
                comments += comment
                return true
            }
        }
        throw PostNotFoundException("post not found")
    }
}


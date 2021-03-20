package ru.netology

class PageAttachment(
    override val type: String = "page",
    val page: Page = Page(
        444, 23, "title"
    )
) : Attachments {
    override fun toString(): String {
        return "$type - ${page.id}"
    }
}
package com.mr.nemo.dragonfly.ui.entitiy.main.inbox

import kotlin.reflect.KClass

sealed interface InboxPageTab {

    val title: String

    data class Inbox(override val title: String) : InboxPageTab
    data class Notification(override val title: String) : InboxPageTab
    companion object {

        fun values(
            titleProvider: InboxPageTabTitleProvider,
        ): List<InboxPageTab> {
            return listOf(
                Inbox(titleProvider(Inbox::class)),
                Notification(titleProvider(Notification::class))
            )
        }
    }
}

fun interface InboxPageTabTitleProvider {

    operator fun invoke(tab: KClass<out InboxPageTab>): String
}

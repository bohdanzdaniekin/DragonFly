package com.mr.nemo.dragonfly.ui.screen.main.inbox

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.vector.ImageVector

@Immutable
data class InboxMessage(
    val title: String,
    val subtitle: String,
    val icon: ImageVector
)


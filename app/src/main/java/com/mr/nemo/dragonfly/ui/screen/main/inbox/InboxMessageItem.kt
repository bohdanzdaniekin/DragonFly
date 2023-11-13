package com.mr.nemo.dragonfly.ui.screen.main.inbox

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.mr.nemo.dragonfly.ui.theme.DragonFlyTheme

@Composable
fun InboxMessageItem(
    message: InboxMessage,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            Modifier
                .background(
                    color = DragonFlyTheme.colors.primary.main.copy(alpha = 0.05f),
                    shape = DragonFlyTheme.shapes.extraSmall
                )
                .padding(DragonFlyTheme.spacing.xSmall)
        ) {
            Icon(
                imageVector = message.icon,
                contentDescription = message.title,
                tint = DragonFlyTheme.colors.primary.main
            )
        }

        Spacer(modifier = Modifier.width(DragonFlyTheme.spacing.small))

        Column {
            Text(
                text = message.title,
                style = DragonFlyTheme.typography.text1.medium,
                color = DragonFlyTheme.colors.primary.main
            )
            Spacer(modifier = Modifier.height(DragonFlyTheme.spacing.xSmall))
            Text(
                text = message.subtitle,
                style = DragonFlyTheme.typography.text2.regular,
                color = DragonFlyTheme.colors.neutral6,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun InboxMessageItemPreview() {
    DragonFlyTheme {
        InboxMessageItem(
            message = InboxMessage(
                title = "Investment just got easier",
                subtitle = "Investing in a bank is one of the common and safe choices for beginners " +
                    "who want to start their investment journey. This article will provide a short guide " +
                    "to getting started investing in banks, covering some of the investment products " +
                    "offered by banks and tips for getting started.",
                icon = Icons.Outlined.Notifications
            )
        )
    }
}

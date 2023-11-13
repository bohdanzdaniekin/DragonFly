package com.mr.nemo.dragonfly.ui.screen.main.inbox

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mr.nemo.dragonfly.ui.theme.DragonFlyTheme

@Composable
fun InboxTab(
    messages: List<InboxMessage>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    horizontalAlignment: Alignment.Horizontal = Alignment.Start
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = contentPadding,
        horizontalAlignment = horizontalAlignment
    ) {
        items(messages) { message ->
            InboxMessageItem(
                message = message,
                modifier = Modifier.padding(vertical = DragonFlyTheme.spacing.small)
            )
            Divider(color = DragonFlyTheme.colors.neutral7)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun InboxTabPreview() {
    DragonFlyTheme {
        InboxTab(
            messages = listOf(
                InboxMessage(
                    title = "Investment just got easier",
                    subtitle = "Investing in a bank is one of the common and safe choices for beginners " +
                        "who want to start their investment journey. This article will provide a short guide " +
                        "to getting started investing in banks, covering some of the investment products " +
                        "offered by banks and tips for getting started.",
                    icon = Icons.Outlined.Notifications
                ),
                InboxMessage(
                    title = "Tips for safe foreign transactions",
                    subtitle = "Choose the Right Transfer Method:\n" +
                        "There are several transfer methods that can be used, such as bank transfers, " +
                        "electronic transfers, or using money transfer services such as PayPal or " +
                        "TransferWise. Make sure to choose the most efficient and economical method " +
                        "for your needs.\n",
                    icon = Icons.Outlined.Notifications
                )
            )
        )
    }
}

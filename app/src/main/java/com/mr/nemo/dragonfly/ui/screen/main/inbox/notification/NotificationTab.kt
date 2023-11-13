package com.mr.nemo.dragonfly.ui.screen.main.inbox.notification

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.mr.nemo.dragonfly.ui.theme.DragonFlyTheme

@Composable
fun NotificationTab(
    notifications: List<NotificationMessage>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    horizontalAlignment: Alignment.Horizontal = Alignment.Start
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = contentPadding,
        horizontalAlignment = horizontalAlignment
    ) {
        items(notifications) { message ->
            NotificationMessageItem(
                notification = message,
                modifier = Modifier.padding(vertical = DragonFlyTheme.spacing.small)
            )
            Divider(color = DragonFlyTheme.colors.neutral7)
        }
    }
}

@Composable
fun NotificationMessageItem(
    notification: NotificationMessage,
    modifier: Modifier = Modifier
) {
    val typography = DragonFlyTheme.typography
    val colors = DragonFlyTheme.colors
    val shapes = DragonFlyTheme.shapes
    val spacing = DragonFlyTheme.spacing
    Column(modifier = modifier) {
        Text(
            text = notification.title,
            style = typography.subtitle2.medium,
            color = colors.primary.main
        )

        Spacer(modifier = Modifier.height(spacing.medium))

        Text(
            text = notification.message,
            style = typography.text2.regular,
            color = colors.neutral4,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )

        Spacer(modifier = Modifier.height(spacing.medium))

        Image(
            painter = rememberAsyncImagePainter(model = notification.imageUrl),
            contentDescription = notification.title,
            modifier = Modifier
                .height(150.dp)
                .clip(shapes.extraSmall),
            contentScale = ContentScale.Crop
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun NotificationTabPreview() {
    DragonFlyTheme {
        NotificationTab(
            notifications = listOf(
                NotificationMessage(
                    title = "Free transfer other bank",
                    message = "Enjoy free interbank transfer fees for a full month and many other attractive promos",
                    imageUrl = ""
                ),
                NotificationMessage(
                    title = "Pay using a Dragonfly credit card",
                    message = "Enjoy discounts by using a credit card of up to 70% this promo applies only to new users",
                    imageUrl = ""
                )
            )
        )
    }
}

package com.mr.nemo.dragonfly.ui.screen.main.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.mr.nemo.dragonfly.R
import com.mr.nemo.dragonfly.ui.component.button.DangerButton
import com.mr.nemo.dragonfly.ui.theme.DragonFlyTheme

private const val PICTURE_URL =
    "https://static.wikia.nocookie.net/vsbattles/images/4/48/DE5FF9F5-8823-43AA-8943-BF7099FB6DB7.jpeg/revision/latest?cb=20180407152631"

@Composable
fun ProfilePage(
    image: Any?,
    fullName: String,
    membership: String,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    val spacing = DragonFlyTheme.spacing
    val typography = DragonFlyTheme.typography
    val colors = DragonFlyTheme.colors
    Column(
        modifier = modifier.padding(contentPadding)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Image(
                painter = rememberAsyncImagePainter(model = image),
                contentDescription = fullName,
                Modifier
                    .size(size = 48.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(spacing.small))

            Column {
                Text(
                    text = fullName,
                    style = typography.subtitle2.medium,
                    color = colors.neutral2
                )

                Spacer(modifier = Modifier.height(spacing.xxSmall))

                Text(
                    text = membership,
                    style = typography.text2.regular,
                    color = colors.neutral4
                )
            }
        }

        Spacer(modifier = Modifier.height(spacing.large))

        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            item {
                ProfileSectionItem(
                    title = "Personal data",
                    icon = Icons.Outlined.Person,
                    onClick = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(spacing.small)
                )
                Divider(color = colors.neutral7)
            }
            item {
                ProfileSectionItem(
                    title = "Settings",
                    icon = Icons.Outlined.Settings,
                    onClick = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(spacing.small)
                )
                Divider(color = colors.neutral7)
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        DangerButton(
            text = "Log out",
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        )

        Spacer(modifier = Modifier.height(spacing.large))
    }
}

@Composable
fun ProfileSectionItem(
    title: String,
    icon: ImageVector,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val spacing = DragonFlyTheme.spacing
    val typography = DragonFlyTheme.typography
    val colors = DragonFlyTheme.colors
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = title,
                modifier = Modifier.padding(spacing.xxSmall),
                tint = DragonFlyTheme.colors.primary.main
            )
            Text(
                text = title,
                style = typography.text1.regular,
                color = colors.neutral4
            )
        }
        IconButton(onClick = onClick) {
            Icon(
                imageVector = Icons.Default.ArrowForwardIos,
                contentDescription = stringResource(R.string.content_description_go_to, title),
                tint = DragonFlyTheme.colors.neutral6
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProfilePagePreview() {
    DragonFlyTheme {
        ProfilePage(
            image = PICTURE_URL,
            fullName = "Ovuvuevuevue Enyetuenwuevue Ugbemugbem Osas",
            membership = "Silver members",
            modifier = Modifier.fillMaxHeight()
        )
    }
}

package com.mr.nemo.dragonfly.ui.screen.auth.signup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.mr.nemo.dragonfly.R
import com.mr.nemo.dragonfly.ui.component.text.TitleText
import com.mr.nemo.dragonfly.ui.theme.DragonFlyTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpInfoScreen(
    modifier: Modifier = Modifier,
    items: List<InfoItem> = emptyList()
) {
    val spacing = DragonFlyTheme.spacing
    val typography = DragonFlyTheme.typography
    val colors = DragonFlyTheme.colors
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.information),
                        style = typography.subtitle2.medium,
                        color = colors.neutral2
                    )
                },
                navigationIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_back),
                        contentDescription = stringResource(id = R.string.content_description_navigate_back)
                    )
                },
                modifier = Modifier.padding(horizontal = spacing.medium)
            )
        },
        containerColor = colors.neutral8,
        modifier = modifier
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues)
                .padding(horizontal = spacing.medium),

            ) {
            Spacer(modifier = Modifier.height(spacing.large))

            TitleText(
                text = stringResource(R.string.frequently_read_articles),
                modifier = Modifier.align(Alignment.CenterHorizontally),
                style = typography.subtitle1.regular,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(spacing.xLarge))

            LazyColumn {
                items(items) { item ->
                    Spacer(modifier = Modifier.height(spacing.medium))
                    SignUpInfoItem(item = item)
                    Spacer(modifier = Modifier.height(spacing.medium))
                    Divider(color = colors.neutral7)
                }
            }
        }
    }
}

@Composable
fun SignUpInfoItem(
    item: InfoItem,
    modifier: Modifier = Modifier
) {
    val spacing = DragonFlyTheme.spacing
    val typography = DragonFlyTheme.typography
    val colors = DragonFlyTheme.colors
    Column(modifier = modifier) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_book),
                contentDescription = null,
                tint = colors.primary.main
            )

            Spacer(modifier = Modifier.width(spacing.xSmall))

            Text(
                text = item.title,
                style = typography.text1.medium,
                color = colors.neutral2
            )
        }

        Spacer(modifier = Modifier.height(spacing.medium))

        Text(
            text = item.subtitle,
            style = typography.text2.regular,
            color = colors.neutral6
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpInfoScreenPreview() {
    DragonFlyTheme {
        SignUpInfoScreen(
            items = listOf(
                InfoItem(
                    title = "How to reset password",
                    subtitle = "If you forget your password, you can request a password reset via email or the number you registered"
                ),
                InfoItem(
                    title = "How to create a virtual account",
                    subtitle = "To create a virtual account you need to raise your customer status to priority"
                )
            )
        )
    }
}
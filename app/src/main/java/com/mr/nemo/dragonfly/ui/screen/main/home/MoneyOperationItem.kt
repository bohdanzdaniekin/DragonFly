package com.mr.nemo.dragonfly.ui.screen.main.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.mr.nemo.dragonfly.R
import com.mr.nemo.dragonfly.ui.theme.DragonFlyTheme

@Composable
fun MoneyOperationItem(
    text: String,
    icon: Painter,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    verticalArrangement: Arrangement.Vertical =
        Arrangement.spacedBy(DragonFlyTheme.spacing.small)
) {
    Column(
        modifier = modifier
            .clip(DragonFlyTheme.shapes.extraSmall)
            .clickable(
                onClick = onClick
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = verticalArrangement,
    ) {
        Icon(
            painter = icon,
            contentDescription = text,
            tint = Color.Unspecified
        )

        Text(
            text = text,
            style = DragonFlyTheme.typography.text2.regular,
            color = DragonFlyTheme.colors.neutral2
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MoneyOperationItemPreview() {
    DragonFlyTheme {
        MoneyOperationItem(
            text = stringResource(R.string.send),
            icon = painterResource(id = R.drawable.ic_money_send),
            onClick = {}
        )
    }
}

package com.mr.nemo.dragonfly.ui.screen.main.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mr.nemo.dragonfly.R
import com.mr.nemo.dragonfly.ui.component.CardTitledLogo
import com.mr.nemo.dragonfly.ui.theme.DragonFlyTheme

@Composable
fun CreditCardItem(
    modifier: Modifier = Modifier
) {
    val shapes = DragonFlyTheme.shapes
    val spacing = DragonFlyTheme.spacing
    val typography = DragonFlyTheme.typography
    val colors = DragonFlyTheme.colors
    Column(
        modifier = modifier
            .clip(shape = shapes.small)
            .border(
                width = 1.dp,
                color = colors.neutral7,
                shape = shapes.small,
            )
    ) {
        Box(
            modifier = Modifier
                .aspectRatio(ratio = 1f)
                .clip(shape = shapes.small)
                .paint(
                    painter = painterResource(
                        id = R.drawable.bg_debit_card_1 // TODO
                    ),
                    contentScale = ContentScale.Crop
                )
        ) {
            CardTitledLogo(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(top = spacing.medium, end = spacing.medium)
            )
            Column(
                Modifier
                    .align(Alignment.BottomStart)
                    .padding(bottom = spacing.medium, start = spacing.medium)
            ) {
                Text(
                    text = "Biancaliza", // TODO
                    style = typography.text2.regular,
                    color = colors.neutral8
                )

                Spacer(modifier = Modifier.height(spacing.xxSmall))

                Text(
                    text = "1234 5678 9000 0000", // TODO
                    style = typography.card,
                    color = colors.neutral8
                )

                Spacer(modifier = Modifier.height(spacing.small))

                Image(
                    painter = painterResource(id = R.drawable.ic_card_chip),
                    contentDescription = null,
                    modifier = Modifier.size(width = 24.dp, height = 16.dp)
                )

                Spacer(modifier = Modifier.height(spacing.small))

            }
        }
        Spacer(modifier = Modifier.height(spacing.xSmall))

        Column(
            modifier = Modifier.padding(start = spacing.small)
        ) {
            Text(
                text = "Saving Balance", // TODO
                style = typography.caption.regular,
                color = colors.neutral2
            )

            Spacer(modifier = Modifier.height(spacing.xSmall))

            Text(
                text = "\$ 1,000.00", // TODO
                style = typography.subtitle2.medium,
                color = colors.primary.main
            )
        }

        Spacer(modifier = Modifier.height(spacing.xSmall))
    }
}

@Preview(showBackground = true)
@Composable
private fun CreditCardItemPreview() {
    DragonFlyTheme {
        CreditCardItem(
            modifier = Modifier.padding(16.dp)
        )
    }
}

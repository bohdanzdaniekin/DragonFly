package com.mr.nemo.dragonfly.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.mr.nemo.dragonfly.R
import com.mr.nemo.dragonfly.ui.theme.DragonFlyTheme
import com.mr.nemo.dragonfly.ui.utils.extension.nextFloat
import kotlin.random.Random

@Composable
fun AdCard(
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color(0xFFE2D8FF),
    gradientColor: Color = Color(0xFFC5B1FF),
    gradientRectanglesCornerRadius: Dp = 16.dp,
    rectCount: Int = 7,
    content: @Composable (BoxScope.() -> Unit)
) {
    Box(
        modifier = modifier
            .background(
                color = backgroundColor,
                shape = DragonFlyTheme.shapes.small
            )
            .clipToBounds()
            .drawBehind {
                repeat(times = rectCount) {
                    rotate(
                        degrees = -degrees.random()
                    ) {
                        val topLeft = Offset(
                            x = Random.nextFloat(
                                -size.width / 5f,
                                size.width
                            ),
                            y = Random.nextFloat(
                                -size.height / 5f,
                                size.height
                            )
                        )
                        val rectSize = Size(
                            width = size.width / heights.random() - topLeft.x,
                            height = size.height / widths.random() - topLeft.y
                        )
                        drawRoundRect(
                            brush = Brush.linearGradient(
                                0.0f to Color.Transparent,
                                1.0f to gradientColor,
                                tileMode = TileMode.Decal
                            ),
                            topLeft = topLeft,
                            size = rectSize,
                            cornerRadius = CornerRadius(
                                gradientRectanglesCornerRadius.toPx(),
                                gradientRectanglesCornerRadius.toPx()
                            )
                        )
                    }
                }
            },
        content = content
    )
}

private val degrees = listOf<Float>(
    45f, 135f, 225f, 315f
)

private val heights = listOf(
    2f, 3f, 4f, 5f
)

private val widths = listOf(
    2f, 3f
)

@Preview(showBackground = true)
@Composable
private fun AdCardPreview() {
    DragonFlyTheme {
        AdCard(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .wrapContentHeight(),
        ) {
            Row(
                modifier = Modifier
                    .height(IntrinsicSize.Max)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Spacer(modifier = Modifier.width(DragonFlyTheme.spacing.large))

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .wrapContentSize(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Spacer(modifier = Modifier.height(DragonFlyTheme.spacing.large))

                    Text(
                        text = "Let's connect",
                        style = DragonFlyTheme.typography.subtitle1.medium,
                        color = DragonFlyTheme.colors.secondary.main
                    )

                    Spacer(modifier = Modifier.height(DragonFlyTheme.spacing.medium))

                    Text(
                        text = "Connect account with marketplace for automatic payment and get \$25 bonus",
                        style = DragonFlyTheme.typography.text2.regular,
                        color = DragonFlyTheme.colors.neutral5
                    )

                    Spacer(modifier = Modifier.height(DragonFlyTheme.spacing.large))
                }

                Column(
                    modifier = Modifier
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.End
                ) {
                    IconButton(
                        onClick = { /*TODO*/ }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_close_square),
                            contentDescription = "Close Ad"
                        )
                    }

                    IconButton(
                        onClick = { /*TODO*/ }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_arrow_forward),
                            contentDescription = "Connect"
                        )
                    }
                }
            }
        }
    }
}

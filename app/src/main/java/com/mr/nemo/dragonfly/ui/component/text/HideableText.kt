package com.mr.nemo.dragonfly.ui.component.text

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.mr.nemo.dragonfly.R
import com.mr.nemo.dragonfly.ui.theme.DragonFlyTheme

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun HideableText(
    text: String,
    maskChar: Char,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = DragonFlyTheme.typography.text1.regular,
    textColor: Color = DragonFlyTheme.colors.neutral2,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.SpaceBetween,
    verticalAlignment: Alignment.Vertical = Alignment.CenterVertically
) {
    Row(
        modifier = modifier,
        horizontalArrangement = horizontalArrangement,
        verticalAlignment = verticalAlignment
    ) {
        var isVisible by rememberSaveable {
            mutableStateOf(true)
        }
        val textInternal = if (isVisible) {
            text
        } else {
            text
                .map { char -> if (char.isDigit()) maskChar else char }
                .joinToString("")
        }

        AnimatedContent(
            targetState = textInternal,
            label = "",
            transitionSpec = {
                fadeIn() togetherWith fadeOut()
            }
        ) { targetText ->
            Text(
                text = targetText,
                style = textStyle,
                color = textColor
            )
        }

        IconButton(onClick = { isVisible = !isVisible }) {
            Icon(
                imageVector = if (isVisible) {
                    Icons.Outlined.Visibility
                } else {
                    Icons.Default.VisibilityOff
                },
                contentDescription = if (isVisible) {
                    stringResource(R.string.content_description_hide)
                } else {
                    stringResource(R.string.content_description_show)
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HideableTextPreview() {
    DragonFlyTheme {
        HideableText(
            text = "\$ 49,250.00",
            maskChar = '*'
        )
    }
}

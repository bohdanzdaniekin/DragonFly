package com.mr.nemo.dragonfly.ui.component.text

import androidx.annotation.StringRes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.mr.nemo.dragonfly.ui.theme.DragonFlyTheme

@Composable
fun TitleText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = DragonFlyTheme.colors.neutral2,
    textAlign: TextAlign? = null,
    style: TextStyle = DragonFlyTheme.typography.header2.medium
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        textAlign = textAlign,
        style = style
    )
}

@Composable
fun TitleText(
    @StringRes text: Int,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    textAlign: TextAlign? = null,
    style: TextStyle = DragonFlyTheme.typography.header2.medium
) {
    TitleText(
        text = stringResource(id = text),
        modifier = modifier,
        color = color,
        textAlign = textAlign,
        style = style
    )
}

@Preview(showBackground = true)
@Composable
private fun TitleTextPreview() {
    DragonFlyTheme {
        TitleText(text = "Preview")
    }
}

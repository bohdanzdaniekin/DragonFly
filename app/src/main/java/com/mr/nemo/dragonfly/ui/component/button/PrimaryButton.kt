package com.mr.nemo.dragonfly.ui.component.button

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mr.nemo.dragonfly.ui.theme.DragonFlyTheme

@Composable
fun PrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = DragonFlyTheme.shapes.extraSmall,
) {
    val colors = DragonFlyTheme.colors
    val typography = DragonFlyTheme.typography
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = shape,
        colors = ButtonDefaults.buttonColors(
            containerColor = colors.primary.main,
            contentColor = colors.neutral8,
            disabledContainerColor = colors.neutral7,
            disabledContentColor = colors.neutral5
        )
    ) {
        val textColor = if (enabled) {
            colors.neutral8
        } else {
            colors.neutral5
        }
        Text(
            text = text,
            color = textColor,
            style = typography.button
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PrimaryButtonPreview() {
    DragonFlyTheme {
        PrimaryButton(
            text = "Next",
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .requiredHeight(56.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PrimaryButtonPreviewDisable() {
    DragonFlyTheme {
        PrimaryButton(
            text = "Next",
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .requiredHeight(56.dp),
            enabled = false
        )
    }
}

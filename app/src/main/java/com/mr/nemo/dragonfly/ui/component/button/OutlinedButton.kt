package com.mr.nemo.dragonfly.ui.component.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mr.nemo.dragonfly.R
import com.mr.nemo.dragonfly.ui.theme.DragonFlyTheme
import androidx.compose.material3.OutlinedButton as MaterialOutlinedButton

@Composable
fun OutlinedButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = DragonFlyTheme.shapes.extraSmall,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null
) {
    val colors = DragonFlyTheme.colors
    val typography = DragonFlyTheme.typography
    MaterialOutlinedButton(
        onClick = onClick,
        modifier = modifier,
        shape = shape,
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = colors.neutral8,
            contentColor = colors.neutral2
        ),
        border = BorderStroke(1.dp, colors.neutral7)
    ) {
        leadingIcon?.invoke()
        Text(
            text = text,
            color = colors.neutral2,
            style = typography.button
        )
        trailingIcon?.invoke()
    }
}

@Preview(showBackground = true)
@Composable
private fun OutlinedButtonPreview() {
    DragonFlyTheme {
        OutlinedButton(
            text = "Login",
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .requiredHeight(56.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun OutlinedButtonPreviewLeadingIcon() {
    DragonFlyTheme {
        OutlinedButton(
            text = "Login",
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .requiredHeight(56.dp),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_logo),
                    contentDescription = null
                )
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun OutlinedButtonPreviewTrailingIcon() {
    DragonFlyTheme {
        OutlinedButton(
            text = "Login",
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .requiredHeight(56.dp),
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_logo),
                    contentDescription = null
                )
            }
        )
    }
}

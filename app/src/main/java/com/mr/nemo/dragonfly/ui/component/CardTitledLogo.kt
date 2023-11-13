package com.mr.nemo.dragonfly.ui.component

import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.mr.nemo.dragonfly.R
import com.mr.nemo.dragonfly.ui.theme.DragonFlyTheme

@Composable
fun CardTitledLogo(
    modifier: Modifier = Modifier,
    color: Color = DragonFlyTheme.colors.neutral8
) {
    Row(
        modifier = modifier
            .height(IntrinsicSize.Min),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(id = R.string.app_name_title).uppercase(),
            style = DragonFlyTheme.typography.subtitle2.bold,
            color = color,
            fontSize = 12.sp,
            lineHeight = 14.sp,
            minLines = 2,
            maxLines = 2,
            modifier = Modifier,
            textAlign = TextAlign.End
        )

        Spacer(modifier = Modifier.width(DragonFlyTheme.spacing.xxSmall))

        Divider(
            modifier = Modifier
                .width(DividerDefaults.Thickness)
                .fillMaxHeight()
                .padding(vertical = DragonFlyTheme.spacing.xxxSmall),
            color = color
        )

        Spacer(modifier = Modifier.width(DragonFlyTheme.spacing.xxSmall))

        Icon(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = stringResource(id = R.string.app_name_title),
            tint = color
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF272727)
@Composable
private fun CardTitledLogoPreview() {
    DragonFlyTheme {
        CardTitledLogo(
            modifier = Modifier
        )
    }
}

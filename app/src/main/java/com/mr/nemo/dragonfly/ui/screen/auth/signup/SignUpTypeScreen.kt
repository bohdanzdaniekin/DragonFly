package com.mr.nemo.dragonfly.ui.screen.auth.signup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mr.nemo.dragonfly.R
import com.mr.nemo.dragonfly.ui.component.appbar.UntitledTopAppBar
import com.mr.nemo.dragonfly.ui.component.button.OutlinedButton
import com.mr.nemo.dragonfly.ui.component.button.PrimaryButton
import com.mr.nemo.dragonfly.ui.component.text.TitleText
import com.mr.nemo.dragonfly.ui.theme.DragonFlyTheme

@Composable
fun SignUpTypeScreen(
    modifier: Modifier = Modifier
) {
    val spacing = DragonFlyTheme.spacing
    val typography = DragonFlyTheme.typography
    val colors = DragonFlyTheme.colors
    Scaffold(
        topBar = {
            UntitledTopAppBar(
                onLanguageClicked = { /*TODO*/ },
                onLogoClicked = { /*TODO*/ }
            )
        },
        containerColor = colors.neutral8,
        modifier = modifier
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = spacing.medium)
            ) {
            Spacer(modifier = Modifier.height(spacing.medium))

            TitleText(text = R.string.register)

            Spacer(modifier = Modifier.height(spacing.medium))

            Text(
                text = stringResource(id = R.string.register_subtitle),
                style = typography.text2.regular
            )

            Spacer(modifier = Modifier.height(spacing.xLarge))

            OutlinedButton(
                text = stringResource(R.string.button_register_with_gmail),
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .requiredHeight(56.dp),
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_google),
                        contentDescription = stringResource(R.string.button_register_with_gmail),
                        modifier = Modifier.padding(end = spacing.xSmall),
                        tint = Color.Unspecified
                    )
                }
            )

            Spacer(modifier = Modifier.height(spacing.medium))

            Text(
                text = stringResource(R.string.other),
                style = typography.text1.regular,
                color = colors.neutral2,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(spacing.medium))

            PrimaryButton(
                text = stringResource(R.string.button_register_with_email),
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .requiredHeight(56.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SignUpTypeScreenPreview() {
    DragonFlyTheme {
        SignUpTypeScreen()
    }
}

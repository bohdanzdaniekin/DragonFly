package com.mr.nemo.dragonfly.ui.screen.auth.signin

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mr.nemo.dragonfly.R
import com.mr.nemo.dragonfly.ui.component.UntitledTopAppBar
import com.mr.nemo.dragonfly.ui.component.button.Checkbox
import com.mr.nemo.dragonfly.ui.component.button.OutlinedButton
import com.mr.nemo.dragonfly.ui.component.button.PrimaryButton
import com.mr.nemo.dragonfly.ui.component.text.TitleText
import com.mr.nemo.dragonfly.ui.component.textfield.BaseTextField
import com.mr.nemo.dragonfly.ui.component.textfield.PasswordTextField
import com.mr.nemo.dragonfly.ui.theme.DragonFlyTheme

@Composable
fun SignInScreen(
    email: String,
    onEmailChanged: (String) -> Unit,
    password: String,
    onPasswordChanged: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val spacing = DragonFlyTheme.spacing
    val typography = DragonFlyTheme.typography
    val colors = DragonFlyTheme.colors
    Scaffold(
        topBar = {
            UntitledTopAppBar(
                onLanguageClicked = { /*TODO*/ },
                onLogoClicked = { /*TODO*/ },
                modifier = Modifier.padding(horizontal = spacing.medium)
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
            TitleText(
                text = stringResource(R.string.welcome),
                style = typography.header1.regular,
                color = colors.neutral2
            )

            Spacer(modifier = Modifier.height(spacing.medium))

            Text(
                text = stringResource(R.string.sign_in_subtitle),
                style = typography.text2.regular,
                color = colors.neutral4
            )

            Spacer(modifier = Modifier.height(spacing.xLarge))

            BaseTextField(
                value = email,
                onValueChange = onEmailChanged,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(72.dp),
                placeholder = stringResource(R.string.hint_email_username)
            )

            Spacer(modifier = Modifier.height(spacing.medium))

            PasswordTextField(
                password = password,
                onPasswordValueChange = onPasswordChanged,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(72.dp)
            )

            Spacer(modifier = Modifier.height(spacing.medium))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        isChecked = false,
                        onCheckedChange = {},
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(spacing.xSmall))
                    Text(
                        text = "Remember me",
                        style = typography.text2.regular,
                        color = colors.neutral2
                    )
                }

                TextButton(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.textButtonColors(
                        contentColor = colors.neutral2
                    )
                ) {
                    Text(
                        text = stringResource(R.string.button_forgot_password),
                        style = typography.text2.regular
                    )
                }
            }

            Spacer(modifier = Modifier.height(spacing.xLarge))

            PrimaryButton(
                text = stringResource(R.string.button_login),
                onClick = { /*TODO*/ }
            )

            Spacer(modifier = Modifier.height(spacing.medium))

            Text(
                text = stringResource(R.string.other),
                style = typography.text1.regular,
                color = colors.neutral2,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(spacing.medium))

            OutlinedButton(
                text = stringResource(R.string.button_login_with_gmail),
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .requiredHeight(56.dp),
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_google),
                        contentDescription = stringResource(R.string.button_login_with_gmail),
                        modifier = Modifier.padding(end = spacing.xSmall),
                        tint = Color.Unspecified
                    )
                }
            )

            Spacer(modifier = Modifier.height(spacing.medium))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = stringResource(R.string.register_part_first),
                    style = typography.text1.regular,
                    color = colors.neutral2
                )
                Text(
                    text = stringResource(R.string.register),
                    style = typography.text1.regular,
                    color = colors.primary.main
                )
            }

            Spacer(modifier = Modifier.height(spacing.large))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignInScreenPreview() {
    DragonFlyTheme {
        SignInScreen(
            email = "",
            onEmailChanged = {},
            password = "",
            onPasswordChanged = {}
        )
    }
}

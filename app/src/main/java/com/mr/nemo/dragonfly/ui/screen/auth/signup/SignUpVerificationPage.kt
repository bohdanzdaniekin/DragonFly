package com.mr.nemo.dragonfly.ui.screen.auth.signup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mr.nemo.dragonfly.R
import com.mr.nemo.dragonfly.domain.entity.auth.signup.PhoneValue
import com.mr.nemo.dragonfly.ui.component.securitycode.SecurityCode
import com.mr.nemo.dragonfly.ui.component.securitycode.SecurityCodeState
import com.mr.nemo.dragonfly.ui.entitiy.signup.SignUpVerificationPageEvent
import com.mr.nemo.dragonfly.ui.entitiy.signup.SignUpVerificationPageState
import com.mr.nemo.dragonfly.ui.theme.DragonFlyTheme

@Composable
fun SignUpVerificationPage(
    state: SignUpVerificationPageState,
    onEvent: (event: SignUpVerificationPageEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    val spacing = DragonFlyTheme.spacing
    val typography = DragonFlyTheme.typography
    val colors = DragonFlyTheme.colors
    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_messages),
            contentDescription = stringResource(id = R.string.content_description_verification),
            tint = colors.primary.main
        )

        Spacer(modifier = Modifier.height(spacing.large))

        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = colors.neutral2)) {
                    append(stringResource(R.string.title_verification))
                }
                withStyle(SpanStyle(color = colors.primary.main)) {
                    append(state.phone.fullNumber)
                }
            },
            style = typography.text2.regular,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(spacing.xLarge))

        SecurityCode(
            state = state.securityCode,
            onStateChanged = { code ->
                onEvent(SignUpVerificationPageEvent.OnSecurityCodeUpdate(code))
            }
        )

        Spacer(modifier = Modifier.height(spacing.xLarge))

        Text(
            text = stringResource(
                id = R.string.template_times_minutes,
                state.timer.minutes,
                state.timer.seconds
            ),
            style = typography.text1.regular,
            color = colors.neutral2
        )

        if (state.timer.totalSeconds == 0L) {
            Spacer(modifier = Modifier.height(spacing.medium))

            IconButton(
                onClick = {
                    onEvent(SignUpVerificationPageEvent.OnRefreshClicked)
                }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_refresh),
                    contentDescription = stringResource(id = R.string.content_description_resend_code),
                    tint = colors.primary.main
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SignUpVerificationPagePreview() {
    DragonFlyTheme {
        SignUpVerificationPage(
            state = SignUpVerificationPageState(
                phone = PhoneValue(
                    code = "+62",
                    number = "855 - 9729 - 8172"
                ),
                securityCode = SecurityCodeState(
                    firstDigit = "3"
                ),
                timer = SignUpVerificationPageState.Timer(0, 0)
            ),
            onEvent = {},
            modifier = Modifier.padding(horizontal = 72.dp)
        )
    }
}

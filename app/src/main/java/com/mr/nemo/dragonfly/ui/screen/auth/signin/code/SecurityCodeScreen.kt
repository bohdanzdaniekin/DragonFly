package com.mr.nemo.dragonfly.ui.screen.auth.signin.code

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.mr.nemo.dragonfly.R
import com.mr.nemo.dragonfly.ui.component.securitycode.SecurityCode
import com.mr.nemo.dragonfly.ui.component.securitycode.SecurityCodeState
import com.mr.nemo.dragonfly.ui.theme.DragonFlyTheme

@Composable
fun SecurityCodeScreen(
    state: SecurityCodeState,
    onStateChanged: (SecurityCodeState) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize()
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            val spacing = DragonFlyTheme.spacing
            val typography = DragonFlyTheme.typography
            val colors = DragonFlyTheme.colors

            Image(
                painter = painterResource(id = R.drawable.ic_lock),
                contentDescription = null
            )

            Spacer(modifier = Modifier.height(spacing.xLarge))

            Text(
                text = stringResource(R.string.enter_security_code),
                style = typography.subtitle2.regular,
                color = colors.neutral2
            )

            Spacer(modifier = Modifier.height(spacing.medium))

            SecurityCode(state = state, onStateChanged = onStateChanged)

            Spacer(modifier = Modifier.height(spacing.medium))
        }
    }
}

@Preview
@Composable
private fun SecurityCodeScreenPreview() {
    DragonFlyTheme {
        SecurityCodeScreen(
            state = SecurityCodeState("1"),
            onStateChanged = {}
        )
    }
}

package com.mr.nemo.dragonfly.ui.screen.auth.signup

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mr.nemo.dragonfly.R
import com.mr.nemo.dragonfly.domain.entity.auth.signup.SignUpPageContent
import com.mr.nemo.dragonfly.ui.component.appbar.TitledTopAppBar
import com.mr.nemo.dragonfly.ui.component.button.PrimaryButton
import com.mr.nemo.dragonfly.ui.entitiy.signup.SignUpScreenEvent
import com.mr.nemo.dragonfly.ui.entitiy.signup.SignUpScreenState
import com.mr.nemo.dragonfly.ui.theme.DragonFlyTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun SignUpScreen(
    viewModel: SignUpViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    SignUpScreen(
        state = state,
        onEvent = viewModel::onEvent
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SignUpScreen(
    state: SignUpScreenState,
    onEvent: (SignUpScreenEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    val spacing = DragonFlyTheme.spacing
    val typography = DragonFlyTheme.typography
    val colors = DragonFlyTheme.colors

    val page = state.pages[state.currentPage]

    Scaffold(
        modifier = modifier,
        topBar = {
            Column {
                TitledTopAppBar(
                    title = page.title,
                    navigationIcon = {
                        IconButton(onClick = { onEvent(SignUpScreenEvent.OnBackClicked) }) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_arrow_back),
                                contentDescription = stringResource(id = R.string.content_description_navigate_back)
                            )
                        }
                    },
                    actions = {
                        IconButton(onClick = { onEvent(SignUpScreenEvent.OnInfoClicked) }) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_info),
                                contentDescription = stringResource(id = R.string.content_description_sign_up_faq),
                                tint = Color.Unspecified
                            )
                        }
                    }
                )
            }
        },
        containerColor = colors.neutral8
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
        ) {
            AnimatedVisibility(visible = page.isProgressVisible) {
                LinearProgressIndicator(
                    progress = state.progress,
                    modifier = Modifier
                        .fillMaxWidth()
                        .requiredHeight(8.dp),
                    color = colors.primary.main,
                    trackColor = colors.neutral7,
                    strokeCap = StrokeCap.Square
                )
            }

            Spacer(modifier = Modifier.height(spacing.medium))

            Column(
                modifier = Modifier
                    .padding(horizontal = spacing.medium)
            ) {

                HorizontalPager(
                    state = rememberPagerState {
                        state.pages.size
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    verticalAlignment = Alignment.Top,
                    userScrollEnabled = false
                ) { page ->
                    when (val currentPage = state.pages[page]) {
                        is SignUpPageContent.RegisterPageContent<*> -> {
                            SignUpFieldPage(
                                field = currentPage.field,
                                onValueChanged = { field ->
                                    onEvent(
                                        SignUpScreenEvent.OnFieldUpdated(field)
                                    )
                                }
                            )
                        }
                        is SignUpPageContent.VerificationPageContent -> {
                            SignUpVerificationPage(
                                state = currentPage.state,
                                onEvent = onEvent
                            )
                        }
                    }
                }

                PrimaryButton(
                    text = stringResource(id = R.string.button_next),
                    onClick = {
                        onEvent(SignUpScreenEvent.OnNextClicked)
                    },
                    enabled = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .requiredHeight(56.dp)
                )

                Spacer(modifier = Modifier.height(spacing.large))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SignUpScreenPreview() {
    DragonFlyTheme {
        val currentPage = 1
        val steps = signUpSteps(false)
        SignUpScreen(
            state = SignUpScreenState(
                currentPage = currentPage,
                pages = steps,
                progress = (currentPage.toFloat() + 1f) / steps.size
            ),
            onEvent = {}
        )
    }
}

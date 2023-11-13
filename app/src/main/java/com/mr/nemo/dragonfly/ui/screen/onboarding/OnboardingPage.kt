package com.mr.nemo.dragonfly.ui.screen.onboarding

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animate
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.boundsInWindow
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.mr.nemo.dragonfly.R
import com.mr.nemo.dragonfly.domain.entity.OnboardingContent
import com.mr.nemo.dragonfly.ui.component.button.PrimaryButton
import com.mr.nemo.dragonfly.ui.component.text.TitleText
import com.mr.nemo.dragonfly.ui.preview.OnboardingPagePreviewParameterProvider
import com.mr.nemo.dragonfly.ui.theme.DragonFlyTheme
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

@Composable
fun OnboardingPage(
    content: OnboardingContent,
    pageCount: Int,
    currentPage: Int,
    onNextClicked: () -> Unit,
    onBackClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    val typography = DragonFlyTheme.typography
    val colors = DragonFlyTheme.colors
    val spacing = DragonFlyTheme.spacing

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(spacing.xLarge))

        Image(
            painter = painterResource(id = content.image),
            contentDescription = null,
            modifier = Modifier
                .weight(0.6f)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(spacing.large))

        Column(
            modifier = Modifier
                .padding(horizontal = spacing.medium),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            TitleText(
                text = content.title,
                color = colors.neutral2,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(spacing.medium))

            Text(
                text = content.description,
                style = typography.text2.regular,
                color = colors.neutral4,
                textAlign = TextAlign.Center
            )

            var topLimitY by remember {
                mutableFloatStateOf(Float.NaN)
            }

            var bottomLimitY by remember {
                mutableFloatStateOf(Float.NaN)
            }
            val maxOffset = if (bottomLimitY.isNaN() || topLimitY.isNaN()) {
                0f
            } else {
                bottomLimitY - topLimitY
            }

            AnimatedVisibility(visible = content.hasMore) {
                var offsetY by remember {
                    mutableFloatStateOf(0f)
                }
                val draggableState = rememberDraggableState { delta ->
                    offsetY = (offsetY + delta).coerceIn(0f, maxOffset)
                }
                Column(
                    modifier = Modifier
                        .draggable(
                            state = draggableState,
                            orientation = Orientation.Vertical,
                            onDragStopped = { velocity ->
                                launch {
                                    animate(
                                        initialValue = offsetY,
                                        targetValue = 0f,
                                        initialVelocity = velocity,
                                        animationSpec = tween()
                                    ) { value, _ ->
                                        offsetY = value
                                    }
                                }
                            }
                        ),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(spacing.xLarge))

                    Text(
                        text = stringResource(R.string.swipe_for_more),
                        style = typography.text1.medium,
                        color = colors.neutral2,
                        modifier = Modifier
                            .onGloballyPositioned { coordinates ->
                                topLimitY = coordinates.boundsInWindow().bottom
                            }
                    )
                    Spacer(modifier = Modifier.height(spacing.xSmall))
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = stringResource(R.string.content_description_swipe_down_for_more),
                        tint = colors.primary.main,
                        modifier = Modifier.offset {
                            IntOffset(
                                x = 0,
                                y = offsetY.roundToInt()
                            )
                        }
                    )
                }
            }

            Spacer(modifier = Modifier.height(spacing.xLarge))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .onGloballyPositioned { coordinates ->
                        bottomLimitY = coordinates.boundsInWindow().top
                    },
                verticalAlignment = Alignment.CenterVertically
            ) {
                val buttonText by remember {
                    derivedStateOf {
                        if (currentPage == pageCount - 1) {
                            R.string.button_get_started
                        } else {
                            R.string.button_next
                        }
                    }
                }
                val isBackVisible by remember {
                    derivedStateOf { currentPage > 0 }
                }
                if (isBackVisible) {
                    IconButton(onClick = onBackClicked) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = null
                        )
                    }
                }
                PrimaryButton(
                    text = stringResource(id = buttonText),
                    onClick = onNextClicked,
                    modifier = Modifier
                        .fillMaxWidth()
                        .requiredHeight(56.dp)
                )
            }

            Spacer(modifier = Modifier.height(spacing.large))
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun OnboardingPagePreview(
    @PreviewParameter(OnboardingPagePreviewParameterProvider::class)
    content: OnboardingContent
) {
    DragonFlyTheme {
        OnboardingPage(
            content = content,
            pageCount = 2,
            currentPage = 1,
            onNextClicked = {},
            onBackClicked = {},
            modifier = Modifier.fillMaxSize()
        )
    }
}

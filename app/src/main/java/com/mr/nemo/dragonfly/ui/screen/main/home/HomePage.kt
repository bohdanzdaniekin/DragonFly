package com.mr.nemo.dragonfly.ui.screen.main.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mr.nemo.dragonfly.R
import com.mr.nemo.dragonfly.ui.component.AdCard
import com.mr.nemo.dragonfly.ui.component.TableCell
import com.mr.nemo.dragonfly.ui.component.text.HideableText
import com.mr.nemo.dragonfly.ui.theme.DragonFlyTheme
import com.mr.nemo.dragonfly.ui.theme.shapes
import com.mr.nemo.dragonfly.ui.utils.extension.format

@Composable
fun HomePage(
    isAdVisible: Boolean,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    val spacing = DragonFlyTheme.spacing
    val typography = DragonFlyTheme.typography
    val colors = DragonFlyTheme.colors
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier
            .padding(horizontal = spacing.medium),
        contentPadding = contentPadding,
        horizontalArrangement = Arrangement.spacedBy(spacing.xSmall),
        verticalArrangement = Arrangement.spacedBy(spacing.xSmall)
    ) {
        item(
            span = { GridItemSpan(2) }
        ) {
            HomePageHeader(isAdVisible)
        }

        itemsIndexed(
            items = (0..3).toList(),
        ) { index, item ->
            CreditCardItem() // TODO
        }
        item(
            span = { GridItemSpan(2) }
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                TextButton(onClick = { /*TODO*/ }) {
                    Text(
                        text = stringResource(R.string.button_view_more),
                        style = typography.text2.medium,
                        color = colors.primary.main
                    )
                }
            }
        }

        item(
            span = { GridItemSpan(2) }
        ) {
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_currency),
                        contentDescription = stringResource(R.string.content_description_currency),
                        tint = colors.primary.main
                    )

                    Spacer(modifier = Modifier.width(spacing.xSmall))

                    Text(
                        text = stringResource(R.string.currency),
                        style = typography.subtitle2.medium,
                        color = colors.neutral2
                    )
                }

                Spacer(modifier = Modifier.height(spacing.medium))

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            width = 1.dp,
                            color = colors.neutral7,
                            shape = shapes.small
                        )
                        .padding(vertical = spacing.small)
                ) {
                    Row {
                        TableCell(
                            text = "Currency", // TODO
                            weight = 1f,
                            style = typography.text1.regular,
                            color = colors.neutral2
                        )
                        TableCell(
                            text = "Price", // TODO
                            weight = 1f,
                            style = typography.text1.regular,
                            color = colors.neutral2
                        )
                        TableCell(
                            text = "Rates", // TODO
                            weight = 1f,
                            style = typography.text1.regular,
                            color = colors.neutral2
                        )
                    }
                    currencies.forEach { currency ->
                        Row(
                            Modifier.padding(top = spacing.small)
                        ) {
                            TableCell(
                                text = currency.name,
                                weight = 1f
                            )
                            TableCell(
                                text = currency.price.format(2),
                                weight = 1f
                            )
                            TableCell(
                                text = currency.rates.format(2),
                                weight = 1f
                            )
                        }
                    }

                    TextButton(
                        onClick = { /*TODO Refresh*/ },
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    ) {
                        Text(
                            text = "Updated 1 hour ago", // TODO
                            style = typography.text2.regular,
                            color = colors.primary.main
                        )
                    }
                }

                Spacer(modifier = Modifier.height(spacing.medium))
            }
        }
    }
}

@Composable
private fun HomePageHeader(
    isAdVisible: Boolean
) {
    val spacing = DragonFlyTheme.spacing
    val typography = DragonFlyTheme.typography
    val colors = DragonFlyTheme.colors
    Column {
        Spacer(modifier = Modifier.height(spacing.medium))

        Balance(
            balance = "\$ 49,250.00" // TODO
        )

        Spacer(modifier = Modifier.height(spacing.medium))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = colors.neutral7,
                    shape = shapes.small
                )
                .padding(vertical = spacing.small),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            MoneyOperationItem(
                text = stringResource(R.string.send),
                icon = painterResource(id = R.drawable.ic_money_send),
                onClick = { /*TODO*/ }
            )
            MoneyOperationItem(
                text = stringResource(R.string.request),
                icon = painterResource(id = R.drawable.ic_money_request),
                onClick = { /*TODO*/ }
            )
            MoneyOperationItem(
                text = stringResource(id = R.string.history),
                icon = painterResource(id = R.drawable.ic_money_history),
                onClick = { /*TODO*/ }
            )
        }

        Spacer(modifier = Modifier.height(spacing.medium))

        AnimatedVisibility(visible = isAdVisible) {
            AdBanner(
                title = "Let's connect", // TODO
                description = "Connect account with marketplace for automatic payment and get \$25 bonus", // TODO
                onClose = { /*TODO*/ },
                onNavigateForward = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            )
        }

        Spacer(modifier = Modifier.height(spacing.medium))

        MyPocket(
            onCreate = { /*TODO*/ }
        )
    }
}

@Composable
private fun MyPocket(
    onCreate: () -> Unit,
    modifier: Modifier = Modifier
) {
    val spacing = DragonFlyTheme.spacing
    val typography = DragonFlyTheme.typography
    val colors = DragonFlyTheme.colors
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_wallet),
                contentDescription = stringResource(R.string.content_description_my_pocket),
                modifier = Modifier.padding(spacing.xSmall),
                tint = colors.primary.main
            )
            Text(
                text = stringResource(R.string.my_pocket),
                style = typography.subtitle2.medium,
                color = colors.neutral2
            )
        }

        TextButton(onClick = onCreate) {
            Text(
                text = stringResource(R.string.button_create),
                style = typography.text2.medium,
                color = colors.primary.main
            )
        }
    }
}

@Composable
private fun AdBanner(
    title: String,
    description: String,
    onClose: () -> Unit,
    onNavigateForward: () -> Unit,
    modifier: Modifier = Modifier
) {
    val spacing = DragonFlyTheme.spacing
    val typography = DragonFlyTheme.typography
    val colors = DragonFlyTheme.colors
    AdCard(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .height(IntrinsicSize.Max)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Spacer(modifier = Modifier.width(spacing.large))

            Column(
                modifier = Modifier
                    .weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                Spacer(modifier = Modifier.height(spacing.large))

                Text(
                    text = title,
                    style = typography.subtitle1.medium,
                    color = colors.secondary.main
                )

                Spacer(modifier = Modifier.height(spacing.medium))

                Text(
                    text = description,
                    style = typography.text2.regular,
                    color = colors.neutral5
                )

                Spacer(modifier = Modifier.height(DragonFlyTheme.spacing.large))
            }

            Column(
                modifier = Modifier
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.End
            ) {
                IconButton(
                    onClick = onClose
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_close_square),
                        contentDescription = stringResource(R.string.content_description_close_ad)
                    )
                }

                IconButton(
                    onClick = onNavigateForward
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_forward),
                        contentDescription = stringResource(id = R.string.content_description_navigate_forward)
                    )
                }
            }
        }
    }
}

@Composable
private fun Balance(
    balance: String,
    modifier: Modifier = Modifier,
    maskChar: Char = '*'
) {
    val spacing = DragonFlyTheme.spacing
    val typography = DragonFlyTheme.typography
    val colors = DragonFlyTheme.colors
    Column(
        modifier = modifier
    ) {
        Text(
            text = stringResource(R.string.your_balance),
            style = typography.text2.regular,
            color = colors.neutral5
        )

        Spacer(modifier = Modifier.height(spacing.xSmall))

        HideableText(
            text = balance,
            maskChar = maskChar,
            textStyle = typography.header2.regular,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    DragonFlyTheme {
        HomePage(
            isAdVisible = true
        )
    }
}

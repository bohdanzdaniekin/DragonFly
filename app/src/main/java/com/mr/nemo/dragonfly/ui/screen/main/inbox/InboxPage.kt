package com.mr.nemo.dragonfly.ui.screen.main.inbox

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mr.nemo.dragonfly.ui.entitiy.main.inbox.InboxPageTab
import com.mr.nemo.dragonfly.ui.screen.main.inbox.notification.NotificationMessage
import com.mr.nemo.dragonfly.ui.screen.main.inbox.notification.NotificationTab
import com.mr.nemo.dragonfly.ui.theme.DragonFlyTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun InboxPage(
    tabs: List<InboxPageTab>,
    selectedTab: InboxPageTab,
    onTabSelected: (tab: InboxPageTab) -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    pageContent: @Composable (tab: InboxPageTab) -> Unit,
) {
    val typography = DragonFlyTheme.typography
    val colors = DragonFlyTheme.colors
    val spacing = DragonFlyTheme.spacing
    Column(
        modifier = modifier.padding(contentPadding)
    ) {
        val selectedTabIndex = tabs.indexOf(selectedTab)

        val pagerState = rememberPagerState {
            tabs.size
        }

        LaunchedEffect(key1 = selectedTabIndex) {
            pagerState.animateScrollToPage(selectedTabIndex)
        }
        LaunchedEffect(key1 = pagerState.currentPage) {
            onTabSelected(tabs[pagerState.currentPage])
        }


        TabRow(
            selectedTabIndex = selectedTabIndex,
            modifier = Modifier.fillMaxWidth(),
            indicator = { tabPositions ->
                if (selectedTabIndex < tabPositions.size) {
                    TabRowDefaults.Indicator(
                        modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
                        color = colors.primary.main
                    )
                }
            }
        ) {
            tabs.forEachIndexed { index, tab ->
                val isSelected = selectedTabIndex == index
                Tab(
                    selected = isSelected,
                    onClick = {
                        onTabSelected(tab)
                    },
                    selectedContentColor = colors.primary.main,
                    unselectedContentColor = colors.neutral2
                ) {
                    Text(
                        text = tab.title,
                        modifier = Modifier.padding(vertical = spacing.medium),
                        style = typography.text1.regular
                    )
                }
            }
        }
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalAlignment = Alignment.Top
        ) { index ->
            pageContent(tabs[index])
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun InboxPagePreview() {
    DragonFlyTheme {
        val tabs = InboxPageTab.values { tab ->
            when (tab) {
                InboxPageTab.Inbox::class -> {
                    "Inbox"
                }
                InboxPageTab.Notification::class -> {
                    "Notification"
                }
                else -> throw IllegalStateException()
            }
        }
        var selectedTab by remember {
            mutableStateOf(tabs.first())
        }
        InboxPage(
            tabs = tabs,
            selectedTab = selectedTab,
            onTabSelected = { tab ->
                selectedTab = tab
            }
        ) { tab ->
            when (tab) {
                is InboxPageTab.Inbox -> {
                    InboxTab(
                        messages = listOf(
                            InboxMessage(
                                title = "Investment just got easier",
                                subtitle = "Investing in a bank is one of the common and safe choices for beginners " +
                                    "who want to start their investment journey. This article will provide a short guide " +
                                    "to getting started investing in banks, covering some of the investment products " +
                                    "offered by banks and tips for getting started.",
                                icon = Icons.Outlined.Notifications
                            ),
                            InboxMessage(
                                title = "Tips for safe foreign transactions",
                                subtitle = "Choose the Right Transfer Method:\n" +
                                    "There are several transfer methods that can be used, such as bank transfers, " +
                                    "electronic transfers, or using money transfer services such as PayPal or " +
                                    "TransferWise. Make sure to choose the most efficient and economical method " +
                                    "for your needs.\n",
                                icon = Icons.Outlined.Notifications
                            )
                        )
                    )
                }
                is InboxPageTab.Notification -> {
                    NotificationTab(
                        notifications = listOf(
                            NotificationMessage(
                                title = "Free transfer other bank",
                                message = "Enjoy free interbank transfer fees for a full month and many other attractive promos",
                                imageUrl = ""
                            ),
                            NotificationMessage(
                                title = "Pay using a Dragonfly credit card",
                                message = "Enjoy discounts by using a credit card of up to 70% this promo applies only to new users",
                                imageUrl = ""
                            )
                        )
                    )
                }
            }
        }
    }
}

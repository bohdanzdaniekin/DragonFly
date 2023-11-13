package com.mr.nemo.dragonfly.ui.screen.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mr.nemo.dragonfly.R
import com.mr.nemo.dragonfly.ui.component.TitledLogo
import com.mr.nemo.dragonfly.ui.theme.DragonFlyTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    modifier: Modifier = Modifier
) {
    val spacing = DragonFlyTheme.spacing
    val typography = DragonFlyTheme.typography
    val colors = DragonFlyTheme.colors

    val navItems = MainScreenNavigationItem.items()
    var selectedItemIndex by rememberSaveable {
        mutableIntStateOf(0)
    }
    BottomSheetScaffold(
        sheetContent = {

        },
        modifier = modifier,
        scaffoldState = rememberBottomSheetScaffoldState(
            bottomSheetState = rememberStandardBottomSheetState(
                initialValue = SheetValue.Hidden,
                skipHiddenState = false
            )
        )
    ) {
        Scaffold(
            modifier = Modifier,
            topBar = {
                CenterAlignedTopAppBar(
                    title = {},
                    navigationIcon = {
                        TitledLogo(
                            onClick = {

                            }
                        )
                    },
                    actions = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_scan),
                                contentDescription = stringResource(id = R.string.content_description_scan),
                                tint = Color.Unspecified
                            )
                        }
                    }
                )
            },
            bottomBar = {
                NavigationBar(
                    modifier = Modifier
                        .shadow(
                            elevation = 4.dp,
                            spotColor = Color(0x1F000000),
                            ambientColor = Color(0x1F000000)
                        )
                        .padding(top = spacing.xSmall),
                    containerColor = Color.Transparent,
                    contentColor = colors.neutral8,
                    tonalElevation = 4.dp,
                ) {
                    navItems.forEachIndexed { index, item ->
                        val isSelected = selectedItemIndex == index
                        NavigationBarItem(
                            selected = isSelected,
                            onClick = {
                                selectedItemIndex = index
                            },
                            icon = {
                                BadgedBox(badge = {}) {
                                    Icon(
                                        painter = painterResource(id = item.icon),
                                        contentDescription = item.title
                                    )
                                }
                            },
                            label = {
                                Text(
                                    text = item.title,
                                    style = typography.text2.regular,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            },
                            alwaysShowLabel = true,
                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = colors.primary.main,
                                selectedTextColor = colors.primary.main,
                                unselectedIconColor = colors.neutral6,
                                unselectedTextColor = colors.neutral6,
                                indicatorColor = colors.secondary.border
                            )
                        )
                    }
                }
            },
            containerColor = colors.neutral8
        ) { paddingValues ->

        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MainScreenPreview() {
    DragonFlyTheme {
        MainScreen()
    }
}

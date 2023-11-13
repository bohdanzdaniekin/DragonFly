package com.mr.nemo.dragonfly.ui.screen.main

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.mr.nemo.dragonfly.R

data class MainScreenNavigationItem(
    @DrawableRes
    val icon: Int,
    val title: String
) {


    companion object {

        @Composable
        fun items(): List<MainScreenNavigationItem> {
            return listOf(
                MainScreenNavigationItem(
                    icon = R.drawable.ic_home,
                    title = stringResource(id = R.string.home)
                ),
                MainScreenNavigationItem(
                    icon = R.drawable.ic_pocket,
                    title = stringResource(id = R.string.pocket)
                ),
                MainScreenNavigationItem(
                    icon = R.drawable.ic_inbox,
                    title = stringResource(id = R.string.inbox)
                ),
                MainScreenNavigationItem(
                    icon = R.drawable.ic_profile,
                    title = stringResource(id = R.string.profile)
                )
            )
        }
    }
}

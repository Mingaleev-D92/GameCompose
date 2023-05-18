package com.example.gamecompose.ui.screens.base

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.gamecompose.data.common.ResourceNetwork
import com.example.gamecompose.domain.model.Game
import com.example.gamecompose.ui.components.drawer.NavigationDrawer
import com.example.gamecompose.ui.components.drawer.NavigationDrawerItem
import com.example.gamecompose.ui.screens.home.HomeScreen
import com.intuit.sdp.R

/**
 * @author : Mingaleev D
 * @data : 18.05.2023
 */

@Composable
fun Index(scaffoldState: ScaffoldState,
          navController: NavHostController,
          availableGames:ResourceNetwork<List<Game>>,
          onOpenDrawer: () -> Unit,
          onSearchButtonClick: () -> Unit,
          onGameClick: (Int) -> Unit
) {
   Scaffold(scaffoldState = scaffoldState,
            drawerShape = RectangleShape,
            drawerContent = {
               NavigationDrawer(
                   header = {
                      Image(
                          modifier = Modifier.size(size = dimensionResource(id = R.dimen._25sdp)),
                          painter = painterResource(id = com.example.gamecompose.R.drawable.ic_free_to_play_launcher),
                          contentDescription = "",
                          contentScale = ContentScale.FillHeight,
                          alignment = Alignment.Center)
                   },
                   content = {
                      NavigationDrawerItem(modifier = Modifier
                         .requiredHeight(45.dp)
                         .padding(5.dp),
                                           iconPainter = painterResource(id = com.example.gamecompose.R.drawable.ic_bars_staggered_solid),
                                           iconColor = MaterialTheme.colors.primary,
                                           text = stringResource(id = com.example.gamecompose.R.string.lbl_home),
                                           textStyle = MaterialTheme.typography.subtitle1,
                                           textColor = MaterialTheme.colors.onBackground,
                                           onClick = {

                                           })
                      Spacer(modifier = Modifier.padding(8.dp))
                      NavigationDrawerItem(modifier = Modifier
                         .requiredHeight(45.dp)
                         .padding(5.dp),
                                           iconPainter = painterResource(id = com.example.gamecompose.R.drawable.ic_windows_brands),
                                           iconColor = MaterialTheme.colors.primary,
                                           text = stringResource(id = com.example.gamecompose.R.string.lbl_pc_games),
                                           textStyle = MaterialTheme.typography.subtitle1,
                                           textColor = MaterialTheme.colors.onBackground,
                                           onClick = {

                                           })
                      Spacer(modifier = Modifier.padding(8.dp))
                      NavigationDrawerItem(modifier = Modifier
                         .requiredHeight(45.dp)
                         .padding(5.dp),
                                           iconPainter = painterResource(id = com.example.gamecompose.R.drawable.ic_window_maximize_solid),
                                           iconColor = MaterialTheme.colors.primary,
                                           text = stringResource(id = com.example.gamecompose.R.string.lbl_web_games),
                                           textStyle = MaterialTheme.typography.subtitle1,
                                           textColor = MaterialTheme.colors.onBackground,
                                           onClick = {

                                           })
                      Spacer(modifier = Modifier.padding(8.dp))
                      NavigationDrawerItem(modifier = Modifier
                         .requiredHeight(45.dp)
                         .padding(5.dp),
                                           iconPainter = painterResource(id = com.example.gamecompose.R.drawable.ic_arrow_trend_up_solid),
                                           iconColor = MaterialTheme.colors.primary,
                                           text = stringResource(id = com.example.gamecompose.R.string.lbl_latest_games),
                                           textStyle = MaterialTheme.typography.subtitle1,
                                           textColor = MaterialTheme.colors.onBackground,
                                           onClick = {

                                           })
                   }
               )

            }) { innerPadding ->
      NavHost(modifier = Modifier.padding(innerPadding),
              navController = navController,
              startDestination = Screen.HomeScreen.route) {
         composable(route = Screen.HomeScreen.route) {
            HomeScreen(onOpenDrawer = { onOpenDrawer() },
                       onSearchButtonClick = {onSearchButtonClick() },
                       onGameClick = { onGameClick(it) },
                       availableGames = availableGames )
         }
      }
   }
}
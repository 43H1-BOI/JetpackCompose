package com.the43h1.jetpackcompose.U_Navigation

/** How To Navigate
 *      navigation means to move from one screen to another
 *      it can be done using
 *          - navController -> used to give navigation functionality
 *          - NavHost()     -> used to define path of screen where we will navigate to
 *              - composable() fun is used to define keyword and route to screen
 *              - composable(keyword){ screenFun() }
 *          - NavGraph()    -> used to create/store backstack
 *
 *
 *
 * Navigation Can be done using two ways
 *     1 - By Directly Introducing route inside NavHost()
 *          In this method we use
 *          NavHost(navController,
 *              startDestination = "SpecialKeyword"
 *          ){
 *              composable(route = "SpecialKeyword"){
 *                  // Composable Function Call
 *              }
 *          }
 *
 *          /*
 *          Piece of Code Where You'll call These Composable Using
 *
 *          navController.navigate("SpecialKeyword")
 *          -> To Navigate to Destination Page of SpecialKeyword
 *
 *
 *
 *     2 - By Defining a Sealed Class
 *          Which will contain all the keyword of Screens
 *          inside data object of screens
 *
 *      sealed class Screens(val route : String ){
 *          data object HomeScreen : Screens("HomeS") // Keyword for Home Screen
 *          //... And So On ...
 *      }
 *
 *      And Then this reference will be passed as route as in above method
 *          - Screens.HomeScreen.route
 *
 */
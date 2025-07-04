package com.the43h1.jetpackcompose.R_Snack_Bar


/** How To Snackbar :
 *      Create
 *          - Coroutine Scope
 *          - SnackbarHostState
 *          - context (For Toast) (OPTIONAL)
 *
 *      Inside Scaffold use snackbarHost argument
 *      Initialize hostState = SnackbarHostState Created Above
 *      Create a button to get snackbar
 *      Inside onClick{}
 *          - launch coroutineScope
 *          - store result of snackbarHostState.showSnackbar(
 *              message = Main Text on SnackBar,
 *              actionLabel : String? = Text that will be on Action Button  ,
 *              withDismissAction : Unit = what will happen after snackbar is dismissed,
 *              duration : SnackbarDuration = how much time the snackbar will be showing on screen
 *          )
 *
 *          All Set
 */
package com.the43h1.jetpackcompose.E_Modal_Sheet

/**
 * Implementation Bottom Drawer Sheet
 *      Create
 *          - bottomSheetState as mutableStateOf(false)
 *          - sheetState = RememberModalBottomSheetState
 *              (skipPartiallyExpanded = Boolean)
 *                  - true -> Full Screen Drawer
 *                  - false -> Half Screen Drawer
 *
 *           - ModalBottomSheet(
 *              sheetState = sheetState,
 *              onDismissRequest = {
 *                  bottomSheetState = false
 *              }
 *           ){
 *              // Content of Modal Bottom Sheet
 *           }
 *
 */
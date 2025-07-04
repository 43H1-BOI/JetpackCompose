package com.the43h1.jetpackcompose.A_CheezyCode

/** SideEffectNotes
Whenever we use composable function they get called many times (as per jetpack compose requirements)
And if we are changing any kind of information inside composable then it may also get affected
which may lead to some side effects
like
- if add data to database then will create multiple redundant data
- if changing any state and that is being used by other fun then function may misfunction

This Problem can be solved with LaunchedEffect(key)
here the statement will only run when state changes
 */
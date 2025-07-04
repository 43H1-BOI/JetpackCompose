package com.the43h1.jetpackcompose.D_Layout_Composables

/**
# Layout Composables

There Are Mainly 3 Types of Composable Layout Out There

- **Box()** -> To Arrange Items on top of Each Other
- **Row()** -> To Arrange Items next to one another
- **Column()** -> To Arrange Items One Below Another

There are one Extra Layouts with Different Use-case
- **ConstraintLayout()** -> To Arrange Items With Reference to One Other

` We Must implement dependency to use Constraint Layout `

 **All These Layout are good for non recycling view but may create performance issue with recyclable
view (items outside view/screen)**
 *We Can make them scrollable by using Modifiers*

To Solve the problem we use **Lazy Composable Functions**

- **LazyRow()** -> Recyclable Row
- **LazyColumn()** -> Recyclable Column
 */
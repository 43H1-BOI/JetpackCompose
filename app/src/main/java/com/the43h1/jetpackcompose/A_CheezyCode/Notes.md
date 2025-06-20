# Notes from Cheezy Code's Videos

# Video 1 : Basics of Jetpack Compose

	- Jetpack Compose is a Library used to Create Applications
	- It uses concept of Composition and Recomposition
		- Means Function Gets Data and it is Rendered As UI
		- And When any Piece of Data Changes , only that composable recomposes
			- Or we can say will re-render
	- We can also preview composable functions while developing application		
		- means no need to run app each time we make change in our UI

# Video 2 : Basic Composables

	- @Composable Annotation is Used to Define Composable Functions
	- @Preview Annotation is Used to Preview Them on First Place
		- This Saves Resources As Well As Time

## Some Basic Composables

		- Text
		- Image
		- Button
		- TextField

# Video 3 : Modifiers

	- Modifiers are defined in Each Composable Functions
	- They are used to make custom modificatons in any Composable
		- like their appearance , used as , etc.
	- Modifier can be nested
	- Sequence of modifier properties matters alot
		- As it may lead to wrong rendering of UI
		- So Use it Carefully
		
	- We Can Also Create our Own Modifier Properties	
    - It is Referred as Best Practice to add Modifier in Your Composable


# Video 4 : Column Lists

	- We use lazy column / row to make them scrollable
	- Also we Can Use modifier property like 
		- verticalscroll
		- horizontalscroll
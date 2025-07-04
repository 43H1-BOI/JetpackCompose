
# Unified Jetpack Compose Notes

This document provides a comprehensive overview of key concepts and components in Jetpack Compose, compiled from various notes. For practical code examples and further exploration, refer to the [JetpackCompose GitHub repository](https://github.com/43H1-BOI/JetpackCompose).

## 1. Fundamentals of Jetpack Compose

Jetpack Compose is a modern toolkit for building native Android UI. It simplifies and accelerates UI development with a declarative approach.

### 1.1. Core Concepts: Composition and Recomposition

* **Composition:** The process of building your UI by assembling composable functions. Each composable function takes data and renders it as UI.

* **Recomposition:** When any piece of data that a composable function depends on changes, only that specific composable (and its children affected by the data change) will re-render. This makes UI updates efficient.

### 1.2. Composable Functions

* **Definition:** The basic building blocks of UI in Jetpack Compose. They are regular Kotlin functions marked with the `@Composable` annotation.

* **Annotation:** Requires `import androidx.compose.runtime.Composable`.

* **Naming Rules:**

    * MUST be a noun: `DoneButton()`

    * NOT a verb or verb phrase: `DrawTextField()`

    * NOT a nouned preposition: `TextFieldWithLink()`

    * NOT an adjective: `Bright()`

    * NOT an adverb: `Outside()`

    * Nouns MAY be prefixed by descriptive adjectives: `RoundIcon()`

### 1.3. Preview Function

* **Purpose:** Used to preview composable functions directly in the Android Studio editor without needing to run the app on a device or emulator. This saves resources and time during development.

* **Annotation:** Uses `@Preview`.

* **Options:** `showSystemUi = true` can be used to view the composable with system UI elements (e.g., status bar, navigation bar).

### 1.4. State Management

* **Definition:** State refers to mutable variables that, when their value changes, trigger recomposition of the UI that depends on them.

* **Importance:** Proper state management is crucial for building dynamic and responsive UIs.

* **Key State APIs:**

    * `remember`: Used to store an object in composition and remember it across recompositions. It's often used with `mutableStateOf` to create observable state.

        ```kotlin
        val count = remember { mutableStateOf(0) }
        ```

    * `mutableStateOf`: Creates an observable `MutableState` object. When its `value` property changes, composables reading this state will recompose.

        ```kotlin
        var text by remember { mutableStateOf("Hello") } // Using delegate property
        ```

    * `rememberSaveable`: Similar to `remember`, but the stored value survives configuration changes (like screen rotation) and process death. It's essential for preserving UI state.

        ```kotlin
        val score = rememberSaveable { mutableStateOf(0) }
        ```

* **State Hoisting:**

    * A pattern where state is moved up to a common ancestor of all composables that need to read or write to it.

    * This makes composables stateless and reusable, as they only receive state and event callbacks as parameters.

    * **Benefits:** Single source of truth for state, improved testability, and reduced coupling.

### 1.5. Modifiers

* **Purpose:** Defined in each composable function, modifiers are used to customize the appearance, behavior, and layout of any composable.

* **Nesting:** Modifiers can be chained or nested.

* **Sequence Matters:** The order in which modifier properties are applied is crucial, as it can significantly affect the final rendering of the UI. Use them carefully.

* **Best Practice:** It is considered best practice to add a `modifier` parameter to your custom composables to allow for external customization.

* **Tips:**

    * Use `Ctrl + P` to get a list of all available parameters for a composable.

    * Use `Ctrl + Click` on any composable function to view its declaration and usage.

    * Use `Ctrl + Spacebar` to check for available parameters and options.

## 2. Core UI Components

Jetpack Compose provides a set of fundamental UI elements.

### 2.1. Text and Typography

* The `Text()` composable is used to display text.

* **Styling Options:**

    * `text`: The string content to display.

    * `textAlign`: Alignment of the text (e.g., `TextAlign.Center`).

    * `color`: Text color (e.g., `colorResource(R.color.black)`).

    * `fontSize`: Size of the text (e.g., `30.sp`).

    * `fontStyle`: Style of the font (e.g., `FontStyle.Italic`).

    * `fontWeight`: Weight of the font (e.g., `FontWeight.ExtraBold`).

    * `style`: Allows for more advanced styling using `TextStyle`, including shadows:

        ```kotlin
        style = TextStyle(
            shadow = Shadow(
                color = colorResource(R.color.mera_color),
                blurRadius = 6f
            )
        )
        ```

* **Marquee Text:** The `basicMarquee()` modifier can be used to make text scroll horizontally if it overflows.

### 2.2. Image

* The `Image()` composable is used to display images. It commonly takes a `painter` (e.g., `painterResource` for drawables or an image loading library's painter) and a `contentDescription` for accessibility.

### 2.3. Button

* The `Button()` composable is used to create clickable buttons. It typically takes a `content` lambda, allowing you to place other composables like `Text` or `Icon` inside it.

* **Action:** Uses the `onClick = { ... }` function to define the action performed when the button is clicked.

### 2.4. TextField

* The `TextField()` composable is used to create input fields for text entry. Key parameters include `value` (the current text displayed) and `onValueChange` (a callback to update the text when the user types).

### 2.5. Theming

Jetpack Compose uses Material Design by default, which provides a comprehensive system for creating consistent and branded UIs. Theming involves defining your app's colors, typography, and shapes.

* **`MaterialTheme`:** The central composable for applying a Material Design theme to your app. It provides default values for colors, typography, and shapes.

    ```kotlin
    MaterialTheme(
        colors = MyCustomColors, // Define your ColorPalette
        typography = MyCustomTypography, // Define your Typography
        shapes = MyCustomShapes // Define your Shapes
    ) {
        // Your app's UI content
    }
    ```

* **Colors:** Defined using `ColorPalette` (for light and dark themes).

    ```kotlin
    private val DarkColorPalette = darkColors(
        primary = Purple200,
        primaryVariant = Purple700,
        secondary = Teal200
    )

    private val LightColorPalette = lightColors(
        primary = Purple500,
        primaryVariant = Purple700,
        secondary = Teal200
    )
    ```

* **Typography:** Defined using `Typography`, which specifies text styles for different elements (e.g., `h1`, `body1`, `caption`).

    ```kotlin
    val Typography = Typography(
        body1 = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        ),
        h1 = TextStyle(
            fontFamily = FontFamily.Cursive,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )
    )
    ```

* **Shapes:** Defined using `Shapes`, which specifies the corner shapes for different components (e.g., small, medium, large).

    ```kotlin
    val Shapes = Shapes(
        small = RoundedCornerShape(4.dp),
        medium = RoundedCornerShape(8.dp),
        large = RoundedCornerShape(16.dp)
    )
    ```

### 2.6. User Interaction and Gestures

Beyond simple clicks, Compose offers various modifiers for handling user interactions.

* **`clickable`:** Makes a composable respond to clicks.

    ```kotlin
    Text("Click Me", modifier = Modifier.clickable { /* Handle click */ })
    ```

* **`longClickable`:** Makes a composable respond to long presses.

    ```kotlin
    Text("Long Press Me", modifier = Modifier.longClickable { /* Handle long click */ })
    ```

* **`pointerInput`:** A powerful low-level modifier for handling complex touch events and gestures (e.g., drag, swipe, zoom).

    ```kotlin
    // Example for basic drag detection
    var offsetX by remember { mutableStateOf(0f) }
    var offsetY by remember { mutableStateOf(0f) }

    Box(
        modifier = Modifier
            .size(100.dp)
            .offset { IntOffset(offsetX.roundToInt(), offsetY.roundToInt()) }
            .background(Color.Blue)
            .pointerInput(Unit) {
                detectDragGestures { change, dragAmount ->
                    change.consume()
                    offsetX += dragAmount.x
                    offsetY += dragAmount.y
                }
            }
    )
    ```

* **`draggable` / `scrollable`:** Higher-level modifiers for specific drag and scroll behaviors.

## 3. Layout Composables

Layouts are essential for arranging UI elements on the screen.

### 3.1. Basic Layouts (Non-Recycling Views)

These layouts are suitable for a fixed, small number of items. They can become inefficient with many items as they compose all items at once, even those not visible on screen. They can be made scrollable using modifiers.

* **`Box()`:** Arranges items on top of each other (like layers).

* **`Row()`:** Arranges items horizontally, next to one another.

* **`Column()`:** Arranges items vertically, one below another.

### 3.2. `ConstraintLayout()`

* **Purpose:** Arranges items with reference to one another, providing flexible and complex layout capabilities similar to ConstraintLayout in XML.

* **Dependency:** Requires an additional dependency to be implemented in your project (e.g., `androidx.constraintlayout:constraintlayout-compose`).

### 3.3. Lazy Composables (Recycling Views)

To solve performance issues with large lists or dynamic content, Jetpack Compose provides "lazy" composables, which only compose and lay out items that are currently visible on screen (and a small buffer).

* **`LazyRow()`:** A horizontally scrollable list that recycles its content.

* **`LazyColumn()`:** A vertically scrollable list that recycles its content.

## 4. Advanced UI Components and Patterns

### 4.1. Snackbar

A Snackbar provides brief messages about app processes at the bottom of the screen.

* **Implementation Steps:**

    1.  **Create:**

        * `CoroutineScope`: Needed to launch the `showSnackbar` function.

        * `SnackbarHostState`: Manages the state of the Snackbar (showing, dismissing).

        * `Context` (Optional): For showing `Toast` messages alongside the Snackbar.

    2.  **Scaffold Integration:** Use the `snackbarHost` argument within a `Scaffold` composable and initialize `hostState = SnackbarHostState` created above.

    3.  **Trigger:** Create a button or an event to trigger the Snackbar. Inside its `onClick` (or event handler):

        * `launch` the `coroutineScope`.

        * Call `snackbarHostState.showSnackbar()` with parameters:

            * `message`: The main text to display on the Snackbar.

            * `actionLabel` (String?): Text for an optional action button on the Snackbar.

            * `withDismissAction` (Boolean): If `true`, a dismiss action button will be shown.

            * `duration`: `SnackbarDuration` (e.g., `SnackbarDuration.Short`, `SnackbarDuration.Long`, `SnackbarDuration.Indefinite`).

        * The result of `showSnackbar` can be stored to react to user interaction (e.g., if the action button was clicked).

### 4.2. Modal Bottom Sheet

A Modal Bottom Sheet slides up from the bottom of the screen to reveal a set of choices or additional content.

* **Implementation Steps:**

    1.  **Create States:**

        * `bottomSheetState`: A `MutableState<Boolean>` (e.g., `mutableStateOf(false)`) to control the visibility of the sheet.

        * `sheetState`: Use `rememberModalBottomSheetState(skipPartiallyExpanded = Boolean)`.

            * `true`: The sheet will only expand to full screen.

            * `false`: The sheet can expand partially (half screen) and full screen.

    2.  **`ModalBottomSheet` Composable:**

        ```kotlin
        ModalBottomSheet(
            sheetState = sheetState,
            onDismissRequest = {
                // Logic to hide the bottom sheet when dismissed
                bottomSheetState = false
            }
        ) {
            // Content of your Modal Bottom Sheet goes here
            // This can be any composable UI.
        }
        ```

### 4.3. Segmented Button

A segmented button allows users to select one option from a mutually exclusive set.

* **Implementation Steps:**

    1.  **Prepare Data:**

        * Initiate a list containing the state (e.g., `MutableState<Boolean>`) for each button.

        * Create a list for the labels (text or icons) of the items.

    2.  **`MultiButtonSegmentedButton`:** Use a composable like `MultiButtonSegmentedButton` (or similar depending on your library/implementation) and specify its parameters:

        * `label`: What to display on the buttons (icons or text).

        * `icon`: An icon to indicate if the button is checked or not.

        * `onCheckedChange`: A lambda function that defines what happens when a button is clicked (e.g., update its `checked` state and uncheck others).

        * `checked`: The current boolean state of the button (true if selected, false otherwise).

        * `shape`: Defines the shape of the button, especially important for making them look connected:

            * `index`: The position of the current item in the button list.

            * `count`: The total number of elements in the list. Setting `count` to `list.size` typically makes the buttons appear connected, while `1` would make each look individual.

## 5. Architecture and Side Effects

### 5.1. Side Effects

* **Problem:** Composable functions can be called many times by the Jetpack Compose runtime (recomposition). If you perform operations with side effects (e.g., updating a database, making network calls, changing a global state) directly inside a composable, it can lead to redundant operations or misbehavior. For example, adding data to a database directly in a composable might create multiple duplicate entries.

* **Solution: `LaunchedEffect(key)`:**

    * This composable allows you to safely perform side effects that should only run when a specific `key` (state or value) changes.

    * The code inside `LaunchedEffect` will only execute when the `key` changes, preventing redundant calls during recomposition.

### 5.2. MVVM (Model-View-ViewModel) Architecture

MVVM is a popular architectural pattern for building robust and maintainable applications. It promotes a clear separation of concerns.

* **Components:**

    * **Model:** Represents the data layer of the application. This includes data structures, business logic related to data, and data access operations (e.g., from a database or network). Often implemented as data classes.

    * **View:** The UI layer, responsible for displaying information to the user and capturing user input. In Jetpack Compose, this is your composable functions. The View observes changes in the ViewModel.

    * **ViewModel:** Acts as a bridge between the Model and the View. It holds and manages UI-related data in a lifecycle-conscious way, survives configuration changes, and exposes data to the View. It handles UI logic and delegates business logic to the Model or Repository.

    * **Repository:** (Often used with MVVM) A design pattern that acts as a clean API for data access to the rest of the application. It abstracts the data source from the ViewModel.

* **Implementation Overview:**

    1.  **Add ViewModel Dependency:** Include the necessary ViewModel implementation dependency in your `build.gradle` file.

    2.  **Create ViewModel Class:** Create a class that extends `ViewModel()`. Implement your UI logic and state management within this class.

    3.  **Initialize ViewModel:** In your `MainActivity` or top-level composable, create an object of your ViewModel class, typically using `viewModel()` or by manually instantiating it.

    4.  **Pass to UI:** Pass this ViewModel object to your UI composable functions.

    5.  **Data Extraction:** Use the ViewModel object within your composables for data extraction and to trigger actions.

    6.  **Model (Data Class):** Define your data structures as data classes.

    7.  **Repository (Data Source):** Create a Repository class to manage data operations (e.g., fetching from a database, making API calls).

* **Why MVVM?**

    * **Separation of Concerns:** Provides clear separation between UI, business logic, and data, leading to better organization and easier-to-maintain code.

    * **Testability:** Each component (Model, ViewModel, Repository) can be tested independently.

    * **Reusability:** ViewModels are decoupled from the View, meaning the same ViewModel can be used across multiple Views or even different platforms.

    * **Data Binding:** Allows for automatic updates between the ViewModel and Views, simplifying UI synchronization.

    * **Maintainability:** Easier to manage complex applications; changes in the UI generally don't affect the core logic in the ViewModel or Model.

* **Why Repository?**

    * **Abstraction:** Provides a higher-level abstraction over raw data sources. You can change the underlying data source (e.g., switch from a local database to a remote API) without affecting the UI or business logic.

    * **Centralized Data Handling:** Ensures consistency in how data is accessed and managed throughout the application.

    * **Isolation:** Allows for easy mocking of data storage mechanisms, which is beneficial for testing.

    * **Flexibility:** Provides flexibility to change future strategies for fetching and storing data without impacting the rest of the app.

## 6. Navigation

Navigation refers to the process of moving between different screens (composables) within your application.

* **Key Components:**

    * **`NavController`:** The central component for navigation. It manages the navigation stack (backstack graph) of your app, allowing you to navigate to different destinations and handle back presses. You typically obtain it using `rememberNavController()`.

    * **`NavHost()`:** A composable that defines the navigation graph. It links a `NavController` with a set of destinations (composables) that users can navigate to.

    * **`NavGraph` (Conceptual):** This refers to the collection of destinations and their connections, defining the possible navigation paths within your app. It's often built implicitly within the `NavHost`'s lambda, rather than being a direct composable function itself.

* **Implementation Steps:**

    1.  **Add Navigation Dependency:** Include the necessary navigation dependency in your `build.gradle` file.

    2.  **Initialize `NavController`:** In your main composable, create and remember a `NavController`:

        ```kotlin
        val navController = rememberNavController()
        ```

    3.  **Define `NavHost`:**

        ```kotlin
        NavHost(
            navController = navController,
            startDestination = "start_screen_route" // Define your initial screen
        ) {
            // Define your composable destinations
            composable(route = "screen1_route") {
                Screen1Composable()
            }
            composable(route = "screen2_route") {
                Screen2Composable()
            }
            // ... more composable destinations
        }
        ```

        * The `composable()` function within `NavHost` defines a route (a unique string keyword) and associates it with a specific composable function.

* **Navigation Methods:**

    * **1. Direct Route String:**
        You can directly use string literals as routes in `NavHost` and when navigating.

        ```kotlin
        // In NavHost:
        NavHost(navController, startDestination = "HomeScreen") {
            composable(route = "HomeScreen") {
                HomeScreen(navController) // Pass navController if needed for navigation from this screen
            }
            composable(route = "DetailScreen") {
                DetailScreen()
            }
        }

        // To navigate to a destination:
        // Inside a composable, e.g., on a button click:
        Button(onClick = { navController.navigate("DetailScreen") }) {
            Text("Go to Detail")
        }
        ```

    * **2. Using a Sealed Class (Recommended for Type Safety):**
        This method provides better type safety and organization for your navigation routes.

        ```kotlin
        sealed class Screens(val route: String) {
            data object HomeScreen : Screens("home_screen")
            data object DetailScreen : Screens("detail_screen")
            // Add more screens as data objects
        }

        // In NavHost:
        NavHost(navController, startDestination = Screens.HomeScreen.route) {
            composable(route = Screens.HomeScreen.route) {
                HomeScreen(navController)
            }
            composable(route = Screens.DetailScreen.route) {
                DetailScreen()
            }
        }

        // To navigate to a destination:
        Button(onClick = { navController.navigate(Screens.DetailScreen.route) }) {
            Text("Go to Detail")
        }
        ```

        This approach makes it easier to manage routes and prevents typos, especially in larger applications.

# All Progress Related Jetpack Compose

1. Introduction
    1. MainActivity
2. Fundamentals
    1. Basics

## Fundamentals

### Basics

**What is Composable Functions?**

- is a UI Function
- Basic Building Blocks of UI
- uses @Composable for initialisation
- imports androidx.compose.runtime.Composable

- Rules for Composable Function Naming :
    - MUST be a noun: `DoneButton()`
    - NOT a verb or verb phrase: `DrawTextField()`
    - NOT a nouned preposition: `TextFieldWithLink()`
    - NOT an adjective: `Bright()`
    - NOT an adverb: `Outside()`
    - Nouns MAY be prefixed by descriptive adjectives: `RoundIcon()`
    -

**Preview Function**

- Used to Preview Composable Functions
- uses @Preview
- showSystemUi = true to view with system UI

**Buttons**

- Buttons used onClick = {..} function to perform Action

Too much nesting is not good for memory
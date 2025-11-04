# Wordle Game

A Java implementation of the popular Wordle game that functions exactly like the New York Times version.

## Overview

Wordle is a word-guessing game where players have 6 attempts to guess a 5-letter word. After each guess, the game provides feedback indicating which letters are correct and in the right position, which letters are in the word but in the wrong position, and which letters are not in the word at all.

## Features

- Random word selection from a comprehensive 5-letter word list
- 6 attempts to guess the correct word
- Input validation:
  - Must be exactly 5 letters
  - Must contain only alphabetic characters
  - Must be a valid word from the word list
- Color-coded feedback system:
  - **[G]** Green - Letter is correct and in the right position
  - **[Y]** Yellow - Letter is in the word but in the wrong position
  - **[_]** Gray - Letter is not in the word
- Proper handling of duplicate letters (matches NYT Wordle behavior)
- Win/lose detection with appropriate messages

## Requirements

- Java Development Kit (JDK) 8 or higher
- Terminal/Command prompt

## Project Structure

```
Wordle/
├── Wordle.java          # Main game implementation
├── wordle.txt           # List of valid 5-letter words
├── Wordle_specs.txt     # Project specifications
├── README.md            # This file
└── .gitignore           # Git ignore rules
```

## How to Compile

```bash
javac Wordle.java
```

## How to Run

```bash
java Wordle
```

## How to Play

1. Run the game using the command above
2. The game will randomly select a 5-letter word from the word list
3. You have 6 attempts to guess the word
4. Enter your guess when prompted
5. After each guess, you'll receive feedback:
   - Letters marked with [G] are in the correct position
   - Letters marked with [Y] are in the word but in the wrong position
   - Letters marked with [_] are not in the word
6. Win by guessing the correct word within 6 attempts
7. If you don't guess within 6 attempts, the game reveals the answer

## Example Gameplay

```
Welcome to Wordle!
Guess the 5-letter word. You have 6 attempts.
[G] = Green (correct position), [Y] = Yellow (wrong position), [_] = Gray (not in word)

Attempt 1/6:
Enter your guess: crane
  C R A N E
  [_] [Y] [_] [_] [Y]

Attempt 2/6:
Enter your guess: sport
  S P O R T
  [_] [_] [_] [G] [_]

...
```

## Implementation Details

The game implements the following key components:

- **File I/O**: Reads the word list from `wordle.txt`
- **Random Selection**: Uses `Random` class to select a target word
- **Input Validation**: Ensures guesses are valid 5-letter words from the vocabulary
- **Feedback Algorithm**:
  - First pass: Marks exact matches (green)
  - Second pass: Marks letters in wrong positions (yellow)
  - Properly handles duplicate letters to match official Wordle behavior

## Notes

- The game requires `wordle.txt` to be in the same directory as the compiled class
- All input is case-insensitive
- Invalid words will prompt for re-entry without using an attempt

## License

This is an educational project for learning Java programming concepts.

## Acknowledgments

Inspired by the New York Times Wordle game.

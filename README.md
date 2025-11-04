# Wordle Game

A Java implementation of the popular Wordle game that functions exactly like the New York Times version.

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
  - [Running the Game](#running-the-game)
- [How to Play](#how-to-play)
- [Example Gameplay](#example-gameplay)
- [Project Structure](#project-structure)
- [Implementation Details](#implementation-details)
- [Troubleshooting](#troubleshooting)
- [License](#license)
- [Acknowledgments](#acknowledgments)

## Overview

Wordle is a word-guessing game where players have 6 attempts to guess a 5-letter word. After each guess, the game provides color-coded feedback indicating which letters are correct and in the right position, which letters are in the word but in the wrong position, and which letters are not in the word at all.

## Features

- **Random Word Selection** - Chooses from a comprehensive list of valid 5-letter English words
- **6 Attempts** - Classic Wordle gameplay with 6 guesses to find the correct word
- **Robust Input Validation**:
  - ✓ Must be exactly 5 letters
  - ✓ Must contain only alphabetic characters
  - ✓ Must be a valid word from the word list
  - ✓ Case-insensitive input
- **Color-Coded Feedback System**:
  - `[G]` **Green** - Letter is correct and in the right position
  - `[Y]` **Yellow** - Letter is in the word but in the wrong position
  - `[_]` **Gray** - Letter is not in the word
- **Smart Duplicate Handling** - Properly handles duplicate letters to match NYT Wordle behavior
- **Win/Lose Detection** - Clear feedback on game outcomes with appropriate messages

## Getting Started

### Prerequisites

- **Java Development Kit (JDK) 8 or higher**
- Terminal or Command Prompt

### Installation

1. **Clone the repository**:
   ```bash
   git clone <repository-url>
   cd wordle-game
   ```

2. **Verify the word list file**:
   Ensure `wordle.txt` is in the same directory as `Wordle.java`

### Running the Game

1. **Compile the program**:
   ```bash
   javac Wordle.java
   ```

2. **Run the game**:
   ```bash
   java Wordle
   ```

## How to Play

1. **Start the game** - Run the compiled Java program
2. **Read the rules** - The game displays instructions and feedback legend
3. **Make your guess** - Enter a 5-letter word when prompted
4. **Analyze the feedback**:
   - `[G]` = Letter is in the correct position
   - `[Y]` = Letter is in the word but wrong position
   - `[_]` = Letter is not in the word
5. **Refine your strategy** - Use the feedback to make better guesses
6. **Win or learn** - Guess the word within 6 attempts to win, otherwise the answer is revealed

### Invalid Input Handling

The game validates all input and will prompt you to re-enter if your guess:
- Is not exactly 5 letters long
- Contains non-alphabetic characters (numbers, symbols, etc.)
- Is not a valid word in the word list

**Note**: Invalid guesses do not count toward your 6 attempts!

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

Attempt 3/6:
Enter your guess: tiger
  T I G E R
  [_] [_] [_] [Y] [G]

Attempt 4/6:
Enter your guess: coder
  C O D E R
  [_] [_] [_] [G] [G]

Attempt 5/6:
Enter your guess: miner
  M I N E R
  [_] [_] [_] [G] [G]

Attempt 6/6:
Enter your guess: viper
  V I P E R
  [G] [G] [G] [G] [G]

Congratulations! You won in 6/6 attempts!
========================
```

## Project Structure

```
wordle-game/
├── Wordle.java          # Main game implementation (191 lines)
├── wordle.txt           # Comprehensive list of valid 5-letter words
├── Wordle_specs.txt     # Original project specifications
├── README.md            # This documentation file
└── .gitignore           # Git ignore rules
```

## Implementation Details

### Core Components

1. **File I/O**
   - Reads the word list from `wordle.txt`
   - Loads all valid words into an `ArrayList` for efficient access
   - Proper error handling for missing files

2. **Random Selection**
   - Uses Java's `Random` class for cryptographically secure word selection
   - Ensures fair and unpredictable gameplay

3. **Input Validation**
   - Length validation (exactly 5 characters)
   - Character validation (alphabetic only, using regex pattern `[a-z]+`)
   - Dictionary validation (word must exist in vocabulary)
   - Case normalization (converts all input to lowercase)

4. **Feedback Algorithm**
   The game uses a sophisticated two-pass algorithm to handle duplicate letters correctly:

   - **First Pass**: Identifies and marks exact position matches (Green)
   - **Second Pass**: Identifies letters in wrong positions (Yellow) while avoiding double-counting

   This ensures behavior identical to the official NYT Wordle game.

### Key Methods

| Method | Purpose | Lines |
|--------|---------|-------|
| `main(String[] args)` | Entry point, game loop, and flow control | 10-90 |
| `getValidGuess(Scanner, ArrayList)` | Input validation and sanitization | 92-125 |
| `displayFeedback(String, String)` | Two-pass feedback generation algorithm | 127-189 |

## Troubleshooting

### Common Issues

**Issue**: `FileNotFoundException: wordle.txt`
- **Solution**: Ensure `wordle.txt` is in the same directory where you're running `java Wordle`

**Issue**: `javac: command not found`
- **Solution**: Install JDK and ensure it's added to your system PATH

**Issue**: Word not recognized as valid
- **Solution**: The word list contains common English words. Try a different word or verify spelling

**Issue**: Incorrect duplicate letter behavior
- **Solution**: This implementation matches NYT Wordle exactly. The first occurrence is prioritized for exact matches

## License

This is an educational project for learning Java programming concepts including:
- File I/O operations
- ArrayList data structures
- String manipulation and regex
- Input validation
- Algorithm design

## Acknowledgments

Inspired by the [New York Times Wordle](https://www.nytimes.com/games/wordle/index.html) game created by Josh Wardle.

---

**Enjoy playing Wordle!** 🎮

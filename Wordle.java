import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Wordle
{
    private static final int MAX_ATTEMPTS = 6;
    private static final int WORD_LENGTH = 5;

    public static void main(String[] args)
    {
        ArrayList<String> vocab = new ArrayList<>();

        // Load words from file
        try
        {
            File myObj = new File("./wordle.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine())
            {
                String line = myReader.nextLine().trim();
                if (!line.isEmpty())
                {
                    vocab.add(line.toLowerCase());
                }
            }
            myReader.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Error: Could not find wordle.txt file.");
            e.printStackTrace();
            return;
        }

        if (vocab.isEmpty())
        {
            System.out.println("Error: No words loaded from file.");
            return;
        }

        // Select random target word
        Random random = new Random();
        String targetWord = vocab.get(random.nextInt(vocab.size()));

        // Game setup
        Scanner userInput = new Scanner(System.in);
        ArrayList<String> guesses = new ArrayList<>();
        boolean hasWon = false;

        System.out.println("Welcome to Wordle!");
        System.out.println("Guess the " + WORD_LENGTH + "-letter word. You have " + MAX_ATTEMPTS + " attempts.");
        System.out.println("[G] = Green (correct position), [Y] = Yellow (wrong position), [_] = Gray (not in word)\n");

        // Main game loop
        for (int attempt = 1; attempt <= MAX_ATTEMPTS; attempt++)
        {
            System.out.println("Attempt " + attempt + "/" + MAX_ATTEMPTS + ":");
            String guess = getValidGuess(userInput, vocab);
            guesses.add(guess);

            // Check if the guess is correct
            if (guess.equals(targetWord))
            {
                hasWon = true;
                displayFeedback(guess, targetWord);
                break;
            }

            // Display feedback
            displayFeedback(guess, targetWord);
            System.out.println();
        }

        // Game end
        System.out.println("\n==============================");
        if (hasWon)
        {
            System.out.println("Congratulations! You won!");
            System.out.println("You guessed the word in " + guesses.size() + " attempt(s).");
        }
        else
        {
            System.out.println("Game Over! You've used all " + MAX_ATTEMPTS + " attempts.");
            System.out.println("The word was: " + targetWord.toUpperCase());
        }
        System.out.println("==============================");

        userInput.close();
    }

    /**
     * Get a valid guess from the user
     */
    private static String getValidGuess(Scanner scanner, ArrayList<String> vocab)
    {
        while (true)
        {
            System.out.print("Enter your guess: ");
            String guess = scanner.nextLine().trim().toLowerCase();

            // Check if guess is exactly 5 letters
            if (guess.length() != WORD_LENGTH)
            {
                System.out.println("Invalid! Your guess must be exactly " + WORD_LENGTH + " letters.");
                continue;
            }

            // Check if guess contains only letters
            if (!guess.matches("[a-z]+"))
            {
                System.out.println("Invalid! Your guess must contain only letters.");
                continue;
            }

            // Check if guess is a valid word in the vocabulary
            if (!vocab.contains(guess))
            {
                System.out.println("Invalid! That word is not in the word list. Try another word.");
                continue;
            }

            return guess;
        }
    }

    /**
     * Display color-coded feedback for the guess
     */
    private static void displayFeedback(String guess, String target)
    {
        char[] guessChars = guess.toCharArray();
        char[] targetChars = target.toCharArray();
        String[] feedback = new String[WORD_LENGTH];
        boolean[] targetUsed = new boolean[WORD_LENGTH];
        boolean[] guessProcessed = new boolean[WORD_LENGTH];

        // First pass: Mark green (correct position)
        for (int i = 0; i < WORD_LENGTH; i++)
        {
            if (guessChars[i] == targetChars[i])
            {
                feedback[i] = "[G]";
                targetUsed[i] = true;
                guessProcessed[i] = true;
            }
        }

        // Second pass: Mark yellow (wrong position) and gray (not in word)
        for (int i = 0; i < WORD_LENGTH; i++)
        {
            if (guessProcessed[i])
            {
                continue; // Already marked as green
            }

            boolean foundInWrongPosition = false;
            for (int j = 0; j < WORD_LENGTH; j++)
            {
                if (!targetUsed[j] && guessChars[i] == targetChars[j])
                {
                    feedback[i] = "[Y]";
                    targetUsed[j] = true;
                    foundInWrongPosition = true;
                    break;
                }
            }

            if (!foundInWrongPosition)
            {
                feedback[i] = "[_]";
            }
        }

        // Display the guess with feedback
        System.out.print("  ");
        for (int i = 0; i < WORD_LENGTH; i++)
        {
            System.out.print(Character.toUpperCase(guessChars[i]) + " ");
        }
        System.out.println();

        System.out.print("  ");
        for (int i = 0; i < WORD_LENGTH; i++)
        {
            System.out.print(feedback[i] + " ");
        }
        System.out.println();
    }
}

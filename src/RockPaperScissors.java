import java.util.Scanner;

public class RockPaperScissors {
    private static final String HUMAN = "human";
    private static final String COMPUTER = "computer";
    private static final String TIE = "tie";
    private static final String ROCK = "rock";
    private static final String PAPER = "paper";
    private static final String SCISSORS = "scissors";
    private static final String WIN_MESSAGE = "You WON !!";
    private static final String LOSE_MESSAGE = "You lost :(";
    private static final String TIE_MESSAGE = "a tie";
    private static final String INVALID_INPUT_MESSAGE = "Invalid input. Please enter rock, paper, or scissors.";

    private Scanner scanner;
    private String computerChoice;
    private String humanChoice;
    private String roundWinner;

    private int humanScore;
    private int computerScore;

    public RockPaperScissors() {
        humanScore = 0;
        computerScore = 0;
        scanner = new Scanner(System.in);
    }

    public int getHumanScore() {
        return humanScore;
    }

    public int getComputerScore() {
        return computerScore;
    }

    private String getComputerChoice() {
        double randomNumber = Math.random();
        if (randomNumber < 1.0 / 3.0) {
            return ROCK;
        }
        else if (randomNumber < 2.0 / 3.0) {
            return PAPER;
        }
        else {
            return SCISSORS;
        }
    }

    private String getHumanChoice() {
        while (true) {
            System.out.println("Enter your choice");
            String choice = scanner.nextLine().toLowerCase();
            if (choice.equals(ROCK) || choice.equals(PAPER) || choice.equals(SCISSORS)) {
                return choice;
            }
            else {
                System.out.println(INVALID_INPUT_MESSAGE);
            }
        }
    }

    private String checkWinner(String humanChoice, String computerChoice) {
        if (humanChoice.equals(ROCK)) {
            if (computerChoice.equals(SCISSORS)) {
                return HUMAN;
            }
            else if (computerChoice.equals(PAPER)) {
                return COMPUTER;
            }
            else {
                return TIE;
            }
        }
        else if (humanChoice.equals(PAPER)) {
            if (computerChoice.equals(ROCK)) {
                return HUMAN;
            }
            else if (computerChoice.equals(SCISSORS)) {
                return COMPUTER;
            }
            else {
                return TIE;
            }
        }
        else {
            if (computerChoice.equals(PAPER)) {
                return HUMAN;
            }
            else if (computerChoice.equals(ROCK)) {
                return COMPUTER;
            }
            else {
                return TIE;
            }
        }
    }

    private void showScore() {
        System.out.println("Your score is: " + humanScore);
        System.out.println("Computer score is: " + computerScore);
    }

    public void playRound() {
        computerChoice = getComputerChoice();
        humanChoice = getHumanChoice();
        roundWinner = checkWinner(humanChoice, computerChoice);
        if (roundWinner.equals(HUMAN)) {
            humanScore++;
            System.out.println(WIN_MESSAGE);
        }
        else if (roundWinner.equals(COMPUTER)) {
            computerScore++;
            System.out.println(LOSE_MESSAGE);
        }
        else {
            System.out.println(TIE_MESSAGE);
        }
        showScore();
    }
}
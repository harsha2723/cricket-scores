import java.util.Scanner;

public class CricketScoreApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int totalScore = 0;
        int wickets = 0;
        int overs = 0;
        int balls = 0;
        int player1Score = 0;
        int player2Score = 0;
        int player1Balls = 0;
        int player2Balls = 0;
        int currentPlayer = 1;
        int partnership = 0;

        // Get the number of overs played
        System.out.print("Enter the number of overs played: ");
        overs = input.nextInt();

        // Get the score and wicket for each ball and update the total score and wickets
        for (int i = 1; i <= overs * 6; i++) {
            System.out.print("Enter score for ball " + i + ": ");
            int score = input.nextInt();
            if (score < 0 || score > 6) {
                System.out.println("Invalid score! Please enter a score between 0 and 6.");
                i--;
                continue;
            }
            totalScore += score;
            balls++;

            // Check for a wicket
            System.out.print("Enter 1 for a wicket, or 0 for no wicket: ");
            int isWicket = input.nextInt();
            if (isWicket == 1) {
                wickets++;
                if (currentPlayer == 1) {
                    System.out.println("Player 1 is out!");
                    player1Score = 0;
                    player1Balls = 0;
                    currentPlayer = 2;
                } else {
                    System.out.println("Player 2 is out!");
                    player2Score = 0;
                    player2Balls = 0;
                    currentPlayer = 1;
                }
            } else {
                if (currentPlayer == 1) {
                    player1Score += score;
                    player1Balls++;
                } else {
                    player2Score += score;
                    player2Balls++;
                }
                partnership += score;
            }

            // Display the scorecard after every over
            if (balls % 6 == 0) {
                System.out.println("\nScorecard after " + (balls / 6) + " overs:");
                System.out.println("Total Score: " + totalScore + "/" + wickets);
                System.out.println("Run rate: " + (double) totalScore / (balls / 6));
                System.out.println("Player 1: " + player1Score + " (" + player1Balls + ")");
                System.out.println("Player 2: " + player2Score + " (" + player2Balls + ")");
                if (currentPlayer == 1) {
                    System.out.println("Current Partnership: " + partnership + " (Player 1 is on strike)");
                } else {
                    System.out.println("Current Partnership: " + partnership + " (Player 2 is on strike)");
                }
                System.out.println("-------------------------------");
            }
        }

        // Display the final scorecard
        System.out.println("\nFinal Scorecard:");
        System.out.println("Total Score: " + totalScore + "/" + wickets);
        System.out.println("Run rate: " + (double) totalScore / overs);
        System.out.println("Player 1: " + player1Score + " (" + player1Balls + ")");
        System.out.println("Player 2: " + player

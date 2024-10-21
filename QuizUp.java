import java.util.Scanner;

public class QuizUp {
    private static EvaluationManager evaluationManager = new EvaluationManager();
    private static Scanner inputScanner = new Scanner(System.in);
    private static int[] userAnswers;
    private static QuizTimer quizTimer; // Timer instance

    public static void initiateQuiz() {
        System.out.println("Welcome to the Quiz Application!");
        System.out.println("You have 10 minutes to complete the quiz.");
        System.out.println("Enter 'start' to start the quiz.");
        String userChoice = "";

        while (!userChoice.equalsIgnoreCase("start")) {
            userChoice = inputScanner.nextLine();
        }

        // Check if there are any questions in the quizDatabase
        if (Questions.totalQuestions == 0 || Questions.questionBank == null) {
            // Use default questions if no questions are available
            System.out.println("No custom questions available. Using demo questions...");
            Questions.questionBank = demoQuiz.demoQuestion;  // Fallback to demo questions
            Questions.totalQuestions = demoQuiz.demoQuestion.length;
        }

        userAnswers = new int[Questions.totalQuestions];
        quizTimer = new QuizTimer(10 * 60 * 1000); // 10 minutes in milliseconds
        quizTimer.startTimer(); // Start the timer
        presentQuestions();
        evaluationManager.evaluateResponses(userAnswers, Questions.questionBank, Questions.totalQuestions);
        evaluationManager.showResults();
    }

    private static void presentQuestions() {
        for (int i = 0; i < Questions.totalQuestions; i++) {
            if (quizTimer.isTimeUp()) break; // Check if time is up

            System.out.println("\nQuestion " + (i + 1) + ": " + Questions.questionBank[i][0][0]);
            System.out.println("Options:");
            for (int j = 1; j <= 4; j++) {
                System.out.println("Option " + j + ": " + Questions.questionBank[i][j][0]);
            }

            boolean validInput = false;
            String answer = "";
            while (!validInput && !quizTimer.isTimeUp()) {
                System.out.print("Enter your answer (1, 2, 3, 4): ");
                answer = inputScanner.nextLine();

                if (Questions.isValidInt(answer) && Integer.parseInt(answer) >= 1 && Integer.parseInt(answer) <= 4) {
                    validInput = true;
                } else {
                    System.out.println("Invalid input, please enter a number between 1 and 4.");
                }
            }

            if (!quizTimer.isTimeUp()) {
                userAnswers[i] = Integer.parseInt(answer);
                printRemainingTime();
            }
        }

        if (!quizTimer.isTimeUp()) {
            System.out.println("Submit early? All questions answered. Ending quiz early.");
        }
    }

    private static void printRemainingTime() {
        long remainingTime = quizTimer.getRemainingTime();
        long minutes = (remainingTime / 1000) / 60;
        long seconds = (remainingTime / 1000) % 60;
        System.out.println("Time remaining: " + minutes + " minutes " + seconds + " seconds");
    }

    public static void main(String[] args) {
        initiateQuiz();
    }
}

import java.util.Scanner;

/**
 * The demoQuiz class represents a collection of demo quiz questions.
 * It contains a static array demoQuestion, which holds questions, options, and the correct answer.
 * The class provides a method iterateDemoQuestions to display all the demo questions with their options and correct answer.
 * This class can be used as a fallback for a quiz system in case no custom questions are provided by the admin.
 * owner Ajay.
 */
public class demoQuiz {
    public static String[][][] demoQuestion = {
            {
                    {"What is the capital of France?", "1"},
                    {"Paris"}, {"London"}, {"Berlin"}, {"Rome"}
            },
            {
                    {"Which planet is known as the Red Planet?", "2"},
                    {"Venus"}, {"Mars"}, {"Jupiter"}, {"Saturn"}
            },
            {
                    {"What is the largest ocean on Earth?", "4"},
                    {"Atlantic Ocean"}, {"Indian Ocean"}, {"Arctic Ocean"}, {"Pacific Ocean"}
            },
            {
                    {"Who wrote 'Hamlet'?", "2"},
                    {"Charles Dickens"}, {"William Shakespeare"}, {"Mark Twain"}, {"George Orwell"}
            },
            {
                    {"What is 5 + 3?", "2"},
                    {"6"}, {"8"}, {"10"}, {"12"}
            },
            {
                    {"What color do you  when you mix red and white?", "1"},
                    {"Pink"}, {"Purple"}, {"Orange"}, {"Brown"}
            },
            {
                    {"What is the main ingredient in bread?", "3"},
                    {"Sugar"}, {"Salt"}, {"Flour"}, {"Water"}
            },
            {
                    {"How many days are in a week?", "1"},
                    {"7"}, {"6"}, {"5"}, {"8"}
            },
            {
                    {"What is the boiling point of water?", "2"},
                    {"90°C"}, {"100°C"}, {"120°C"}, {"80°C"}
            },
            {
                    {"What is the capital of Japan?", "3"},
                    {"Seoul"}, {"Beijing"}, {"Tokyo"}, {"Bangkok"}
            },
            {
                    {"What is the chemical symbol for water?", "1"},
                    {"H2O"}, {"O2"}, {"CO2"}, {"NaCl"}
            },
            {
                    {"What is 12 divided by 4?", "1"},
                    {"3"}, {"2"}, {"4"}, {"6"}
            },
            {
                    {"What gas do plants absorb?", "2"},
                    {"Oxygen"}, {"Carbon Dioxide"}, {"Nitrogen"}, {"Hydrogen"}
            },
            {
                    {"What is the hardest natural substance?", "1"},
                    {"Diamond"}, {"Iron"}, {"Gold"}, {"Quartz"}
            },
            {
                    {"What is 9 - 4?", "1"},
                    {"5"}, {"6"}, {"3"}, {"2"}
            }
    };
    
     /**
     * Method to iterate over and display each demo question along with its options and correct answer.
     *
     * @param demoQuestion The array containing demo questions.
     */
    public static void iterateDemoQuestions(String[][][] demoQuestion) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < demoQuestion.length; i++) {
            System.out.println("Question " + (i + 1) + ": " + demoQuestion[i][0][0]);
            System.out.println("Options:");
            for (int j = 1; j <= 4; j++) {
                System.out.println("  " + j + ". " + demoQuestion[i][j][0]);
            }
            System.out.print("Enter your answer (1-4): ");
            String userAnswer = scanner.nextLine();
        }
        scanner.close();
    }

    public static void main(String[] args) {
        iterateDemoQuestions(demoQuestion);
    }
}
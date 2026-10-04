import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class Question {
    String type;
    String correctAnswer;
    String studentAnswer;
    int points;

    Question(String type, String correctAnswer, String studentAnswer, int points) {
        this.type = type;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    abstract double calculateScore();
}

class MCQQuestion extends Question {
    MCQQuestion(String correctAnswer, String studentAnswer, int points) {
        super("MCQ", correctAnswer, studentAnswer, points);
    }

    double calculateScore() {
        return correctAnswer.equals(studentAnswer) ? points : 0;
    }
}

class TrueFalseQuestion extends Question {
    TrueFalseQuestion(String correctAnswer, String studentAnswer, int points) {
        super("TF", correctAnswer, studentAnswer, points);
    }

    double calculateScore() {
        return correctAnswer.equals(studentAnswer) ? points : 0;
    }
}

class EssayQuestion extends Question {
    EssayQuestion(String correctAnswer, String studentAnswer, int points) {
        super("ESSAY", correctAnswer, studentAnswer, points);
    }

    double calculateScore() {
        String[] keywords = correctAnswer.split(",");
        String answerLower = studentAnswer.toLowerCase();

        int matchCount = 0;
        for (String keyword : keywords) {
            if (answerLower.contains(keyword.trim().toLowerCase())) {
                matchCount++;
            }
        }

        if (matchCount >= 2) {
            return points * 0.75;
        } else if (matchCount == 1) {
            return points * 0.50;
        } else {
            return 0;
        }
    }
}

public class ExamQuestionGrader {

    static Question createQuestion(String type, String correctAnswer, String studentAnswer, int points) {
        switch (type) {
            case "MCQ":
                return new MCQQuestion(correctAnswer, studentAnswer, points);
            case "TF":
                return new TrueFalseQuestion(correctAnswer, studentAnswer, points);
            case "ESSAY":
                return new EssayQuestion(correctAnswer, studentAnswer, points);
            default:
                throw new IllegalArgumentException("Unknown question type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        Pattern quotedPattern = Pattern.compile("\"([^\"]*)\"");

        double totalScore = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();

            String type = line.substring(0, line.indexOf(' ')).trim();

            // Pull out the three quoted fields: QuestionText, CorrectAnswer, StudentAnswer
            Matcher matcher = quotedPattern.matcher(line);
            matcher.find();
            String questionText = matcher.group(1); // not needed for scoring, but parsed for completeness
            matcher.find();
            String correctAnswer = matcher.group(1);
            matcher.find();
            String studentAnswer = matcher.group(1);

            // Points is the last token after the final quote
            String remainder = line.substring(line.lastIndexOf('"') + 1).trim();
            int points = Integer.parseInt(remainder);

            Question question = createQuestion(type, correctAnswer, studentAnswer, points);
            double score = question.calculateScore();

            System.out.printf("%s: %.2f%n", question.type, score);
            totalScore += score;
        }

        System.out.printf("Total Score: %.2f%n", totalScore);
        sc.close();
    }
}

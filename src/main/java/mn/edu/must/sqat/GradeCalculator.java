package mn.edu.must.sqat;

public class GradeCalculator {

    // 90+ -> A, 80-89 -> B, 70-79 -> C, 60-69 -> D, <60 -> F
    public String letterGrade(double score) {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("Score must be between 0 and 100");
        }

        if (score >= 90) {
            return "A";
        } else if (score >= 80) {
            return "B";
        } else if (score >= 70) {
            return "C";
        } else if (score >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    // Ирц(10), лаб+бие даалт(40), сорил1(10),
    // сорил2(10), шалгалт(30)
    public double totalScore(double att, double lab, double quiz1,
                             double quiz2, double exam) {

        if (att < 0 || att > 10 ||
            lab < 0 || lab > 40 ||
            quiz1 < 0 || quiz1 > 10 ||
            quiz2 < 0 || quiz2 > 10 ||
            exam < 0 || exam > 30) {
            throw new IllegalArgumentException("Invalid score");
        }

        return att + lab + quiz1 + quiz2 + exam;
    }
}

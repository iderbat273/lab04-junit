package mn.edu.must.sqat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GradeCalculatorTest {

    @Test
    @DisplayName("95 оноо A дүн байх ёстой")
    void ninetyFiveIsA() {
        // Arrange
        GradeCalculator calc = new GradeCalculator();

        // Act
        String grade = calc.letterGrade(95.0);

        // Assert
        assertEquals("A", grade);
    }

    @Test
    @DisplayName("90 оноо яг A дүн байх ёстой")
    void ninetyIsExactlyA() {
        // Arrange
        GradeCalculator calc = new GradeCalculator();

        // Act
        String grade = calc.letterGrade(90.0);

        // Assert
        assertEquals("A", grade);
    }

    @Test
    @DisplayName("89.99 оноо B дүн байх ёстой")
    void eightyNinePointNineNineIsB() {
        // Arrange
        GradeCalculator calc = new GradeCalculator();

        // Act
        String grade = calc.letterGrade(89.99);

        // Assert
        assertEquals("B", grade);
    }

    @Test
    @DisplayName("60 оноо D дүн байх ёстой")
    void sixtyIsD() {
        // Arrange
        GradeCalculator calc = new GradeCalculator();

        // Act
        String grade = calc.letterGrade(60.0);

        // Assert
        assertEquals("D", grade);
    }

    @Test
    @DisplayName("59.99 оноо F дүн байх ёстой")
    void fiftyNinePointNineNineIsF() {
        // Arrange
        GradeCalculator calc = new GradeCalculator();

        // Act
        String grade = calc.letterGrade(59.99);

        // Assert
        assertEquals("F", grade);
    }

    @Test
    @DisplayName("0 оноо F дүн байх ёстой")
    void zeroIsF() {
        // Arrange
        GradeCalculator calc = new GradeCalculator();

        // Act
        String grade = calc.letterGrade(0.0);

        // Assert
        assertEquals("F", grade);
    }

    @Test
    @DisplayName("100 оноо A дүн байх ёстой")
    void hundredIsA() {
        // Arrange
        GradeCalculator calc = new GradeCalculator();

        // Act
        String grade = calc.letterGrade(100.0);

        // Assert
        assertEquals("A", grade);
    }

    @Test
    @DisplayName("-1 оноо IllegalArgumentException шидэх ёстой")
    void negativeScoreThrowsException() {
        // Arrange
        GradeCalculator calc = new GradeCalculator();

        // Act & Assert
        assertThrows(
                IllegalArgumentException.class,
                () -> calc.letterGrade(-1.0)
        );
    }

    @Test
    @DisplayName("101 оноо IllegalArgumentException шидэх ёстой")
    void overHundredScoreThrowsException() {
        // Arrange
        GradeCalculator calc = new GradeCalculator();

        // Act & Assert
        assertThrows(
                IllegalArgumentException.class,
                () -> calc.letterGrade(101.0)
        );
    }

    @Test
    @DisplayName("Бүх оноо дээд хязгаарт байх үед нийлбэр 100 байх ёстой")
    void totalScoreIs100() {
        // Arrange
        GradeCalculator calc = new GradeCalculator();

        // Act
        double total = calc.totalScore(10, 40, 10, 10, 30);

        // Assert
        assertEquals(100.0, total);
    }

    @Test
    @DisplayName("Сөрөг ирц IllegalArgumentException шидэх ёстой")
    void negativeAttendanceThrowsException() {
        // Arrange
        GradeCalculator calc = new GradeCalculator();

        // Act & Assert
        assertThrows(
                IllegalArgumentException.class,
                () -> calc.totalScore(-5, 40, 10, 10, 30)
        );
    }

    @Test
    @DisplayName("Лабораторийн 41 оноо IllegalArgumentException шидэх ёстой")
    void labOverLimitThrowsException() {
        // Arrange
        GradeCalculator calc = new GradeCalculator();

        // Act & Assert
        assertThrows(
                IllegalArgumentException.class,
                () -> calc.totalScore(10, 41, 10, 10, 30)
        );
    }

    @ParameterizedTest
    @DisplayName("Онооны хязгаарууд зөв үсгэн дүн гаргах ёстой")
    @CsvSource({
        "95, A",
        "90, A",
        "89.99, B",
        "80, B",
        "70, C",
        "60, D",
        "59.99, F",
        "0, F",
        "100, A"
    })
    void letterGradeBoundaries(double score, String expected) {
        // Arrange
        GradeCalculator calc = new GradeCalculator();

        // Act
        String actual = calc.letterGrade(score);

        // Assert
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @DisplayName("Нийлбэр оноо зөв тооцогдох ёстой")
    @CsvSource({
        "10, 40, 10, 10, 30, 100",
        "10, 30, 10, 10, 20, 80",
        "5, 20, 5, 5, 15, 50",
        "0, 0, 0, 0, 0, 0"
    })
    void totalScoreCalculations(
            double att,
            double lab,
            double quiz1,
            double quiz2,
            double exam,
            double expected) {

        // Arrange
        GradeCalculator calc = new GradeCalculator();

        // Act
        double actual = calc.totalScore(att, lab, quiz1, quiz2, exam);

        // Assert
        assertEquals(expected, actual);
    }
}

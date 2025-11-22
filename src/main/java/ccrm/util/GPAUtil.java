package ccrm.util;

public class GPAUtil {

    public static double gradeToPoints(String grade) {
        if (grade == null) return 0.0;
        return switch (grade.toUpperCase()) {
            case "O" -> 10.0;
            case "A+" -> 9.0;
            case "A" -> 8.0;
            case "B+" -> 7.0;
            case "B" -> 6.0;
            case "C" -> 5.0;
            default -> 0.0; // F or unknown
        };
    }
}

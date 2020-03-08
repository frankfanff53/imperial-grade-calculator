package GradeCalculator.Year1.Modules;

import GradeCalculator.Year1.Assessments.Assessment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractModule implements Module {
    private final double passMark;
    private String moduleName;
    private double finalMark;
    private boolean isPassed;
    private Map<Assessment, Double> assessments;
    private Map<String, Double> boarderMap;
    private List<Assessment> allAssessments;

    public AbstractModule(String moduleName, double passMark) {
        this.moduleName = moduleName;
        finalMark = 0;
        this.passMark = passMark;
        assessments = new HashMap<>();
        isPassed = false;
        allAssessments = new ArrayList<>();
        boarderMap = Map.of("Pass", passMark, "2:2 Degree", 50.0,
                "50", 50.0, "2:1 Degree", 60.0, "60", 60.0,
                "1st Degree", 70.0, "80", 80.0, "90", 90.0, "100", 100.0);
    }

    @Override
    public String getModuleName() {
        return moduleName;
    }

    @Override
    public void updateState() {
        isPassed = finalMark > passMark;
    }

    @Override
    public void updateAssessment(Assessment assessment) {
        assessments.put(assessment, assessment.getMark());
        finalMark += assessment.getContribution();
        allAssessments.add(assessment);
        updateState();
    }

    @Override
    public double getFinalMark() {
        return finalMark;
    }

    @Override
    public double getPassMark() {
        return passMark;
    }

    @Override
    public Map<Assessment, Double> getModules() {
        return assessments;
    }

    @Override
    public String getFinalGrade() {
        if (!isPassed) {
            return "Fail";
        } else if (finalMark >= 40 && finalMark < 50) {
            return "3rd Degree";
        } else if (finalMark >= 50 && finalMark < 60) {
            return "2:2 Degree";
        } else if (finalMark >= 60 && finalMark < 70) {
            return "2:1 Degree";
        } else {
            return "1st Degree";
        }
    }

    @Override
    public String getTranscript() {
        StringBuilder result = new StringBuilder();
        result.append(moduleName);
        result.append("\n");
        result.append("Here is your transcript for this module: \n");
        for (Assessment assessment : allAssessments) {
            result.append(assessment.getName());
            result.append(": ");
            result.append(assessments.get(assessment));
            result.append(" / ");
            result.append(assessment.getFullMark());
            result.append("\n");
        }
        result.append("Final Mark: ");
        result.append(finalMark);
        result.append("\n");
        result.append("Your final grade is: ");
        result.append(getFinalGrade());
        return result.toString();
    }

    @Override
    public String getExpectedFinalGrade(String grade, double finalWeight) {
        double markDistance = boarderMap.get(grade) - finalMark;
        double percentage = markDistance / (finalWeight / 100);
        if (percentage > 100) {
            return "Sorry, you cannot make it";
        }
        return "You should get " + percentage + " / 100 to get a " + grade + " in " + moduleName;
    }

    @Override
    public String toString() {
        return "Your final marks for the module ( " + this.moduleName + " ) is: " + finalMark;
    }
}

package GradeCalculator.Year1.Modules;

import GradeCalculator.Year1.Assessments.Assessment;

import java.util.Map;

public interface Module {
    void updateState();

    void updateAssessment(Assessment assessment);

    String getModuleName();

    double getPassMark();

    double getFinalMark();

    String getFinalGrade();

    String getTranscript();

    Map<Assessment, Double> getModules();

    String getExpectedFinalGrade(String grade, double finalWeight);

}

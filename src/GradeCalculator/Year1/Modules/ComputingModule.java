package GradeCalculator.Year1.Modules;

import GradeCalculator.Year1.Assessments.Assessment;

import java.util.Map;


public class ComputingModule extends AbstractModule {

    public ComputingModule(String moduleName, double passMark) {
        super(moduleName, passMark);
    }

    @Override
    public String getModuleName() {
        return super.getModuleName();
    }

    @Override
    public void updateState() {
        super.updateState();
    }

    @Override
    public void updateAssessment(Assessment assessment) {
        super.updateAssessment(assessment);
    }

    @Override
    public double getFinalMark() {
        return super.getFinalMark();
    }

    @Override
    public Map<Assessment, Double> getModules() {
        return super.getModules();
    }

    @Override
    public double getPassMark() {
        return super.getPassMark();
    }

    @Override
    public String getFinalGrade() {
        return super.getFinalGrade();
    }

    @Override
    public String getTranscript() {
        return super.getTranscript();
    }

    @Override
    public String getExpectedFinalGrade(String grade, double finalWeight) {
        return super.getExpectedFinalGrade(grade, finalWeight);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

package GradeCalculator.Year1.Assessments.SpecialAssessments;

import GradeCalculator.Year1.Assessments.Assessment;

public class Survey extends Assessment {
    public Survey(String name, double weight) {
        super(name, 1, 1, weight);
    }

    @Override
    public double getMark() {
        return super.getMark();
    }

    @Override
    public double getContribution() {
        return super.getContribution();
    }

    @Override
    public double getFullMark() {
        return super.getFullMark();
    }
}

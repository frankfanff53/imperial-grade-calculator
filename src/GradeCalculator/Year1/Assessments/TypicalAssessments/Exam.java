package GradeCalculator.Year1.Assessments.TypicalAssessments;

import GradeCalculator.Year1.Assessments.Assessment;

public class Exam extends Assessment {


    public Exam(String name, double mark, double fullMark, double weight) {
        super(name, mark, fullMark, weight);
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

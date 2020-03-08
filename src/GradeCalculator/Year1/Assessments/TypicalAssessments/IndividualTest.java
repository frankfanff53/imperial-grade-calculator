package GradeCalculator.Year1.Assessments.TypicalAssessments;

public class IndividualTest extends Test {
    private double newWeight;

    public IndividualTest(String name, double mark, double fullMark, double weight, double newWeight) {
        super(name, mark, fullMark, weight * newWeight / 100);
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

package GradeCalculator.Year1.Assessments;

import GradeCalculator.Year1.Assessments.TypicalAssessments.Test;

public abstract class Assessment {
    private String name;
    private double mark;
    private double fullMark;
    private double weight;

    public Assessment(String name, double mark, double fullMark, double weight) {
        this.name = name;
        this.mark = mark;
        this.fullMark = fullMark;
        this.weight = weight;
    }

    public double getMark() {
        return this.mark;
    }

    public double getFullMark() {
        return fullMark;
    }

    public double getContribution() {
        return mark / fullMark * weight;
    }

    public String getName() {
        return name;
    }

    public static class GroupTest extends Test {
        private double newWeight;

        public GroupTest(String name, double mark, double fullMark, double weight, double newWeight) {
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
}

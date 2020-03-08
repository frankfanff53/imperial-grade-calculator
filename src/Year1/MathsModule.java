package Year1;

import Year1.Assessments.Assessment;

import java.util.HashMap;
import java.util.Map;


public abstract class MathsModule implements Module {
    private double finalMark;
    private final double passMark;
    private boolean isPassed;
    private Map<Assessment, Double> assessments;

    public MathsModule(double passMark) {
        finalMark = 0;
        this.passMark = passMark;
        assessments = new HashMap<>();
        isPassed = false;
    }

    @Override
    public void updateState() {
        isPassed = finalMark > passMark;
    }

    @Override
    public void updateAssessment(Assessment assessment) {
        assessments.put(assessment, assessment.getMark());
        finalMark += assessment.getContribution();
        updateState();
    }

    @Override
    public double getFinalMark() {
        return finalMark;
    }

    @Override
    public String getFinalGrade() {
        if (!isPassed){
            return "Fail";
        } else if (finalMark >= 40 && finalMark < 50){
            return "3rd Degree";
        } else if (finalMark >= 50 && finalMark < 60){
            return "2:2 Degree";
        } else if (finalMark >= 60 && finalMark < 70){
            return "2:1 Degree";
        } else {
            return "1st Degree";
        }
    }

    @Override
    public String getTranscript() {
        StringBuilder result = new StringBuilder();
        Assessment[] allAssessments = (Assessment[]) assessments.keySet().toArray();
        for (Assessment assessment: allAssessments){
            result.append(assessment.toString());
            result.append(": ");
            result.append(assessments.get(assessment));
            result.append("\n");
        }
        result.append("Final Mark: ");
        result.append(finalMark);
        result.append("\n");
        result.append("Your final grade is: ");
        result.append(getFinalGrade());
        return result.toString();
    }
}

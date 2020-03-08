package Year1;

import Year1.Assessments.Assessment;

import java.util.Map;

public interface Module {
    void updateState();
    void updateAssessment(Assessment assessment);
    double getFinalMark();
    String getFinalGrade();
    String getTranscript();

}

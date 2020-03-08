package GradeCalculator;

import GradeCalculator.Year1.Assessments.Assessment;
import GradeCalculator.Year1.Assessments.SpecialAssessments.ConceptMap;
import GradeCalculator.Year1.Assessments.SpecialAssessments.CourseDiscussionSite;
import GradeCalculator.Year1.Assessments.SpecialAssessments.Survey;
import GradeCalculator.Year1.Assessments.TypicalAssessments.*;
import GradeCalculator.Year1.JMC1;
import GradeCalculator.Year1.Modules.AbstractModule;
import GradeCalculator.Year1.Modules.ComputingModule;
import GradeCalculator.Year1.Modules.MathsModule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        AbstractModule introToUniMaths = new
                MathsModule("Introduction to University Mathematics", 50);
        Assessment IT1 = new IndividualTest("Individual Test 1", 24, 30, 20, 85);
        Assessment GT1 = new Assessment.GroupTest("Group Test 1", 28, 33, 20, 15);
        Assessment IT2 = new IndividualTest("Individual Test 2", 14, 30, 20, 85);
        Assessment GT2 = new Assessment.GroupTest("Group Test 2", 12, 20, 20, 15);
        Assessment introFinal = new Exam("Intro to Uni Maths Final", 50, 60, 50);
        Assessment CW1 = new CourseWork("CourseWork 1", 10, 10, 1.5);
        Assessment CW2 = new CourseWork("CourseWork 2", 9, 10, 1.5);
        Assessment CW3 = new CourseWork("CourseWork 3", 10, 10, 1.5);
        Assessment Q1 = new Quiz("Quiz 1", 30, 30, 1);
        Assessment Q2 = new Quiz("Quiz 2", 20, 30, 1);
        Assessment Q3 = new Quiz("Quiz 3", 30, 30, 1);
        Assessment S = new Survey("Survey", 0.5);
        Assessment C1 = new ConceptMap("ConceptMap 1", 1);
        Assessment C2 = new ConceptMap("ConceptMap 2", 1);
        List<Assessment> allAssessments = new ArrayList<>(Arrays.asList(IT1, GT1, IT2, GT2, introFinal,
                CW1, CW2, CW3, Q1, Q2, Q3, S, C1, C2));
        for (Assessment assessment : allAssessments) {
            introToUniMaths.updateAssessment(assessment);
        }
//        System.out.println(introToUniMaths.getTranscript());

        AbstractModule analysis = new
                MathsModule("Analysis I", 40);
        Assessment midTerm = new Test("Mid-Term test", 8, 25, 10);
        Assessment janExam = new Exam("Analysis January Exam", 50, 100, 10);
        Q1 = new Quiz("Quiz 1", 14, 20, 1.2);
        Q2 = new Quiz("Quiz 2", 17.6, 20, 1.2);
        Q3 = new Quiz("Quiz 3", 17.4, 20, 1.2);
        Assessment Q4 = new Quiz("Quiz 4", 20, 20, 1.2);
        Assessment Q5 = new Quiz("Quiz 5", 14, 20, 1.2);
        Assessment CDS = new CourseDiscussionSite("Course Discussion Site", 4);
        allAssessments = new ArrayList<>(Arrays.asList(midTerm, janExam, Q1, Q2, Q3, Q4, Q5, CDS));
        for (Assessment assessment : allAssessments) {
            analysis.updateAssessment(assessment);
        }
        System.out.println(analysis.getExpectedFinalGrade("Pass", 70));

        AbstractModule calculus = new
                MathsModule("Calculus and Applications", 40);
        midTerm = new Test("Mid-Term test", 23, 30, 10);
        janExam = new Exam("Calculus January Exam", 87.5, 100, 10);
        CW1 = new CourseWork("Coursework 1", 12, 12, 4);
        CW2 = new CourseWork("Coursework 2", 18, 20, 6);
        allAssessments = new ArrayList<>(Arrays.asList(midTerm, janExam, CW1, CW2));
        for (Assessment assessment : allAssessments) {
            calculus.updateAssessment(assessment);
        }
        System.out.println(calculus.getExpectedFinalGrade("Pass", 70));
        AbstractModule threeInOne = new
                MathsModule("Calculus, Algebra and Analysis", 40);
        Assessment T1 = new Quiz("Test 1", 25, 30, 2.5);
        Assessment T2 = new Quiz("Test 2", 20, 30, 2.5);
        Assessment T3 = new Quiz("Test 3", 22, 30, 2.5);
        Assessment T4 = new Quiz("Test 4", 20, 30, 2.5);

        allAssessments = new ArrayList<>(Arrays.asList(T1, T2, T3, T4));
        for (Assessment assessment : allAssessments) {
            threeInOne.updateAssessment(assessment);
        }
        System.out.println(threeInOne.getExpectedFinalGrade("Pass", 90));

        AbstractModule logic = new ComputingModule("Logic", 40);
        CW1 = new CourseWork("Logic Test", 14, 20, 15);
        allAssessments = new ArrayList<>(Arrays.asList(CW1));
        for (Assessment assessment : allAssessments) {
            logic.updateAssessment(assessment);
        }
        System.out.println(logic.getExpectedFinalGrade("Pass", 85));

        JMC1 ff519 = new JMC1("Feifan Fan");
        ff519.updateModules(analysis);
        ff519.updateModules(calculus);
        ff519.updateModules(threeInOne);
        ff519.updateModules(logic);
        System.out.println(ff519.getTranscript());
    }
}

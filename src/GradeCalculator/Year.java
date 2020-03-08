package GradeCalculator;

import GradeCalculator.Year1.Modules.ComputingModule;
import GradeCalculator.Year1.Modules.MathsModule;
import GradeCalculator.Year1.Modules.Module;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Year {
    private final String name;
    private final Map<Module, Double> modules;
    private double finalMark;
    private String finalGrade;
    private List<Module> allModules;

    public Year(String name) {
        this.name = name;
        this.finalMark = 0;
        this.finalGrade = "Fail";
        this.modules = new HashMap<>();
        allModules = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public double getFinalMark() {
        return finalMark;
    }

    public void updateGrade() {
        double passMark = 40;
        if (finalMark < passMark) {
            finalGrade = "Fail";
        } else if (finalMark < 50) {
            finalGrade = "3rd Degree";
        } else if (finalMark < 60) {
            finalGrade = "2:2 Degree";
        } else if (finalMark < 70) {
            finalGrade = "2:1 Degree";
        } else {
            finalGrade = "1st Degree";
        }
    }

    public void updateModules(Module module) {
        modules.put(module, module.getFinalMark());
        finalMark += module.getFinalMark();
        updateGrade();
        allModules.add(module);
    }

    public String getFinalGrade() {
        boolean allPassed = allModules.stream().noneMatch(module -> module.getFinalMark() < module.getPassMark());
        if (allPassed) {
            return finalGrade;
        } else {
            return "Fail";
        }
    }

    public List<Module> getAllModules() {
        return allModules;
    }

    public List<Module> getAllMathsModules() {
        List<Module> mathsModules = new ArrayList<>();
        for (Module module : allModules) {
            if (module instanceof MathsModule) {
                mathsModules.add(module);
            }
        }
        return mathsModules;
    }

    public List<Module> getAllComputingModules() {
        List<Module> computingModules = new ArrayList<>();
        for (Module module : allModules) {
            if (module instanceof ComputingModule) {
                computingModules.add(module);
            }
        }
        return computingModules;
    }

    public String getTranscript() {
        StringBuilder result = new StringBuilder();
        result.append("The name of the student is: ");
        result.append(name);
        result.append("\n");
        for (Module module : getAllComputingModules()) {
            result.append(module.getModuleName());
            result.append(": ");
            result.append(modules.get(module));
            result.append(" / 100");
            result.append("\n");
        }
        for (Module module : getAllMathsModules()) {
            result.append(module.getModuleName());
            result.append(": ");
            result.append(modules.get(module));
            result.append(" / 100");
            result.append("\n");
        }
        result.append("Final Mark: ");
        result.append(finalMark / getAllModules().size());
        result.append("\n");
        result.append("The final grade is: ");
        result.append(getFinalGrade());
        return result.toString();
    }
}

package Year1.Assessments;

public abstract class Assessment {
    private String name;
    private double mark;
    private double fullMark;
    private double weight;

    public Assessment(String name, double mark, double fullMark, double weight){
        this.name = name;
        this.mark = mark;
        this.fullMark = fullMark;
        this.weight = weight;
    }

    public double getMark(){
        return this.mark;
    }

    public double getContribution(){
        return mark / fullMark * weight;
    }

    @Override
    public String toString() {
        return name;
    }
}

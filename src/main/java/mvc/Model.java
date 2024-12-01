package mvc;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private List<Double> xValues;
    private List<Double> yValues;

    public Model() {
        xValues = new ArrayList<>();
        yValues = new ArrayList<>();
    }

    public void addData(double x) {
        xValues.add(x);
        yValues.add(calculateY(x));
    }

    public void editData(int index, double newX) {
        xValues.set(index, newX);
        yValues.set(index, calculateY(newX));
    }

    public void removeData(int index) {
        xValues.remove(index);
        yValues.remove(index);
    }

    private double calculateY(double x) {
        return 2*(x * x); // y = 2x^2
    }

    public List<Double> getXValues() {
        return xValues;
    }

    public List<Double> getYValues() {
        return yValues;
    }
}

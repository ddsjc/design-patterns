package mvc;
import java.util.List;

public class Controller {
    private Model model;

    public Controller(Model model) {
        this.model = model;
    }

    public void addData(double x) {
        model.addData(x);
    }

    public void editData(int index, double newX) {
        model.editData(index, newX);
    }

    public void removeData(int index) {
        model.removeData(index);
    }

    public List<Double> getXValues() {
        return model.getXValues();
    }

    public List<Double> getYValues() {
        return model.getYValues();
    }
}

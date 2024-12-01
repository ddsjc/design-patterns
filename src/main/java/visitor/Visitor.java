package visitor;

import factoryMethod.Car;
import factoryMethod.MotoMoto;

public interface Visitor {
    void visit(Car car);
    void visit(MotoMoto moto);
}

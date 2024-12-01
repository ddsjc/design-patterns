package visitor;

import factoryMethod.Car;
import factoryMethod.MotoMoto;

import java.util.Arrays;

public class PrintVisitor implements Visitor{
    @Override
    public void visit(Car car) {
        System.out.println(car.getQuantityModels() + " " + car.getMark() + " " + Arrays.toString(car.getAllPricesOfModels()) + " " + Arrays.toString(car.getAllModelsNames()) );
    }
    @Override
    public void visit(MotoMoto moto) {
        System.out.println(moto.getQuantityModels());
        System.out.println(moto.getMark());
        System.out.println(Arrays.toString(moto.getAllPricesOfModels()));
        System.out.println(Arrays.toString(moto.getAllModelsNames()));
    }
}

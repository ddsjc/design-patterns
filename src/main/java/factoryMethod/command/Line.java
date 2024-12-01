package factoryMethod.command;

import factoryMethod.Car;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Arrays;

public class Line implements Command, Serializable {
    @Override
    public void writeToFile(Car car, PrintWriter printWriter) throws IOException {
        printWriter.print(car.getQuantityModels());
        printWriter.print(" " + car.getMark());
        printWriter.print(" " + Arrays.toString(car.getAllModelsNames()));
        printWriter.print(" " + Arrays.toString(car.getAllPricesOfModels()));
        printWriter.println();
        printWriter.flush();
    }
}

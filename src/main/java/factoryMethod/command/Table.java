package factoryMethod.command;

import factoryMethod.Car;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Arrays;

public class Table implements Command, Serializable {
    @Override
    public void writeToFile( Car car, PrintWriter printWriter) throws IOException {
        printWriter.println(car.getQuantityModels());
        printWriter.println(car.getMark());
        printWriter.println(Arrays.toString(car.getAllModelsNames()));
        printWriter.println(Arrays.toString(car.getAllPricesOfModels()));
        printWriter.println();
        printWriter.flush();
    }
}

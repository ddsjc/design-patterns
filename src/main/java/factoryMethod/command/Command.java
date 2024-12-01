package factoryMethod.command;

import factoryMethod.Car;

import java.io.IOException;
import java.io.PrintWriter;

public interface Command {
    public void writeToFile(Car car, PrintWriter printWriter) throws IOException;
}

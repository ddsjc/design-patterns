package factoryMethod.dao;

import factoryMethod.Car;
import factoryMethod.exceptions.DuplicateModelNameException;
import factoryMethod.exceptions.ModelPriceOutOfBoundsException;

import java.io.*;
import java.util.Iterator;

public class TextFileCarDAO implements  CarDao{
    private  String fileName;

    public TextFileCarDAO(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void saveCar(Car car) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println(car.getMark());
            writer.println(car.getQuantityModels());
            for (Iterator<Car.Model> it = car.modelIterator(); it.hasNext(); ) {
                Car.Model model = it.next();
                if (model != null) {
                    writer.println(model.getName() + ", " + model.getCost());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Car loadCar() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String carMark = reader.readLine();
            String quantityModelsStr = reader.readLine();

            if (quantityModelsStr == null) {
                throw new RuntimeException("Invalid file format: missing quantity of models");
            }

            int quantityModels = Integer.parseInt(quantityModelsStr);
            Car car = new Car(carMark, quantityModels);

            for (int i = 0; i < quantityModels; i++) {
                String modelData = reader.readLine();

                if (modelData == null) {
                    throw new RuntimeException("Invalid file format: missing model data");
                }

                String[] parts = modelData.split(", ");
                String modelName = parts[0];
                double modelCost = Double.parseDouble(parts[1]);
                car.addModel(modelName, modelCost);
            }

            return car;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found: " + fileName, e);
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + fileName, e);
        } catch (NumberFormatException | DuplicateModelNameException | ModelPriceOutOfBoundsException e) {
            throw new RuntimeException("Error parsing file: " + fileName, e);
        }
    }
    }

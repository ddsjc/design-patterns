package factoryMethod;

import factoryMethod.exceptions.DuplicateModelNameException;
import factoryMethod.exceptions.ModelPriceOutOfBoundsException;
import factoryMethod.exceptions.NoSuchModelNameException;
import factoryMethod.command.Command;
import visitor.Visitor;

import java.io.*;
import java.util.Arrays;
import java.util.Iterator;

public class Car implements Transport, Cloneable, Serializable{
    private String carMark;
    private int quantityModels;
    private Model[] models;
    private Command command;

    public Car(String carMark, int quantityMarks) {
        this.carMark = carMark;
        models = new Model[quantityMarks];
        this.quantityModels = quantityMarks;
    }
    public String getMark(){
        return carMark;
    }
    public void setMark(String newMark){
        this.carMark = newMark;
    }

    @Override
    public Car clone() throws CloneNotSupportedException {
        try {
            Car clonedCar = (Car) super.clone();
            clonedCar.models = new Model[models.length];
            for (int i = 0; i < models.length; i++) {
                clonedCar.models[i] = new Model(models[i].name, models[i].cost);
            }
            return clonedCar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
    public static class Model implements Serializable{
        private String name;
        private double cost;

        public Model(String name, double cost) {
            this.name = name;
            this.cost = cost;
        }
        public String getName(){
            return name;
        }
        public Double getCost(){
            return cost;
        }
        public void setName(String newName){
            this.name = newName;
        }
        public void setCost(Double newCost){
            this.cost = newCost;
        }

        @Override
        public String toString(){
            return "Name is " + name + ", Cost is " + cost;
        }
    }
    public Memento createMemento(Car car) throws IOException {
        return new Memento(car);
    }

    public void setMemento(Memento memento) throws IOException, ClassNotFoundException {
        Car restoredCar = memento.getAuto();
        this.quantityModels = restoredCar.quantityModels;
        this.carMark = restoredCar.carMark;
        this.models = restoredCar.models;
        this.command = restoredCar.command;
    }


    public static class Memento implements Serializable{
        private final byte[] bytes;
        public Memento (Car car) throws IOException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(car);
            bytes = byteArrayOutputStream.toByteArray();
        }
        public Car getAuto() throws IOException, ClassNotFoundException {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            return (Car) objectInputStream.readObject();
        }
        public void setAuto(Car car) throws IOException, ClassNotFoundException {
            car.setMark(getAuto().carMark);
            car.models = getAuto().models;
        }
    }
    private class AutoIterator implements Iterator{
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < quantityModels && models[index] != null;
        }

        @Override
        public Model next() {
            return models[index++];
        }
    }
    public Iterator<Model> modelIterator(){
        return new AutoIterator();
    }
    public void addModel(String newModel, double cost) throws DuplicateModelNameException{
        if(cost < 0){
            throw new ModelPriceOutOfBoundsException("Model price cannot be negative!");
        }
        for (int i = 0; i < models.length; i++) {
            if (models[i] == null) {
                models[i] = new Model(newModel, cost);
                return;
            }
            if (models[i].getName().equals(newModel)) {
                throw new DuplicateModelNameException("Model with name " + newModel + " already exists!");
            }
        }
        models = Arrays.copyOf(models, models.length + 1);
        models[models.length - 1] = new Model(newModel, cost);
        quantityModels++;
    }
    public void setModel(String oldName, String newName) throws NoSuchModelNameException, DuplicateModelNameException {
        int changeModel = -1;
        if (oldName.equals(newName)) {
            return;
        }
        for(int i = 0; i < models.length; i++){
            if(models[i] != null && models[i].getName().equals(oldName)){
                changeModel = i;
            }
            if(models[i] != null && models[i].getName().equals(newName)){
                throw new DuplicateModelNameException("Model " + newName + " is exist");
            }
        }
        if(changeModel == -1) {
            throw new NoSuchModelNameException("Model " + oldName + " not found!");
        }
        models[changeModel].setName(newName);
    }

    public double getPriceOfModel(String model) throws NoSuchModelNameException{
        boolean found = false;
        for (int i = 0; i < models.length; i++){
            if(models[i] != null && models[i].getName().equals(model)){
                found = true;
                return  models[i].getCost();
            }
        }
        if(!found) {
            throw new NoSuchModelNameException("Model " + model + " not found!");
        }
        return 0;
    }

    public void setPriceOfModel(String model, double newCost) throws NoSuchModelNameException{
        boolean found = false;
        if(newCost < 0){
            throw new ModelPriceOutOfBoundsException("Model price cannot be negative!");
        }
        for (int i = 0; i < models.length; i++){
            if(models[i] != null && models[i].getName().equals(model)){
                System.out.println("New price for " + model + " is: " + newCost);
                models[i].setCost(newCost);
                found = true;
                return;
            }
        }
        if (!found){
            throw new NoSuchModelNameException("Model " + model + " not found!");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Car mark: ").append(carMark).append("\n");
        sb.append("Models:\n");
        for (Car.Model model : models) {
            if (model != null) {
                sb.append(model.getName()).append(", ").append(model.getCost()).append("\n");
            }
        }
        return sb.toString();
    }

    public double[] getAllPricesOfModels(){
        models = Arrays.copyOf(models,quantityModels);
        double[] modelPrices = new double[models.length];
        for (int i = 0; i < models.length; i++){
            if(models[i] != null){
                modelPrices[i] = models[i].getCost();
            }
        }
        return modelPrices;
    }
    public String[] getAllModelsNames() {
        models = Arrays.copyOf(models, quantityModels);
        String[] modelNames = new String[models.length];
        for (int i = 0; i < models.length; i++) {
            if (models[i] != null) {
                modelNames[i] = models[i].getName();
            }
        }
        return modelNames;
    }

    //! Исправленный метод с использованием Arrays.copyOf
    public void removeModel(String model) throws NoSuchModelNameException {
        boolean found = false;

        for (int i = 0; i < models.length; i++) {

            if (models[i] != null && models[i].getName().equals(model)) {
                System.arraycopy(models, i + 1, models, i, models.length - i - 1);
                found = true;
                models = Arrays.copyOf(models, models.length - 1);
                break;
            }
        }
        if (!found) {
            throw new NoSuchModelNameException("Model " + model + " not found!");
        }
    }

    public int getQuantityModels(){
        int newQuantityModels = models.length;
        for(int i = 0; i < models.length; i++){
            if(models[i]==null){
                newQuantityModels--;
            }
        }
        return newQuantityModels;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void print(PrintWriter printWriter) throws IOException {
        if(command != null) {
            command.writeToFile(this, printWriter);
        }
    }

    public void setPrintCommand(Command command){
        this.command = command;
    }
}

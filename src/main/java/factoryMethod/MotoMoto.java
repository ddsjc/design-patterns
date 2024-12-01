package factoryMethod;

import factoryMethod.exceptions.DuplicateModelNameException;
import factoryMethod.exceptions.ModelPriceOutOfBoundsException;
import factoryMethod.exceptions.NoSuchModelNameException;
import visitor.Visitor;

public class MotoMoto implements Transport, Cloneable{
    private String motoMark;
    private int quantityModels;
    private Model head;
    public MotoMoto(String motoMark, int quantityModels) {
        this.motoMark = motoMark;
        this.quantityModels = quantityModels;
        this.head = new Model();
        Model current = this.head;
        for (int i = 0; i < quantityModels; i++) {
            current.next = new Model();
            current.next.prev = current;
            current = current.next;
        }
        current.next = this.head;
        this.head.prev = current;
    }

    public String getMark(){
        return motoMark;
    }

    public void  setMark(String mark){
        this.motoMark = mark;
    }

    @Override
    public MotoMoto clone() throws CloneNotSupportedException {
        try {
            MotoMoto clonedMotoMoto = (MotoMoto) super.clone();
            clonedMotoMoto.head = new Model();
            Model current = head.next;
            Model clonedCurrent = clonedMotoMoto.head;
            while (current != head) {
                clonedCurrent.next = new Model(current.getName(), current.getCost());
                clonedCurrent.next.prev = clonedCurrent;
                clonedCurrent = clonedCurrent.next;
                current = current.next;
            }
            clonedCurrent.next = clonedMotoMoto.head;
            clonedMotoMoto.head.prev = clonedCurrent;
            return clonedMotoMoto;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    private class Model{
        private String name = null;
        private double cost = Double.NaN;
        private Model prev = null;
        private Model next = null;
        private Model(){
            this.name = null;
            this.cost = Double.NaN;
            this.prev = null;
            this.next = null;
        }
        private Model(String name, double cost) {
            this.name = name;
            this.cost = cost;
            this.prev = null;
            this.next = null;
        }
        private String getName(){
            return name;
        }
        private double getCost(){
            return cost;
        }
        private void setName(String newName){
            this.name = newName;
        }
        private void setCost(double newCost){
            this.cost = newCost;
        }
    }

    public void addModel(String newModel, double cost) throws DuplicateModelNameException, ModelPriceOutOfBoundsException {
        Model current = head.next;

        if(cost < 0){
            throw new ModelPriceOutOfBoundsException("Model price cannot be negative!");
        }

        while (current != head) {
            if (current.getName() == null) {
                current.setName(newModel);
                current.setCost(cost);
                return;
            }
            if (current.getName() != null && current.getName().equals(newModel)) {
                throw new DuplicateModelNameException("Model with name " + newModel + " already exists!");
            }
            current = current.next;
        }

        Model addModel = new Model(newModel, cost);
        addModel.next = head;
        addModel.prev = head.prev;
        head.prev.next = addModel;
        head.prev = addModel;
        quantityModels++;
    }
    public void setModel(String oldName, String newName) throws NoSuchModelNameException, DuplicateModelNameException {
        Model current = head.next;
        Model changeName = null;
        while (current != head){
            if(current.getName().equals(oldName)){
                changeName = current;
            }
            if(current.getName().equals(newName)){
                throw new DuplicateModelNameException("Model " + newName + " is exist");
            }
            current = current.next;
        }
        if(changeName == null) {
            throw new NoSuchModelNameException("Model " + oldName + " not found!");
        }
        changeName.setName(newName);
    }
    public double getPriceOfModel(String model) throws NoSuchModelNameException {
        boolean found = false;
        Model current = head.next;
        while (current != head){
            if(current.getName().equals(model)){
                found = true;
                return current.getCost();
            }
            current = current.next;
        }
        if(!found) {
            throw new NoSuchModelNameException("Model " + model + " not found!");
        }
        return -1;
    }
    public void setPriceOfModel(String model, double newCost)  throws NoSuchModelNameException, ModelPriceOutOfBoundsException {
        Model current = head.next;
        boolean found = false;
        while (current != head ){
            if(current.getName().equals(model)){
                if(newCost < 0){
                    throw new ModelPriceOutOfBoundsException("Model price cannot be negative!");
                }
                current.setCost(newCost);
                return;
            }
            current = current.next;
        }
        if(!found){
            throw new NoSuchModelNameException("Model " + model + " not found!");
        }
    }

    public double[] getAllPricesOfModels(){
        double[] modelPrices = new double[quantityModels];
        Model current = head.next;
        int index = 0;
        while (current != head && index < quantityModels){
            modelPrices[index] = current.getCost();
            current = current.next;
            index++;
        }
        return modelPrices;
    }
    public String[] getAllModelsNames() {
        String[] newModels = new String[quantityModels];
        Model current = head.next;
        int index = 0;
        while (current != head && index < quantityModels) {
            newModels[index] = current.getName();
            current = current.next;
            index++;
        }
        return newModels;
    }
    public void removeModel(String model) throws NoSuchModelNameException {
        boolean found = false;
        Model point = head.next;
        while (point != head){
            if(point.getName().equals(model)) {
                System.out.println("Model : " + model + " removed!");
                point.prev.next = point.next;
                point.next.prev = point.prev;
                quantityModels--;
                found = true;
                break;
            }
            point = point.next;
        }
        if(!found){
            throw new NoSuchModelNameException("Model " + model + " not found!");
        }
    }
    public int getQuantityModels(){
        return countModels();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    private int countModels() {
        int count = 0;
        Model current = head.next;
        while (current != head) {
            count++;
            current = current.next;
        }
        return count;
    }
}

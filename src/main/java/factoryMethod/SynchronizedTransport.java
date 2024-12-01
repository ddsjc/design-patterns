package factoryMethod;

import factoryMethod.exceptions.DuplicateModelNameException;
import factoryMethod.exceptions.NoSuchModelNameException;
import visitor.Visitor;

public class SynchronizedTransport implements Transport{

    private Transport originalTransport;

    public SynchronizedTransport(Transport originalTransport) {
        this.originalTransport = originalTransport;
    }

    @Override
    public synchronized String getMark() {
        return originalTransport.getMark();
    }

    @Override
    public synchronized void setMark(String mark) {
        originalTransport.setMark(mark);
    }

    @Override
    public synchronized void addModel(String modelName, double cost) throws DuplicateModelNameException {
        originalTransport.addModel(modelName, cost);
    }

    @Override
    public synchronized void setModel(String oldModelName, String newModelName) throws NoSuchModelNameException, DuplicateModelNameException {
        originalTransport.setModel(oldModelName, newModelName);
    }

    @Override
    public synchronized double getPriceOfModel(String modelName) throws NoSuchModelNameException {
        return originalTransport.getPriceOfModel(modelName);
    }

    @Override
    public synchronized void setPriceOfModel(String modelName, double newPrice) throws NoSuchModelNameException {
        originalTransport.setPriceOfModel(modelName, newPrice);
    }

    @Override
    public synchronized double[] getAllPricesOfModels() {
        return originalTransport.getAllPricesOfModels();
    }

    @Override
    public synchronized String[] getAllModelsNames() {
        return originalTransport.getAllModelsNames();
    }

    @Override
    public synchronized void removeModel(String modelName) throws NoSuchModelNameException {
        originalTransport.removeModel(modelName);
    }

    @Override
    public synchronized int getQuantityModels() {
        return originalTransport.getQuantityModels();
    }

    @Override
    public synchronized void accept(Visitor visitor) {
        originalTransport.accept(visitor);
    }
}

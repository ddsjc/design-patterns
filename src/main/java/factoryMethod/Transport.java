package factoryMethod;

import factoryMethod.exceptions.DuplicateModelNameException;
import factoryMethod.exceptions.NoSuchModelNameException;
import visitor.Visitor;

public interface Transport {
    String getMark();
    void setMark(String mark);
    void addModel(String modelName, double cost) throws DuplicateModelNameException;
    void setModel(String oldModelName, String newModelName) throws NoSuchModelNameException, DuplicateModelNameException ;
    double getPriceOfModel(String modelName) throws NoSuchModelNameException;
    void setPriceOfModel(String modelName, double newPrice) throws NoSuchModelNameException;
    double[] getAllPricesOfModels();
    String[] getAllModelsNames();
    void removeModel(String modelName) throws NoSuchModelNameException;
    int getQuantityModels();
    void accept(Visitor visitor);
}

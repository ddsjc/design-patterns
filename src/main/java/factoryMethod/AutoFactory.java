package factoryMethod;

public class AutoFactory implements TransportFactory{
    @Override
    public Transport createInstance(String carMark, int quantityModels) {
        return new Car(carMark, quantityModels);
    }
}

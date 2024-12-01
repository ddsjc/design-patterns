package factoryMethod;

public class MotoFactory implements TransportFactory{
    @Override
    public Transport createInstance(String carMark, int quantityModels) {
        return new MotoMoto(carMark, quantityModels);
    }
}

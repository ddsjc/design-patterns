package factoryMethod;

public interface TransportFactory {
    Transport createInstance(String carMark, int quantityModels);
}

package factoryMethod;

public class TransportUtils {

    private static TransportFactory factory = new AutoFactory();
    public static void setFactory(TransportFactory transportFactory){
        factory = transportFactory;
    }
    public static Transport createInstance(String mark, int quantityModels){
        return  factory.createInstance(mark, quantityModels);
    }
    public static double calculateAverageCost(Transport transport){
        double[] prices = transport.getAllPricesOfModels();
        double sum = 0;
        for(int i = 0; i < prices.length; i++){
            sum += prices[i];
        }
        return sum / prices.length;
    }
    public static void getAllModelsNameAndPrices(Transport transport){
        String[] names = transport.getAllModelsNames();
        double[] prices = transport.getAllPricesOfModels();

        System.out.println("Models and prices brand of " + transport.getMark() + " :");
        for(int i = 0; i < names.length; i++){
            System.out.println("Model :" + names[i] + " -- Cost :" + prices[i]);
        }
    }
    public static Transport synchronizedTransport(Transport transport){
        return new SynchronizedTransport(transport);
    }
}

package factoryMethod.chainOfResponsibility;

import factoryMethod.Transport;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Line implements Chain{
    private Chain next;
    @Override
    public void writeToFile(Transport transport) throws IOException {
        int quantityModels = transport.getQuantityModels();
        if(quantityModels <= 3){
            FileWriter fileWriter = new FileWriter("src/main/java/factoryMethod/chainOfResponsibility/output.txt");
            fileWriter.write(transport.getMark() + " " + quantityModels + " " + Arrays.toString(transport.getAllModelsNames()) + " " + Arrays.toString(transport.getAllPricesOfModels()));
            fileWriter.close();
        }
        else {
            next.writeToFile(transport);
        }
    }
    @Override
    public void setNext(Chain next) {
        this.next = next;
    }

}

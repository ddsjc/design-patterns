package factoryMethod.chainOfResponsibility;

import factoryMethod.Transport;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Table implements Chain{
    private Chain next;
    @Override
    public void writeToFile(Transport transport) throws IOException {
        int quantityModels = transport.getQuantityModels();
        if(quantityModels > 3){
            FileWriter fileWriter = new FileWriter("src/main/java/factoryMethod/chainOfResponsibility/output.txt");
            fileWriter.write(transport.getMark() + "\n" + transport.getQuantityModels() + "\n" + Arrays.toString(transport.getAllModelsNames()) + "\n" + Arrays.toString(transport.getAllPricesOfModels()));
            fileWriter.close();
        }
        else{
            if(next != null){
                next.writeToFile(transport);
            }
        }
    }
    
    @Override
    public void setNext(Chain next) {
        this.next = next;
    }
}

package factoryMethod.chainOfResponsibility;

import factoryMethod.Transport;

import java.io.IOException;

public interface Chain {
    public void writeToFile(Transport transport) throws IOException;
    public void  setNext(Chain next);
}

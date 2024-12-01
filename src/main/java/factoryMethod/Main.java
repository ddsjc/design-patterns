package factoryMethod;

import factoryMethod.dao.CarDao;
import factoryMethod.dao.SerializedCarDAO;
import factoryMethod.dao.TextFileCarDAO;
import factoryMethod.exceptions.DuplicateModelNameException;
import factoryMethod.exceptions.NoSuchModelNameException;
import factoryMethod.chainOfResponsibility.Chain;
import factoryMethod.chainOfResponsibility.Line;
import factoryMethod.chainOfResponsibility.Table;
import visitor.PrintVisitor;
import visitor.Visitor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws IOException {

        Car car2 = new Car("Lada", 3);
        MotoMoto moto1 = new MotoMoto("Kawasaki", 3);

        //Добавление моделей car
        try{
            car2.addModel("Niva", 700000);
            car2.addModel("Kalina", 800000);
            car2.addModel("Priora", 1200000);
            car2.addModel("2107", 1200000);
            //car2.addModel("Niva", 700000); //Проверка исключения
        }catch (DuplicateModelNameException e){
            System.err.println("Error : " + e.getMessage());
        }

        //Получение названия всех моделей класса car
        System.out.println("All models of the brand " + car2.getMark() + " is :\n" + Arrays.toString(car2.getAllModelsNames()));

        //Изменение названия модели car
        try{
            car2.setModel("2107", "2110"); //2107 na 2110
            //car2.setModel("2108", "2110"); //Проверка исключения
        }catch (NoSuchModelNameException e){
            System.err.println("Error : " + e.getMessage());
        }catch (DuplicateModelNameException e) {
            System.err.println("Error: " + e.getMessage());
        }

        //Получение названия всех моделей класса car
        System.out.println("All models of the brand " + car2.getMark() + " is :\n" + Arrays.toString(car2.getAllModelsNames()));

        //Получение цены по названию car
        try{
            System.out.println("Price of model " + car2.getMark() + " is :\n" + car2.getPriceOfModel("2110"));
            //System.out.println(car2.getPriceOfModel("2111"));
        }catch (NoSuchModelNameException e){
            System.err.println("Error : " + e.getMessage());
        }

        //Получение всех цен car
        System.out.println("All prices of the brand " + car2.getMark() + " :\n" + Arrays.toString(car2.getAllPricesOfModels()));

        //Изменение цены по названию car:
        try{
            car2.setPriceOfModel("2110", 650000);
            //car2.setPriceOfModel("2111", 650000); //Проверка исключения
            //car2.setPriceOfModel("2110", -230000); //Проверка исключения
        }catch (NoSuchModelNameException e){
            System.err.println("Error : " + e.getMessage());
        }

        System.out.println("All prices of the brand " + car2.getMark() + " :\n" + Arrays.toString(car2.getAllPricesOfModels()));

        //Удаление модели по названию
      /*  try{
            car2.removeModel("2111");
        }catch (NoSuchModelNameException e){
            System.err.println("Error : " + e.getMessage());
        }
     */
        //Вывод количества моделей
        System.out.println("Quantity models of " + car2.getMark() + " is : " + car2.getQuantityModels());

        //Добавление моделей класса moto
        try{
            moto1.addModel("Ninja", 450000);
            moto1.addModel("Z650", 250000);
            moto1.addModel("T630", 950000);
            moto1.addModel("KX65", 250000);
            //moto1.addModel("Ninja", 450000); //Проверка исключения
        }catch (DuplicateModelNameException e){
            System.err.println("Error : " + e.getMessage());
        }

        //Получение названия всех моделей класса moto
        System.out.println("All models of the brand " + moto1.getMark() + " is :\n" + Arrays.toString(moto1.getAllModelsNames()));

        //Изменение названия модели moto
        try{
            moto1.setModel("KX65", "kx60");
            //moto1.setModel("2108", "2110"); //Проверка исключения
        }catch (NoSuchModelNameException e){
            System.err.println("Error : " + e.getMessage());
        }catch (DuplicateModelNameException e){
            System.err.println("Error : " + e.getMessage());
        }

        //Получение названия всех моделей класса moto
        System.out.println("All models of the brand " + moto1.getMark() + " is :\n" + Arrays.toString(moto1.getAllModelsNames()));

        //Получение цены по названию moto
        try{
            System.out.println("Price of model " + moto1.getMark() + " is :\n" + moto1.getPriceOfModel("Ninja"));
            //System.out.println(car2.getPriceOfModel("2111"));//Проверка исключения
        }catch (NoSuchModelNameException e){
            System.err.println("Error : " + e.getMessage());
        }

        //Получение всех цен moto
        System.out.println("All prices of the brand " + moto1.getMark() + " :\n" + Arrays.toString(moto1.getAllPricesOfModels()));

        //Изменение цены по названию moto:
        try{
            moto1.setPriceOfModel("Ninja", 650000);
            //moto1.setPriceOfModel("2111", 650000); //Проверка исключения
            //moto1.setPriceOfModel("Ninja", -230000); //Проверка исключения
        }catch (NoSuchModelNameException e){
            System.err.println("Error : " + e.getMessage());
        }

        //Удаление модели по названию
       /* try{
            moto1.removeModel("2111");
        }catch (NoSuchModelNameException e){
            System.err.println("Error : " + e.getMessage());
        }*/

        //Вывод количества моделей
        System.out.println("Quantity models of " + moto1.getMark() + " is : " + moto1.getQuantityModels());

        double averageCost = TransportUtils.calculateAverageCost(moto1);
        System.out.println("Average cost is : " + averageCost);

        TransportUtils.getAllModelsNameAndPrices(car2);

        TransportUtils.setFactory(new MotoFactory());
        Transport moto = TransportUtils.createInstance("Kawasasaki", 4);
        System.out.println(moto.getClass());
        try{
            moto.addModel("Ninja1", 450000);
            moto.addModel("Z6502", 250000);
            moto.addModel("T6303", 950000);
            moto.addModel("KX654", 250000);
            //moto1.addModel("Ninja", 450000); //Проверка исключения
        }catch (DuplicateModelNameException e) {
            System.err.println("Error : " + e.getMessage());
        }
        TransportUtils.getAllModelsNameAndPrices(moto);

        TransportUtils.setFactory(new AutoFactory());
        Transport auto = TransportUtils.createInstance("Toyota", 3);
        System.out.println(auto.getClass());
        try{
            auto.addModel("Camry", 450000);
            auto.addModel("Supra", 250000);
            auto.addModel("Rav", 950000);
        }catch (DuplicateModelNameException e) {
            System.err.println("Error : " + e.getMessage());
        }
        TransportUtils.getAllModelsNameAndPrices(auto);

        double averageCost1 = TransportUtils.calculateAverageCost(auto);
        System.out.println("Average cost is : " + averageCost1);

        Car car3 = null;
        try {
            car3 = car2.clone();
            TransportUtils.getAllModelsNameAndPrices(car3);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        TransportUtils.getAllModelsNameAndPrices(car2);
        TransportUtils.getAllModelsNameAndPrices(car3);

        try{
            car2.setModel("Niva", "Kalina");
        }catch(DuplicateModelNameException e){
            System.out.println("Ошибка дубликат");
        }catch (NoSuchModelNameException e){
            System.out.println("Ошибка");
        }
        TransportUtils.getAllModelsNameAndPrices(car2);
        TransportUtils.getAllModelsNameAndPrices(car3);

        System.out.println("Оригинальный объект");
        TransportUtils.getAllModelsNameAndPrices(moto1);
        MotoMoto moto3 = null;
        try {
            System.out.println("Клонированый объект");
            moto3 = moto1.clone();
            TransportUtils.getAllModelsNameAndPrices(moto3);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("Оригинальный измененный");
            moto1.addModel("Nfrfrf", 350000 );
            TransportUtils.getAllModelsNameAndPrices(moto1);
            System.out.println("Клонированый неизменный");
            TransportUtils.getAllModelsNameAndPrices(moto3);
        } catch (DuplicateModelNameException e) {
            e.printStackTrace();
        }

        System.out.println("Проверка класса обертки car : " + Arrays.toString(TransportUtils.synchronizedTransport(car2).getAllModelsNames()));
        System.out.println("Проверка класса обертки moto : " + Arrays.toString(TransportUtils.synchronizedTransport(moto1).getAllModelsNames()));

        //Проверка чейн
        TransportUtils.setFactory(new AutoFactory());
        Transport autoChain = TransportUtils.createInstance("Chevrolet", 3);
        try {
            autoChain.addModel("Camaro", 450000);
            autoChain.addModel("Niva", 250000);
            autoChain.addModel("Aveo", 950000);
            autoChain.addModel("Cruze", 950000);
        }catch (DuplicateModelNameException e){
            System.out.println(e.getMessage());
        }
        Chain line = new Line();
        Chain table = new Table();

        line.setNext(table); //Последовательность

        try {
            line.writeToFile(autoChain);
        }catch (IOException e){
            System.out.println("Ошибка записи в файл!");
        }


        //Проверка Command
        car2.setPrintCommand(new factoryMethod.command.Table());
        try{
            PrintWriter printWriter = new PrintWriter("src/main/java/factoryMethod/command/outputx.txt");
            car2.print(printWriter);
        }catch (IOException e){
            System.out.println("Ошибка!");
        }

        System.out.println("===============ПРОВЕРКА ИТЕРАТОРА=================");
        Iterator<Car.Model> iterator = car2.modelIterator();
        while(iterator.hasNext()){
            Car.Model model = iterator.next();
            System.out.println(model.toString());
        }

        System.out.println("================ПРОВЕРКА МЕМЕНТО===================");
        Car.Memento memento = car2.createMemento(car2);
        try {
            car2.setPriceOfModel("Niva", 5000000);
            System.out.println("Модели с измененной ценой : " + Arrays.toString(car2.getAllPricesOfModels()));
            car2.setMemento(memento);
            System.out.println("Восстановленные модели :" + Arrays.toString(car2.getAllPricesOfModels()));
            Car toyotaRestored = memento.getAuto();
            toyotaRestored.setMark("ToyotaRestored");
            System.out.println("Восстановленная модель :" + toyotaRestored.getMark() + "\n"+ Arrays.toString(toyotaRestored.getAllPricesOfModels()));
        }catch (NoSuchModelNameException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println("=================ПРОВЕРКА ВИЗИТОРА==================");
        PrintVisitor visitor1 = new PrintVisitor();
        System.out.println("Для мотосайкла : ");
        moto1.accept(visitor1);
        System.out.println("Для машинки : ");
        car2.accept(visitor1);

        System.out.println("===================ПРОВЕРКА DAO=====================");
        CarDao serializedDao = new SerializedCarDAO("serialized_car.dat");
        CarDao textFileDao = new TextFileCarDAO("text_car.txt");
        serializedDao.saveCar(car2);
        textFileDao.saveCar(car2);
        Car loadedSerializedCar = serializedDao.loadCar();
        Car loadedTextFileCar = textFileDao.loadCar();
        System.out.println("Serialized car: " + loadedSerializedCar);
        System.out.println("Text file car: " + loadedTextFileCar);
    }
}

package singleton;

public class Main {
    public static void main(String[] args) {
        Singleton single1 = Singleton.getInstance();
        Singleton single2 = Singleton.getInstance();
        System.out.println("DataBase host is: " + single1.getProperty("db.host"));
        System.out.println("DataBase login is: " + single2.getProperty("db.login"));
        System.out.println("DataBase password is: " + single1.getProperty("db.password"));
        System.out.println("Single1 token is : " + single1.toString());
        System.out.println("Single2 token is : "+ single2.toString());
    }
}
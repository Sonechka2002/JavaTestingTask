package javaCoreTasks.singleton;

public class SingletonTest {
    public static void main(String[] args) {
        DatabaseConnection db1 = DatabaseConnection.getInstance();
        DatabaseConnection db2 = DatabaseConnection.getInstance();

        System.out.println("db1 == db2: " + (db1 == db2));

        db1.connect();
    }
}

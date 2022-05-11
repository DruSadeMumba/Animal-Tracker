import org.sql2o.Sql2o;

public class DB {
    /*public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker", null, null);*/
/*
    static String connectionString = "jdbc:postgresql://ec2-34-236-94-53.compute-1.amazonaws.com:5432/d2lajsvmr7vl06";
    public static Sql2o sql2o = new Sql2o(connectionString, "mzpamolmgkdtkl", "c0a03c32de7bbd946d36bba6a19df953546104d33d9df1b5a968543b28a173e4");
*/
    public static String connectionString = "jdbc:postgresql://ec2-34-236-94-53.compute-1.amazonaws.com:5432/d2lajsvmr7vl06";
    public static Sql2o sql2o = new Sql2o(connectionString, "mzpamolmgkdtkl", "c0a03c32de7bbd946d36bba6a19df953546104d33d9df1b5a968543b28a173e4");

/*
    public static Sql2o sql2o = new Sql2o("jdbc:postgresql://ec2-34-236-94-53.compute-1.amazonaws.com:5432/d2lajsvmr7vl06", "mzpamolmgkdtkl", "c0a03c32de7bbd946d36bba6a19df953546104d33d9df1b5a968543b28a173e4");
*/

}











//1. jdbc:postgres://
//2. Host
//3.:port
//4.database
//5. user
//6.password
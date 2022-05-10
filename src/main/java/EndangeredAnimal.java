import org.sql2o.Connection;

import java.util.List;

public class EndangeredAnimal extends Animal {
    private String health;
    private String age;
    public static final String DATABASE_TYPE = "endangered";

    //getters
    public String getHealth() {return health;}
    public String getAge() {return age;}

    //setters
    public void setHealth(String health) {this.health = health;}
    public void setAge(String age) {this.age = age;}

    public EndangeredAnimal(String name, String age, String health, int sightingId){
        this.name = name;
        this.sightingId = sightingId;
        type = DATABASE_TYPE;
        this.age = age;
        this.health = health;
    }
    @Override
    public boolean equals(Object otherEndangeredAnimal){
        if (!(otherEndangeredAnimal instanceof EndangeredAnimal newEndangeredAnimal)) {
            return false;
        } else {
            return this.getName().equals(newEndangeredAnimal.getName()) &&
                    this.getAge() == newEndangeredAnimal.getAge() &&
                    this.getSightedon() == newEndangeredAnimal.getSightedon() &&
                    this.getHealth() == newEndangeredAnimal.getHealth();
        }
    }
    public static List<EndangeredAnimal> all() {
        String sql = "SELECT * FROM animals WHERE type = 'endangered'; ";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(EndangeredAnimal.class);
        }
    }
    public static EndangeredAnimal find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM animals where id=:id";
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(EndangeredAnimal.class);
        }
    }
}

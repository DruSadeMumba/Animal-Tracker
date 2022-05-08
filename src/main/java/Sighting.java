import org.sql2o.Connection;

import java.util.ArrayList;
import java.util.List;

public class Sighting implements DatabaseManagement{
    private int id;
    private int animalId;
    private String location;
    private String rangerName;

    public Sighting (String location, String rangerName){
        this.location = location;
        this.rangerName = rangerName;
    }
    
    //getters
    public int getId() {return id;}
    public int getAnimalId() {return animalId;}
    public String getLocation() {return location;}
    public String getRangerName() {return rangerName;}
    
    //setters
    public void setId(int id) {this.id = id;}
    public void setAnimalId(int animalId) {this.animalId = animalId;}
    public void setLocation(String location) {this.location = location;}
    public void setRangerName(String rangerName) {this.rangerName = rangerName;}

    @Override
    public boolean equals(Object otherSightings) {
        if (!(otherSightings instanceof Sighting newSightings)) {
            return false;
        } else {
            return this.getLocation().equals(newSightings.getLocation()) &&
                    this.getRangerName().equals(newSightings.getRangerName());
        }
    }
    @Override
    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO sightings (location, rangername) VALUES (:location, :rangername)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("location", this.location)
                    .addParameter("rangername", this.rangerName)
                    .executeUpdate()
                    .getKey();
        }
    }
    public static List<Sighting> all() {
        String sql = "SELECT * FROM sightings";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Sighting.class);
        }
    }
    public static Sighting find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM sightings where id=:id";
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Sighting.class);
        }
    }
    public List<Object> getAnimals() {
        List<Object> allAnimals = new ArrayList<>();

        try(Connection con = DB.sql2o.open()) {
            String sqlEndangered = "SELECT * FROM animals WHERE sightingId=:id AND type='endangered';";
            List<EndangeredAnimal> endangeredAnimals = con.createQuery(sqlEndangered)
                    .addParameter("id", this.id)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(EndangeredAnimal.class);
            allAnimals.addAll(endangeredAnimals);

            String sqlUnendangered = "SELECT * FROM animals WHERE sightingId=:id AND type='unendangered';";
            List<UnendangeredAnimal> unendangeredAnimals = con.createQuery(sqlUnendangered)
                    .addParameter("id", this.id)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(UnendangeredAnimal.class);
            allAnimals.addAll(unendangeredAnimals);
        }

        return allAnimals;
    }

}

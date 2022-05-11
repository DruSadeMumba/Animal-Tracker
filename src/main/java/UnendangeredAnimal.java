import org.sql2o.Connection;

import java.util.List;

public class UnendangeredAnimal extends Animal {
    public static final String DATABASE_TYPE = "safe";

    public UnendangeredAnimal(String name, int sightingId){
        this.name = name;
        this.sightingId = sightingId;
        type = DATABASE_TYPE;
    }
    @Override
    public boolean equals(Object otherUnendangeredAnimal){
        if (!(otherUnendangeredAnimal instanceof UnendangeredAnimal)) {
            return false;
        } else {
            UnendangeredAnimal newUnendangeredAnimal = (UnendangeredAnimal) otherUnendangeredAnimal;
            return this.getName().equals(newUnendangeredAnimal.getName());
        }
    }

    public static List<UnendangeredAnimal> all() {
        String sql = "SELECT * FROM animals WHERE type = 'safe'; ";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(UnendangeredAnimal.class);
        }
    }
    public static UnendangeredAnimal find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM animals where id=:id";
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(UnendangeredAnimal.class);
        }
    }
}

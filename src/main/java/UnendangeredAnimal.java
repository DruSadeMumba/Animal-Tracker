import org.sql2o.Connection;

import java.util.List;

public class UnendangeredAnimal extends Animal {
    public static final String DATABASE_TYPE = "unendangered";

    public UnendangeredAnimal(String name){
        this.name = name;
        type = DATABASE_TYPE;
    }
    @Override
    public boolean equals(Object otherUnendangeredAnimal){
        if (!(otherUnendangeredAnimal instanceof UnendangeredAnimal newUnendangeredAnimal)) {
            return false;
        } else {
            return this.getName().equals(newUnendangeredAnimal.getName());
        }
    }
    public static List<UnendangeredAnimal> all() {
        String sql = "SELECT * FROM wildlife WHERE type = 'endangered'; ";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(UnendangeredAnimal.class);
        }
    }
    public static UnendangeredAnimal find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM wildlife where id=:id";
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(UnendangeredAnimal.class);
        }
    }
}

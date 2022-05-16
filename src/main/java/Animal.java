import org.sql2o.Connection;

import java.sql.Timestamp;
import java.util.Objects;

public abstract class Animal implements DatabaseManagement{
    public String name;
    public int id;
    public String age;
    public String health;
    public int sightingId;
    public String type;
    public Timestamp sightedon;

    //getters
    public String getName() {return name;}
    public int getId() {return id;}
    public int getSightingId() {return sightingId;}
    public Timestamp getSightedon() {return sightedon;}

    //setters
    public void setName(String name) {this.name = name;}
    public void setId(int id) {this.id = id;}
    public void setSightingId(int sightingId) {this.sightingId = sightingId;}
    public void setType(String type) {this.type = type;}

    public String getHealth() {
        return health;
    }

    public String getType() {
        return type;
    }

    public String getAge() {
        return age;
    }

    public void setSightedon(Timestamp sightedon) {this.sightedon = sightedon;}

    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals (name, sightedon, type, health, age) VALUES (:name, now(), :type, :health, :age)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("type", this.type)
                    .addParameter("health", this.health)
                    .addParameter("age", this.age)
                    .executeUpdate()
                    .getKey();
        }
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, name, sightedon, health, age);
    }

}

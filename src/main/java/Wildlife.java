import java.sql.Timestamp;

public abstract class Wildlife /*implements DatabaseManagement*/{
    public String name;
    public int id;
    public String type;
    public Timestamp sightedon;

    //getters
    public String getName() {return name;}
    public int getId() {return id;}
    public Timestamp getSightedon() {return sightedon;}

    //setters
    public void setName(String name) {this.name = name;}
    public void setId(int id) {this.id = id;}
    public void setType(String type) {this.type = type;}
    public void setSightedon(Timestamp sightedon) {this.sightedon = sightedon;}
}

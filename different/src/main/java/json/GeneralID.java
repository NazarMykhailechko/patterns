package json;

import javax.persistence.*;

@MappedSuperclass
public class GeneralID {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public GeneralID() {
    }

    public long getId() {
        return id;
    }

}

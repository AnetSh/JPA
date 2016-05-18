package bankEntities;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Anet on 22.04.2016.
 */
@Entity
@Table(name = "users", schema = "", catalog = "bank")
@NamedQuery(name = "User.getAll", query = "SELECT c from User c")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name", length = 32)
    private String name;

    @Column(name = "phone", length = 13)
    private String phone;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Account> accounts;

    public User(){}

    public User(String name, String phone){
        this.name=name;
        this.phone=phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

}

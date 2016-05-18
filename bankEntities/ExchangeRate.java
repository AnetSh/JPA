package bankEntities;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Anet on 22.04.2016.
 */

@Entity
@Table(name = "rates", schema = "", catalog = "bank")
@NamedQuery(name = "ExchangeRate.getAll", query = "SELECT c from ExchangeRate c")
public class ExchangeRate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name", length = 3)
    private String name;

    @Column(name = "ratio")
    private Float ratio;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "exchangeRate")
    private Set<Account> accounts;

    public ExchangeRate() {
    }
    public ExchangeRate(String name, float ratio) {
        this.name=name;
        this.ratio=ratio;
    }

    public Set<Account> getAccount() {
        return accounts;
    }

    public void setAccount(Set<Account> accounts) {
        this.accounts = accounts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getRatio() {
        return ratio;
    }

    public void setRatio(Float ratio) {
        this.ratio = ratio;
    }

    @Override
    public String toString() {
        return "Exchange Rate{" +
                "id=" + id +
                ", ratio='" + ratio + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

}


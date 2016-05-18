package bankEntities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Anet on 22.04.2016.
 */
@Entity
@Table(name = "accounts", schema = "", catalog = "bank")
@NamedQuery(name = "Account.getAll", query = "SELECT c from Account c")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Basic
    @Column(name="cvv2")
    private int cvv2;

    @Basic
    @Column(name="amount")
    private Float amount;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "rate_id", nullable = false)
    private ExchangeRate exchangeRate;

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "account_transaction",
            //foreign key for CarsEntity in employee_car table
            joinColumns = @JoinColumn(name = "account_id"),
            //foreign key for other side - EmployeeEntity in employee_car table
            inverseJoinColumns = @JoinColumn(name = "transaction_id"))
    private Set<Transaction> transactions=new HashSet<Transaction>();

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ExchangeRate getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(ExchangeRate exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public int getCvv2() {
        return cvv2;
    }

    public void setCvv2(int cvv2) {
        this.cvv2 = cvv2;
    }

    public Account() {
    }

    public Account(int cvv2, Float amount) {
        this.cvv2=cvv2;
        this.amount=amount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", cvv2=" + cvv2 +
                ", amount=" + amount +
                " " + getExchangeRate().getName()+
                '}';
    }

}

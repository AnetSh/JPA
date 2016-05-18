package bankEntities;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Anet on 22.04.2016.
 */
@Entity
@Table(name = "transactions", schema = "", catalog = "bank")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Basic
    @Column(name = "amount")
    private Float amount;

    public Transaction(float amount, int sender, int receiver) {
        this.amount = amount;
        this.sender=sender;
        this.receiver=receiver;
    }
    @ManyToMany
    @JoinTable(name = "account_transaction",
            //foreign key for CarsEntity in employee_car table
            joinColumns = @JoinColumn(name = "transaction_id"),
            //foreign key for other side - EmployeeEntity in employee_car table
            inverseJoinColumns = @JoinColumn(name = "account_id"))
    private Set<Account> accounts;

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }

    @Basic
    @Column(name = "sender")
    private int sender;

    public int getReceiver() {
        return receiver;
    }

    public void setReceiver(int receiver) {
        this.receiver = receiver;
    }

    public int getSender() {
        return sender;
    }

    public void setSender(int sender) {
        this.sender = sender;
    }

    @Basic
    @Column(name = "receiver")
    private int receiver;


    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Transaction() {
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", amount=" + amount +
                ", sender=" + sender +
                ", receiver=" + receiver +
                '}';
    }
}

package bankServices;

import bankEntities.Account;
import bankEntities.ExchangeRate;
import bankEntities.User;


import javax.persistence.*;
import java.util.List;

/**
 * Created by Anet on 22.04.2016.
 */
public class Service {
    public EntityManager em = Persistence.createEntityManagerFactory("COLIBRI").createEntityManager();

    /**
     * Adds new item in the table.
     * @param element New item
     * @param <T> User/Transaction/Account/ExchangeRate
     * @return new item
     */
    public <T>T add(T element){
        em.getTransaction().begin();
        T elementFromDB = em.merge(element);
        em.getTransaction().commit();
        return elementFromDB;
    }

    /**
     * Deletes item from the table by id
     * @param id of item in the table
     * @param cl Type of Entity
     */
    public void delete(int id, Object cl){
        em.getTransaction().begin();
        em.remove(get(id, cl.getClass()));
        em.getTransaction().commit();
    }

//    public ExchangeRate getRate(String name){
//        return em.find(ExchangeRate.class, name);
//    }

    /**
     * Returns element (except ExchangeRate) from the table by id
     * @param id ID of element in the table
     * @param cl
     * @param <T> Type of the entity
     * @return object of <T>
     */
    public <T>T get(int id, Class<T> cl){
        return em.find(cl, id);
    }

    /**
     * Updates items in the table
     * @param element Object from database
     */
    public void update(Object element){
        em.getTransaction().begin();
        em.merge(element);
        em.getTransaction().commit();
    }

    /**
     * Creates list of the all items in the table "users"
     * @return list of users
     */
    public List<User> getUser(){
        TypedQuery<User> namedQuery = em.createNamedQuery("User.getAll", User.class);
        return namedQuery.getResultList();
    }

    /**
     * Creates list of the all items in the table "accounts"
     * @return list of accounts
     */
    public List<Account> getA(){
        TypedQuery<Account> namedQuery = em.createNamedQuery("Account.getAll", Account.class);
        return namedQuery.getResultList();
    }

    /**
     * Creates list of the all items in the table "rates"
     * @return list of rates
     */
    public List<ExchangeRate> getE(){
        TypedQuery<ExchangeRate> namedQuery = em.createNamedQuery("ExchangeRate.getAll", ExchangeRate.class);
        return namedQuery.getResultList();
    }

    /**
     * Gets the exchange rate in relation to UAH.
     * @param type Type of rate: "UAH", "USD","EUR"
     * @return ratio
     */
    public Float getRatioByName(String type){
        Float result=0f;
        List<ExchangeRate> accounts1 = getE();
        for (int i=0;i<accounts1.size();++i){
            if (accounts1.get(i).getName().equals(type)){
                result=accounts1.get(i).getRatio();
                break;
            }
        }
        return result;
    }

    /**
     * Returns element from the table "rates" by name of the exchange rate
     * @param type Type of exchange rate ("UAH", "USD","EUR")
     * @return object of ExchangeRate
     */
    public ExchangeRate getExRateByName(String type){
        ExchangeRate result=null;
        List<ExchangeRate> accounts1 = getE();
        for (int i=0;i<accounts1.size();++i){
            if (accounts1.get(i).getName().equals(type)){
                result=accounts1.get(i);
                break;
            }
        }
        return result;
    }

}

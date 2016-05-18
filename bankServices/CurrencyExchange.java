package bankServices;

import bankEntities.Account;

/**
 * Created by Anet on 22.04.2016.
 * Change the currency in the account.
 */
public class CurrencyExchange {

    /**
     * Changes Currency on EUR
     * @param account Customizable account
     * @param service Object of Service (created in the Unit test)
     * @return New amount in new type of currency on the customizable account
     */
    public static float currencyExchangeEUR(Account account, Service service){
        float secondAmount=0;
        String type=account.getExchangeRate().getName();
        if(type.equals("UAH")){
            secondAmount=account.getAmount()/service.getRatioByName("EUR");
        }
        if(type.equals("USD")){
            secondAmount=(account.getAmount()*service.getRatioByName("USD"))/service.getRatioByName("EUR");
        }
        if(type.equals("EUR")){
            secondAmount=account.getAmount();
        }
        return secondAmount;
    }

    /**
     * Changes Currency on EUR
     * @param account Customizable account
     * @param service Object of Service (created in the Unit test)
     * @return New amount in new type of currency on the customizable account
     */
    public static float currencyExchangeUSD(Account account, Service service){
        float secondAmount=0;
        String type=account.getExchangeRate().getName();
        if(type.equals("UAH")){
            secondAmount=account.getAmount()/service.getRatioByName("USD");
        }
        if(type.equals("USD")){
            secondAmount=account.getAmount();
        }
        if(type.equals("EUR")){
            secondAmount=(account.getAmount()*service.getRatioByName("EUR"))/service.getRatioByName("USD");
        }
        return secondAmount;
    }

    /**
     * Changes Currency on UAH
     * @param account Customizable account
     * @param service Object of Service (created in the Unit test)
     * @return New amount in new type of currency on the customizable account
     */
    public static float currencyExchangeUAH(Account account, Service service){
        float secondAmount=0;
        String type=account.getExchangeRate().getName();
        if(type.equals("UAH")){
            secondAmount=account.getAmount();
        }
        if(type.equals("USD")){
            secondAmount=account.getAmount()*service.getRatioByName("USD");
        }
        if(type.equals("EUR")){
            secondAmount=account.getAmount()*service.getRatioByName("EUR");
        }
        return secondAmount;
    }
}

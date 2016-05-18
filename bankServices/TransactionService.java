package bankServices;

import bankEntities.Account;

/**
 * Created by Anet on 22.04.2016.
 * Transaction processing.
 */
public class TransactionService {

    /**
     * Transfers money from one account to another.
     * @param amount Transfer amount of money.
     * @param sender Account that send money.
     * @param receiver Account that receive money.
     */
    public static void moneyTransfer(float amount, Account sender, Account receiver){
        if(sender.getAmount()>=amount){
            sender.setAmount(sender.getAmount()-amount);
            receiver.setAmount(receiver.getAmount()+amount);
        }
    }

    /**
     * Checks the currency type in the account.
     * If it does not meet the specified transaction currency, exchange money for the specified type.
     * @param sender Account that send money.
     * @param receiver Account that receive money.
     * @param type Transaction currency
     * @param service Object of Service (created in the Unit test)
     */
    public static void checkType(Account sender, Account receiver, String type, Service service){
        if(type.equals("UAH")){
            if(!sender.getExchangeRate().getName().equals(type)){
                sender.setAmount(CurrencyExchange.currencyExchangeUAH(sender, service));
            }
            if(!receiver.getExchangeRate().getName().equals(type)){
                receiver.setAmount(CurrencyExchange.currencyExchangeUAH(receiver, service));
            }
            sender.setExchangeRate(service.getExRateByName("UAH"));
            receiver.setExchangeRate(service.getExRateByName("UAH"));
        }
        if(type.equals("USD")){
            if(!sender.getExchangeRate().getName().equals(type)){
                sender.setAmount(CurrencyExchange.currencyExchangeUSD(sender,service));
            }
            if(!receiver.getExchangeRate().getName().equals(type)){
                receiver.setAmount(CurrencyExchange.currencyExchangeUSD(receiver, service));
            }
            sender.setExchangeRate(service.getExRateByName("USD"));
            receiver.setExchangeRate(service.getExRateByName("USD"));
        }
        if(type.equals("EUR")){
            if(!sender.getExchangeRate().getName().equals(type)){
                sender.setAmount(CurrencyExchange.currencyExchangeEUR(sender, service));
            }
            if(!receiver.getExchangeRate().getName().equals(type)){
                receiver.setAmount(CurrencyExchange.currencyExchangeEUR(receiver, service));
            }
            sender.setExchangeRate(service.getExRateByName("EUR"));
            receiver.setExchangeRate(service.getExRateByName("EUR"));
        }
    }
}

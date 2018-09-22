package money;


public class Money implements Expression{

    protected int amount;
    protected String currency;

    Money(int amount, String currency){
        this.amount = amount;
        this.currency = currency;
    }

    String currency() {
        return this.currency;
    }

    public static Money dollar(int amount){
        return new Money(amount, "USD");
    }

    public static Money franc(int amount){
        return new Money(amount, "CHF");
    }

    Money times(int multiplier){
        return new Money(amount * multiplier, currency);
    }

    Expression plus(Money addend){
        return new Sum(this, addend);
    }

    @Override
    public boolean equals(Object object){
        Money money = (Money) object;
        return amount == money.amount && currency().equals(money.currency());
    }

    @Override
    public String toString(){
        return this.amount + " "+ this.currency;
    }


}

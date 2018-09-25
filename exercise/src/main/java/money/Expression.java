package money;

/**
 * Created by masao on 2018/09/22.
 */
public interface Expression {
    Money reduce(Bank bank, String to);
    Expression plus(Expression addend);
    Expression times(int multiplier);
}

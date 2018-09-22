package money;

/**
 * Created by masao on 2018/09/22.
 */
public class Sum implements Expression{
    Money augend;
    Money addend;

    Sum(Money augend, Money addend){
        this.augend = augend;
        this.addend = addend;
    }
}

/**
 * Created by masao on 2018/09/29.
 */
public class VendingMachine {

    private int amount;

    public DrinkItem buttonPush(DrinkType drinkType){
        if( amount >= drinkType.price() ){
            amount -= drinkType.price();
            return new DrinkItem(drinkType);
        }
        return null;
    }


    public void insert100Yen(){
        amount += 100;
    }
    public int getAmount(){
        return amount;
    }
}

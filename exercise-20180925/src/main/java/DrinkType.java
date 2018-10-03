/**
 * Created by masao on 2018/09/29.
 */
public enum DrinkType {
    COKE("コーラ", 100),
    OOLONG("ウーロン茶", 100),
    REDBULL("レッドブル", 200);

    private final String drinkName;
    private final int price;

    private DrinkType(String drinkName, int price) {
        this.drinkName = drinkName;
        this.price = price;
    }

    public String drinkName(){
        return this.drinkName;
    }

    public int price(){
        return this.price;
    }

}

/**
 * Created by masao on 2018/09/29.
 */
public class DrinkItem {

    private final DrinkType drinkType;

    public DrinkItem( DrinkType drinkType ){
        this.drinkType = drinkType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DrinkItem drinkItem = (DrinkItem) o;

        return drinkType != null ? drinkType.equals(drinkItem.drinkType) : drinkItem.drinkType == null;
    }

    @Override
    public int hashCode() {
        return drinkType != null ? drinkType.hashCode() : 0;
    }
}

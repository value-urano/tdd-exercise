
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

@RunWith(Enclosed.class)
public class VendingMachineTest {

    public static class _投入金額が0円のときのテスト{

        VendingMachine vendingMachine;

        @Before
        public void 前準備(){
            vendingMachine = new VendingMachine();
        }

        @Test
        public void 初期状態では投入金額は0円(){
            int amount = vendingMachine.getAmount();
            assertThat(amount, is(0));
        }

        @Test
        public void _100円入れないとコーラが出ない(){
            DrinkItem item = vendingMachine.buttonPush(DrinkType.COKE);
            assertNull( item );
            assertThat(item, is(nullValue()));
        }

    }

    public static class _投入金額が100円のときのテスト{

        VendingMachine vendingMachine;

        @Before
        public void 前準備(){
            vendingMachine = new VendingMachine();
            vendingMachine.insert100Yen();
        }

//    @Test
//    public void ボタンを押すとコーラが出る(){
//        DrinkItem item = vendingMachine.buttonPush();
//        assertThat( item, is(new DrinkItem("コーラ")));
//    }

//        @Test
//        public void _100円入れてからボタンを押すとコーラが出る(){
//            DrinkItem item = vendingMachine.buttonPush();
//            assertThat( item, is(new DrinkItem(DrinkType.COKE)));
//        }

        @Test
        public void _100円入れると投入金額は100円(){
            int amount = vendingMachine.getAmount();
            assertThat(amount, is(100));
        }

        @Test
        public void _100円で出るコーラは１つ(){
            DrinkItem item1 = vendingMachine.buttonPush(DrinkType.COKE);
            DrinkItem item2 = vendingMachine.buttonPush(DrinkType.COKE);
            assertThat( item1, is(new DrinkItem(DrinkType.COKE)));
            assertThat( item2, not(is(new DrinkItem(DrinkType.COKE))));
        }

        @Test
        public void ウーロン茶ボタンを押すとウーロン茶が出てくる(){
            DrinkItem item = vendingMachine.buttonPush(DrinkType.OOLONG);
            assertThat(item, is(new DrinkItem(DrinkType.OOLONG)));
        }

        @Test
        public void コーラボタンを押すとコーラが出てくる(){
            DrinkItem item = vendingMachine.buttonPush(DrinkType.COKE);
            assertThat(item, is(new DrinkItem(DrinkType.COKE)));
        }

        @Test
        public void レッドブルボタンを押してもレッドブルが出てこない(){
            DrinkItem item = vendingMachine.buttonPush(DrinkType.REDBULL);
            assertNull(item);
        }
    }

    public static class _投入金額が200円のときのテスト{

        VendingMachine vendingMachine;

        @Before
        public void 前準備(){
            vendingMachine = new VendingMachine();
            vendingMachine.insert100Yen();
            vendingMachine.insert100Yen();
        }

        @Test
        public void _100円を2枚入れると投入金額は200円(){
            int amount = vendingMachine.getAmount();
            assertThat(amount, is(200));
        }


        @Test
        public void コーラを買うと投入金額が100円減る(){
            int beforeAmount = vendingMachine.getAmount();
            vendingMachine.buttonPush(DrinkType.COKE);
            int afterAmount = vendingMachine.getAmount();
            int actual = beforeAmount - afterAmount;
            assertThat( actual , is (100));
        }

        @Test
        public void レッドブルが買える(){
            DrinkItem item = vendingMachine.buttonPush(DrinkType.REDBULL);
            assertThat( item, is(new DrinkItem(DrinkType.REDBULL)));
        }

        @Test
        public void レッドブルが2本は買えない(){
            DrinkItem item1 = vendingMachine.buttonPush(DrinkType.REDBULL);
            DrinkItem item2 = vendingMachine.buttonPush(DrinkType.REDBULL);
            assertNull(item2);
        }

    }

}

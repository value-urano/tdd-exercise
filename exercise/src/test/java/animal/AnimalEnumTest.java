package animal;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by masao on 2018/09/29.
 */
public class AnimalEnumTest {

    @Test
    public void testEnumDog(){
        assertThat(AnimalEnum.DOG.text(), is("犬"));
    }

    @Test
    public void testEnumCat(){
        assertThat(AnimalEnum.CAT.text(), is("猫"));
    }

    @Test
    public void testValueOf(){
        assertThat(AnimalEnum.valueOf("DOG"), is(AnimalEnum.DOG));
    }
}

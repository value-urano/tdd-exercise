package animal;

import com.sun.xml.internal.bind.annotation.OverrideAnnotationOf;

/**
 * Created by masao on 2018/09/29.
 */
public enum AnimalEnum {
    UNKOWN(""),
    DOG("犬"),
    CAT("猫");


    private final String text;

    private AnimalEnum(String text){
        this.text = text;
    }

    public String text(){
        return this.text;
    }

}

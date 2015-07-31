package lessons3;

import lessons3.utlis.ArrayHelper;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by ruslan on 17.07.2015.
 */
public class MainLes3 {
    public static void main(String[] arsg) {
        //Student [] students = new Student[0];
        int[] mas1 = {1, 5, 4, 23, 65, 32, 1, 78};
        int[] mas2 = {3, 5, 5, 1, 24, 4, 2, 34, 45, 32, 5};

        ArrayHelper ah = new ArrayHelper();
        ah.merge(mas1, mas2);
        System.out.println();
        ah.innerUnion(mas1, mas2);
        System.out.println();
        ah.outerUnion(mas1, mas2);
        System.out.println();
        ah.withoutDuplicates(mas2);
    }
}

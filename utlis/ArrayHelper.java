package lessons3.utlis;

import arrays.ArrayHelp;
import lessons3.exception.MyNullException;
import org.mockito.internal.util.collections.ArrayUtils;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by ruslan on 17.07.2015.
 */
public class ArrayHelper {
    public int[] withoutDuplicates(int[] mas) {
        int[] result = new int[mas.length];
        Arrays.sort(mas);
        int someInt = 0;
        for (int i = 0; i < mas.length; i++) {
            if (i != mas.length - 1 && mas[i] != mas[i + 1]) {
                result[someInt] = mas[i];
                someInt++;
            } else {
                if (i == mas.length - 1) {
                    result[someInt] = mas[i];
                    someInt++;
                }
            }
        }
        int[] result2 = new int[someInt];
        System.arraycopy(result, 0, result2, 0, someInt);
        for (int i = 0; i < result2.length; i++) {
            System.out.print(result2[i] + " ");
        }
        return result2;
    }

    public int[] merge(int[] mas1, int[] mas2) {
        mas1 = validateArray(mas1);
        mas2 = validateArray(mas2);
        int[] result = new int[mas1.length + mas2.length];
        System.arraycopy(mas1, 0, result, 0, mas1.length);
        System.arraycopy(mas2, 0, result, mas1.length, mas2.length);
        int[] result2 = withoutDuplicates(result);
        return result2;
    }

    public int[] innerUnion(int[] mas1, int[] mas2) {
        mas1 = validateArray(mas1);
        mas2 = validateArray(mas2);
        int[] result = new int[mas1.length];
        Arrays.sort(mas1);
        int someInt = 0;
        for (int i = 0; i < mas1.length; i++) {
            for (int j = 0; j < mas2.length; j++) {
                if (mas1[i] == mas2[j]) {
                    result[someInt] = mas1[i];
                    someInt++;
                    break;
                }
            }
        }
        int[] result2 = new int[someInt];
        System.arraycopy(result, 0, result2, 0, someInt);
        int[] result3 = withoutDuplicates(result2);
        return result3;
    }

    public int[] outerUnion(int[] mas1, int[] mas2) {
        mas1 = validateArray(mas1);
        mas2 = validateArray(mas2);
        int[] result = new int[mas1.length + mas2.length];
        int someInt = 0;
        if (mas1.length == 0) {
            return withoutDuplicates(mas2);
        } else if (mas2.length == 0) {
            return withoutDuplicates(mas1);

        }
        for (int i = 0; i < mas1.length; i++) {
            for (int j = 0; j < mas2.length; j++) {
                if (mas1[i] == mas2[j]) break;
                if (j == mas2.length - 1) {
                    result[someInt] = mas1[i];
                    someInt++;
                }
            }
        }
        for (int i = 0; i < mas2.length; i++) {
            for (int j = 0; j < mas1.length; j++) {
                if (mas2[i] == mas1[j]) break;
                if (j == mas1.length - 1) {
                    result[someInt] = mas2[i];
                    someInt++;
                }
            }
        }

        int[] result2 = new int[someInt];
        System.arraycopy(result, 0, result2, 0, someInt);
        int[] result3 = withoutDuplicates(result2);
        return result3;
    }

    private int[] validateArray(int[] mas) {
        try {
            if (mas == null) {
                throw new MyNullException();
            }
        } catch (MyNullException exp) {
            exp.printStackTrace();
            return new int[0];
        }
        ;
        return mas;
    }

}

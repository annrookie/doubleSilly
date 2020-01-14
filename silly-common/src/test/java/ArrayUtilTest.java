import com.i2silly.common.constant.ArrayFilterEnum;
import com.i2silly.common.filter.impl.FilterEmpty;
import com.i2silly.common.util.ArrayUtil;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayUtilTest {
    @Test
    public void unWarpTest() {
        Integer[] arr = {1, 2, 3, 4};
        int[] iArr = ArrayUtil.unWarp(arr);
        System.out.println(iArr.getClass().getComponentType().getName());
    }

    @Test
    public void toStringArrTest() {
        Integer[] i = new Integer[]{12, 32, 432};
        String[] arr = ArrayUtil.toStringArr(i);
        System.out.println(Arrays.asList(arr).toString());
    }

    @Test
    public void toStringTest() {
        Map<String, String> map = new HashMap<>();
        map.put("1", "3");
        Object[] obj = {1, "2", null, map};
        Integer[] i = {1, 2, 4};
        System.out.println(ArrayUtil.toString(obj));
    }

    @Test
    public void joinTest() {
        Integer[] i = {null, 5, 5};
        System.out.println(ArrayUtil.join(i, ",", true, false, new FilterEmpty()));
        System.out.println(ArrayUtil.join(i, "-", new FilterEmpty()));
    }

    @Test
    public void hasNullTest() {
        System.out.println(ArrayUtil.hasNull("", "null"));
    }

    @Test
    public void newArray() {
        System.out.println(Arrays.toString(ArrayUtil.newArray(Integer.class, 2)));
    }

    @Test
    public void getComponentTypeTest() {
        System.out.println(ArrayUtil.getComponentType(new int[]{}));
        System.out.println("---------");
        System.out.println(ArrayUtil.getComponentType(String[].class));
    }

    @Test
    public void insertTest() {
        String[] strArr = new String[]{"abc", "def", "ghj", "klm"};
        String[] strArr2 = new String[]{"abc", "def", "ghj", "klm"};
        Integer[] intArr = new Integer[]{123, 345, 456, 678};
        System.out.println(ArrayUtil.toString(ArrayUtil.insert(strArr, 1, intArr)));
    }

    @Test
    public void filterTest() {
        String[] strArr = new String[]{"", "def", "ghj", "klm", null};

        String[] filters = ArrayUtil.filterEmpty(strArr);
        System.out.println(ArrayUtil.toString(filters));
    }

    @Test
    public void replaceOrAppendTest() {
        String[] strArr = new String[]{"abc", "def", "ghj", "klm"};
        String[] strArr2 = new String[]{"abc", "def", "ghj", "klm"};
        Integer[] intArr = new Integer[]{123, 345, 456, 678};
        System.out.println(ArrayUtil.toString(ArrayUtil.replaceOrAppend(strArr, 2, intArr)));
    }

    @Test
    public void addAllTest() {
        String[] strArr = new String[]{"abc", "def", "ghj", "klm"};
        Integer[] strArr2 = new Integer[]{123};
        System.out.println((Arrays.toString(ArrayUtil.addAll(strArr, strArr2))));
    }

    @Test
    public void mergeTest() {
        String[] strArr = new String[]{"abc", "klm", "ghj", "def"};
        Integer[] strArr2 = new Integer[]{123, 523, 6546, 9897};
        System.out.println(ArrayUtil.merge(strArr, strArr2, true));
    }

    @Test
    public void indexOfTest() {
        String[] strArr = new String[]{"abc", "klm", "ghj", "def"};
        String[] strArr2 = new String[]{"abc", "ghj", "def"};
        System.out.println(ArrayUtil.indexOf(strArr,"Abc"));
        System.out.println(ArrayUtil.indexOfIgnoreCase(strArr,new User()));
        System.out.println(ArrayUtil.lastIndexOf(strArr,"def"));
        System.out.println(ArrayUtil.contains(strArr,"ghj"));
        System.out.println(ArrayUtil.containsAll(strArr,strArr2));
    }
}

import com.i2silly.common.constant.ArrayFilterEnum;
import com.i2silly.common.util.ArrayUtil;
import org.junit.Test;

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
        Object[] i = {" ", null, 5};
        System.out.println(ArrayUtil.join(i, ",", true, false, ArrayFilterEnum.ALL));
    }

    @Test
    public void hasNullTest() {
        System.out.println(ArrayUtil.hasNull(new String(), "null"));
    }

    @Test
    public void newArray() {
        System.out.println(Arrays.toString(ArrayUtil.newArray(Integer.class, 2)));
    }

    @Test
    public void getComponentTypeTest() {
        System.out.println(ArrayUtil.getComponentType(new int[]{}));
    }

    @Test
    public void insertTest() {
        String[] strArr = new String[]{"abc", "def", "ghj", "klm"};
        Integer[] intArr = new Integer[]{123, 345, 456, 678};
        System.out.println(ArrayUtil.toString(ArrayUtil.insert(strArr, 1, intArr)));
    }

    @Test
    public void filterTest() {
        String[] strArr = new String[]{"", "def", "ghj", "klm", null};

        String[] filters = ArrayUtil.filterEmpty(strArr);
        System.out.println(ArrayUtil.toString(filters));
    }
}

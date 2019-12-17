import com.i2silly.common.util.ArrayUtil;
import com.i2silly.common.util.CommonUtil;
import org.junit.Test;

public class CommonUtilTest {

    @Test
    public void getCanonicalNameTest() {

        int[] obj = new int[1];
        String name = obj.getClass().getComponentType().getName();
        System.out.println(CommonUtil.getCanonicalName(ArrayUtil.warp(obj)));
    }

}

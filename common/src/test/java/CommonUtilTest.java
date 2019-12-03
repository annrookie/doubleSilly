import com.rookie.common.util.ArrayUtil;
import com.rookie.common.util.CommonUtil;
import org.junit.Test;

public class CommonUtilTest {

    @Test
    public void getCanonicalNameTest() {

        int[] obj = new int[1];
        String name = obj.getClass().getComponentType().getName();
        System.out.println(CommonUtil.getCanonicalName(ArrayUtil.warp(obj)));
    }

}

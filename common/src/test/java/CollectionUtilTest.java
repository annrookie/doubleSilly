import com.rookie.common.constant.ComConstant;
import com.rookie.common.util.CollectionUtil;
import com.rookie.common.util.NewUtil;
import com.rookie.common.util.RandomUtil;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionUtilTest {

    @Test
    public void unionTest() {
        List<String> aa = NewUtil.list();
        aa.add("23");
        List<String> bb = NewUtil.list();
        bb.add("aa");
        bb.add("23");
        Set<String> cc = NewUtil.set();
        cc.add("vvv");
        Set<String> dd = NewUtil.set();
        dd.add("vvv");
        List union1 = CollectionUtil.union(aa, bb);
        Set<String> union2 = CollectionUtil.union(cc, dd);
        System.out.println(union1);
        System.out.println(union2);
    }

    @Test
    public void intersectionTest() {
        List<String> aa = NewUtil.list();
        Set<String> cc = NewUtil.set();
        aa.add("23");
        cc.add("vvv");
        List<String> bb = NewUtil.list();
        Set<String> dd = NewUtil.set();
        bb.add("12");
        dd.add("444");
        List<String> union1 = CollectionUtil.intersection(aa, bb);
        Set<String> union2 = CollectionUtil.intersection(cc, dd);
        System.out.println(union1);
        System.out.println(union2);
    }

    @Test
    public void differenceTest() {
        List<String> aa = NewUtil.list();
        Set<String> cc = NewUtil.set();
       /* aa.add("23");
        aa.add("12");
        aa.add("41");*/
        cc.add("vvv");
        List<String> bb = NewUtil.list();
        Set<String> dd = NewUtil.set();
        bb.add("12");
        dd.add("444");
        List<String> union1 = CollectionUtil.difference(aa, bb);
        Set<String> union2 = CollectionUtil.difference(cc, dd);
        System.out.println(union1);
        System.out.println(union2);
    }

    @Test
    public void complementTest() {
        List<String> aa = NewUtil.list();
        Set<String> cc = NewUtil.set();
        aa.add("23");
        aa.add("12");
        aa.add("41");
        cc.add("vvv");
        List<String> bb = NewUtil.list();
        Set<String> dd = NewUtil.set();
        bb.add("12");
        dd.add("444");
        List<String> union1 = CollectionUtil.complement(aa, bb);
        Set<String> union2 = CollectionUtil.difference(cc, dd);
        System.out.println(union1);
        System.out.println(union2);
    }

    @Test
    public void joinTest() {
        List<String> list = RandomUtil.randomList(3);
        long startTime = System.currentTimeMillis();
        System.out.println("执行代码块/方法");
        String s = CollectionUtil.join(list, "","","---");
        System.out.println(s);
        HashSet<String> set = new HashSet<>(RandomUtil.randomList(5));
        System.out.println(set);
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }
}

package com.example.template;

/**
 * @description: 测试新生代GC
 * @author: zlf
 * @create: 2021-12-18 09:30
 */
public class TestMinorGC {
    private static final int _1MB = 1024*1024;
    public static void main(String[] args) {
        byte[] allocation1,allocation2,allocation3,allocation4;
        //allocation1被装载进年轻代
//        allocation1 = new byte[2*_1MB];
        //allocation2被装载进年轻代
//        allocation2 = new byte[2*_1MB];
        //allocation3被装载进年轻代
//        allocation3 = new byte[2*_1MB];
        //当装载allocation4的时候，年轻代Eden区被占用了6M了，而survivor也提供不出来转移存2M大小对象的区域
        //所以只好通过分配担保机制提前转移到老年代去，这就需要出发MinorGC来实现了。
        allocation4 = new byte[4*_1MB];
    }
    /*
    * -verbose:gc //在控制台输出GC情况
    * -Xms20M //设置JVM初始内存为20M。
    * -Xmx20M //设置JVM最大可用内存为20M。
    * -Xmn10M //设置年轻代大小为10M。
    * -XX:+PrintGCDetails //在控制台输出详细GC情况。
    * -XX:SurvivorRatio=8 //设置年轻代中Eden区与Survivor区的大小比值。目前这种设置方法就是
    * 在新生代Eden区和Survivor区的空间比例是8:1:1，之所以有survivor区有两个1，是因为为了实现复制算法，这个区被拆成
    * 等大的两个了。
    * */

}

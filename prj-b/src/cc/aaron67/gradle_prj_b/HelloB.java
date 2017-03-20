package cc.aaron67.gradle_prj_b;

import cc.aaron67.gradle_prj_a.HelloA;
import org.apache.commons.math3.complex.Complex;

public class HelloB {
    public void testApacheCommonsMath() {
        System.out.println((new Complex(1.0, 3.0).add(new Complex(2.0, 5.0))).toString());
    }

    public static void main(String[] args) {
        HelloA ha = new HelloA();
        ha.sayHi();
        ha.testApacheCommonsMath();

        HelloB hb = new HelloB();
        hb.testApacheCommonsMath();
    }
}

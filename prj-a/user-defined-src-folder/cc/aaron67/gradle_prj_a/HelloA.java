package cc.aaron67.gradle_prj_a;

import org.apache.commons.math3.fraction.Fraction;

public class HelloA {
    public void sayHi() {
        System.out.println("Hi");
    }

    public void testApacheCommonsMath() {
        System.out.println((new Fraction(1, 3).add(new Fraction(2, 5))).toString());
    }

    public static void main(String[] args) {
        HelloA ha = new HelloA();
        ha.sayHi();
        ha.testApacheCommonsMath();
    }
}

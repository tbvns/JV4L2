package xyz.tbvns.JV4L2;

import org.junit.jupiter.api.Test;

public class TestV4L2 {
    @Test
    public void testListDevices() {
        System.out.println("Listing devices:");
        System.out.println(V4L2.getDevices());
    }

    @Test
    public void testSetParams() throws Exception {
        System.out.println("Set params:");
        V4L2.setParams("gamma", "10");
        System.out.println("Set gamma to 10");
        V4L2.setParams("gamma", "300");
        System.out.println("Set gamma to 300");
    }

    @Test
    public void testGetParams() {
        System.out.println("Get params:");
        System.out.println("Gamma: " + V4L2.getParamsInt("gamma"));
        System.out.println("White balance automatic: " + V4L2.getParamsBool("white_balance_automatic"));
    }
}

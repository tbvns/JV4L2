package xyz.tbvns.JV4L2;

import lombok.SneakyThrows;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class V4L2 {
    public static List<String> getDevices() {
        File file = new File("/dev/");
        List<String> l = new ArrayList<>();
        for (String s : file.list()) {
            if (s.startsWith("video")) {
                l.add("/dev/" + s);
            }
        }
        return l;
    }

    public static void setParams(String params, String value) throws Exception {
        Process process = new ProcessBuilder()
                .command("v4l2-ctl", "--set-ctrl", params + "=" + value)
                .start();
        while (process.isAlive());
    }

    @SneakyThrows
    public static int getParamsInt(String params) throws ClassCastException {
        Process process = new ProcessBuilder()
                .command("v4l2-ctl", "--get-ctrl", params)
                .start();
        while (process.isAlive());
        String out = new String(process.getInputStream().readAllBytes());
        if (out.contains("Unknown")) {
            throw new RuntimeException(out);
        }
        out = out.split(":")[1].strip();
        return Integer.parseInt(out);
    }

    @SneakyThrows
    public static boolean getParamsBool(String params) throws ClassCastException {
        Process process = new ProcessBuilder()
                .command("v4l2-ctl", "--get-ctrl", params)
                .start();
        while (process.isAlive());
        String out = new String(process.getInputStream().readAllBytes());
        if (out.contains("Unknown")) {
            throw new RuntimeException(out);
        }
        out = out.split(":")[1].strip();
        return Boolean.parseBoolean(out);
    }
}

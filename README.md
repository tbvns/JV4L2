# Java V4L2 Control Interface

A simple and efficient Java library for interacting with Video4Linux2 (V4L2) devices. This library allows you to list available V4L2 devices, retrieve control parameters, and modify device settings programmatically. Built for Java 21, it provides a clean and modern API for managing V4L2-compatible devices.

## Features

- **List Devices**: Discover all available V4L2 devices on your system.
- **Get Control Parameters**: Retrieve integer or boolean values for specific device controls.
- **Set Control Parameters**: Modify device settings with ease.

## Why Use This Library?

- **Simple API**: Easy-to-use methods for common V4L2 operations.
- **Lightweight**: No external dependencies—just pure Java and your V4L2 devices.

## Getting Started

### Prerequisites

- **Java 21**: Ensure you have Java 21 installed on your system.
- **V4L2 Tools**: Make sure `v4l2-ctl` is installed and available in your system's PATH.
- **Linux Environment**: This library is designed for Linux-based systems with V4L2 support.

### Usage

Add the library to your project and start controlling your V4L2 devices with just a few lines of code.

#### Listing Devices

```java
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> devices = V4L2.getDevices();
        devices.forEach(System.out::println);
    }
}
```

#### Getting and Setting Parameters

```java
public class Main {
    public static void main(String[] args) {
        try {
            // Get the current brightness value
            int brightness = V4L2.getParamsInt("brightness");
            System.out.println("Current brightness: " + brightness);

            // Increase brightness by 10
            V4L2.setParams("brightness", String.valueOf(brightness + 10));
            System.out.println("Brightness updated!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

#### Handling Boolean Parameters

```java
public class Main {
    public static void main(String[] args) {
        try {
            // Check if autofocus is enabled
            boolean autofocus = V4L2.getParamsBool("autofocus");
            System.out.println("Autofocus enabled: " + autofocus);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

## Contributing

Contributions are welcome! If you’d like to improve this library, feel free to open an issue or submit a pull request. Please ensure your code follows the existing style and includes appropriate tests.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

enum DeviceType {
    COMPUTER,
    REPEATER
}

class Device {
    String name;
    DeviceType type;
    int strength = 5;
    ArrayList<Device> connections = new ArrayList<>();

    Device(String name, DeviceType type) {
        this.name = name;
        this.type = type;
    }
}

public class Main {
    static HashMap<String, Device> devices = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.print("> ");
            String[] input = scanner.nextLine().split(" ");
            switch (input[0].toUpperCase()) {
                case "ADD":
                    if (input.length != 3) {
                        System.out.println("Error: Invalid command syntax.");
                    } else {
                        DeviceType type;
                        switch (input[1].toUpperCase()) {
                            case "COMPUTER":
                                type = DeviceType.COMPUTER;
                                break;
                            case "REPEATER":
                                type = DeviceType.REPEATER;
                                break;
                            default:
                                System.out.println("Error: Invalid command syntax.");
                                continue;
                        }
                        String name = input[2];
                        if (devices.containsKey(name)) {
                            System.out.println("Error: That name already exists.");
                        } else {
                            devices.put(name, new Device(name, type));
                            System.out.println("Successfully added " + name + ".");
                        }
                    }
                    break;
                case "CONNECT":
                    if (input.length != 3) {
                        System.out.println("Error: Invalid command syntax.");
                    } else {
                        Device a = devices.get(input[1]);
                        Device b = devices.get(input[2]);
                        if (a == null || b == null) {
                            System.out.println("Error: Node not found.");
                        } else if (a == b) {
                            System.out.println("Error: Cannot connect device to itself.");
                        } else if (a.connections.contains(b)) {
                            System.out.println("Error: Devices are already connected.");
                        } else {
                            a.connections.add(b);
                            b.connections.add(a);
                            System.out.println("Successfully connected.");
                        }
                    }
                    break;
                case "INFO_ROUTE":
                    if (input.length != 3) {
                        System.out.println("Error: Invalid command syntax.");
                    } else {
                        Device a = devices.get(input[1]);
                        Device b = devices.get(input[2]);
                        if (a == null || b == null) {
                            System.out.println("Error: Node not found");

                        }
                    }
            }
        }
    }
}

class Vehicle {
    public String startEngine() {
        return "Mesin Nyala";
    }
}

class Car extends Vehicle {
    public String startEngine() {
        return "Mesin Mobil Nyala";
    }
}

class Motorcycle extends Vehicle {
    public String startEngine() {
        return "Mesin Motor Nyala";
    }
}

class License {
    private String licenseNumber;
    private int validDay;
    private int validMonth;
    private int validYear;

    public License(String licenseNumber) {
        this.licenseNumber = licenseNumber;
        this.validDay = 15;
        this.validMonth = 5;
        this.validYear = 2030;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public int getValidDay() {
        return validDay;
    }

    public int getValidMonth() {
        return validMonth;
    }

    public int getValidYear() {
        return validYear;
    }
}

class Driver {
    private String name;
    private Vehicle vehicle;
    private License license;

    public Driver(String name, Vehicle vehicle, String licenseNumber) {
        this.name = name;
        this.vehicle = vehicle;
        this.license = new License(licenseNumber);
    }

    public void displayInfo() {
        System.out.println("\nNama Pengemudi: " + name);
        if (vehicle instanceof Car) {
            System.out.println("Jenis Kendaraan: Mobil");
        } else if (vehicle instanceof Motorcycle) {
            System.out.println("Jenis Kendaraan: Motor");
        } else {
            System.out.println("Jenis Kendaraan: Tidak Diketahui");
        }
        System.out.println("Status Mesin: " + vehicle.startEngine());
        System.out.println("Nomor Lisensi: " + license.getLicenseNumber());
        System.out.println("Berlaku Hingga: " + license.getValidDay() + "-" + license.getValidMonth() + "-" + license.getValidYear());
    }
}

public class Main {
    public static void main(String[] args) {
        Vehicle car = new Car();
        Vehicle motorcycle = new Motorcycle();

        Driver driver1 = new Driver("Peter", car, "LIC12345");
        Driver driver2 = new Driver("James", motorcycle, "LIC67890");

        driver1.displayInfo();
        driver2.displayInfo();
    }
}
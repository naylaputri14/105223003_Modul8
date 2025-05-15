class Animal {
    protected HealthRecord healthRecord;

    public Animal() {
        this.healthRecord = new HealthRecord();
    }

    public void makeSound() {
        System.out.println("Hewan bersuara");
    }

    public HealthRecord getHealthRecord() {
        return healthRecord;
    }
}

class Dog extends Animal {
    public void makeSound() {
        System.out.println("Guk-Guk!");
    }
}

class Cat extends Animal {
    public void makeSound() {
        System.out.println("Meong!");
    }
}

class HealthRecord {
    private String recordNumber;
    private String creationDate;

    public HealthRecord() {
        this.recordNumber = "A001";
        this.creationDate = "15-05-2025";
    }

    public String getRecordNumber() {
        return recordNumber;
    }

    public String getCreationDate() {
        return creationDate;
    }
}

class Owner {
    private String name;
    private Animal pet;

    public Owner(String name, Animal pet) {
        this.name = name;
        this.pet = pet;
    }

    public void showPetInfo() {
        System.out.println("Nama Pemilik: " + name);
        System.out.print("Suara Hewan Peliharaan: ");
        pet.makeSound();

        System.out.print("Jenis Hewan: ");
        if (pet instanceof Dog) {
            System.out.println("Anjing");
        } else if (pet instanceof Cat) {
            System.out.println("Kucing");
        } else {
            System.out.println("Tidak diketahui");
        }

        System.out.println("Nomor Rekam Medis: " + pet.getHealthRecord().getRecordNumber());
        System.out.println("Tanggal Rekam Medis: " + pet.getHealthRecord().getCreationDate());
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Owner owner1 = new Owner("Augustine", new Dog());
        Owner owner2 = new Owner("Betty", new Cat());

        owner1.showPetInfo();
        owner2.showPetInfo();
    }
}
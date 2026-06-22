public class Computer {
    String storage;
    String ram;
    String cpu;

    static class Builder {
        private Computer computer;
        public Builder() {
            computer = new Computer();
        }
        public Builder setStorage(String storage) {
            computer.storage = storage;
            return this;
        }
        public Builder setRam(String ram) {
            computer.ram = ram;
            return this;
        }
        public Builder setCpu(String cpu) {
            computer.cpu = cpu;
            return this;
        }
        public Computer build() {
            return computer;
        }
    }

    Computer(Builder builder) {
        this.storage = builder.storage;
        this.ram = builder.ram;
        this.cpu = builder.cpu;
    }
}

class Main {
    public static void main(String[] args) {
        Computer computer = new Computer.Builder().setStorage("512GB").setRam("8GB").setCpu("Intel i5").build();
        System.out.println(computer);
    }
}
public class BuilderTest {

    public static void main(String[] args) {

        Computer computer1 = new Computer.Builder()
                .setCPU("Intel i5")
                .setRAM("8GB")
                .setStorage("256GB SSD")
                .build();

        Computer computer2 = new Computer.Builder()
                .setCPU("Intel i7")
                .setRAM("16GB")
                .setStorage("1TB SSD")
                .build();

        System.out.println("Computer 1");
        computer1.display();

        System.out.println();

        System.out.println("Computer 2");
        computer2.display();
    }

    // Simple Computer class with Builder to fix missing type error
    static class Computer {
        private final String cpu;
        private final String ram;
        private final String storage;

        private Computer(Builder builder) {
            this.cpu = builder.cpu;
            this.ram = builder.ram;
            this.storage = builder.storage;
        }

        void display() {
            System.out.println("CPU: " + cpu);
            System.out.println("RAM: " + ram);
            System.out.println("Storage: " + storage);
        }

        static class Builder {
            private String cpu;
            private String ram;
            private String storage;

            Builder setCPU(String cpu) {
                this.cpu = cpu;
                return this;
            }

            Builder setRAM(String ram) {
                this.ram = ram;
                return this;
            }

            Builder setStorage(String storage) {
                this.storage = storage;
                return this;
            }

            Computer build() {
                return new Computer(this);
            }
        }
    }
}
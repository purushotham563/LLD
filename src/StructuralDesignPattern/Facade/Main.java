package StructuralDesignPattern.Facade;

public class Main {
    static class CPU{
        public void freeze(){
            System.out.println("Cpu freeze");
        }
        public void jump(long pos){
            System.out.println("CPU jumps to "+pos);
        }
        public void execute(){
            System.out.println("CPU executing");
        }

    }
    static class Memory{
        public void load(long pos,byte []data){
            System.out.println("Memory load at "+pos);
        }

    }
    static class HardDrive{
        public byte[] read(long lba,int size){
            System.out.println("HardDrive read at"+lba+"size"+size);
            return new byte[size];
        }
    }
    static class ComputerFacade{
        private static final long BOOT_ADDRESS = 0x0000;
        private static final long BOOT_SECTOR = 0x0010;
        private static final int SECTOR_SIZE = 1024;
        private final CPU processor;
        private final Memory ram;
        private final HardDrive hd;

        public ComputerFacade() {
            this.processor = new CPU();
            this.ram = new Memory();
            this.hd = new HardDrive();
        }
        public void start(){
            System.out.println("Computer starting");
            processor.freeze();
            byte []bootData=hd.read(BOOT_SECTOR,SECTOR_SIZE);
            ram.load(BOOT_ADDRESS,bootData);
            processor.jump(BOOT_ADDRESS);
            processor.execute();
            System.out.println("Computer started successfully");
        }

    }

    public static void main(String[] args) {
         ComputerFacade compute=new ComputerFacade();
         compute.start();
    }
}

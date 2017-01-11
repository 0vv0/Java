package lesson3.task3;

/**
 * Created by Oleksii.Sergiienko on 12/25/2016.
 */
class Runner {
    public static void main(String[] args) {
//Создать  объект  класса Компьютер,  используя  классы  Винчестер, Дисковод, Оперативная память, Процессор.
// Методы: включить, выключить, проверить на вирусы, вывести на консоль размер винчестера.

        Memory hdd = new Memory("Seagate", IMemory.Type.HDD, 4_000_000);
        Memory hdd1 = new Memory("IBM", IMemory.Type.HDD, 1_000_000);
        Memory fdd = new Memory("Unknown", IMemory.Type.FDD, 720);
        Memory ram = new Memory("Samsumg", IMemory.Type.RAM, 4_000_000);
        Memory ram1 = new Memory("Samsung", IMemory.Type.RAM, 4_000_000);
        Memory ram2 = new Memory("Trancend", IMemory.Type.RAM, 8000_000);
        ProcessorUnit cpu = new ProcessorUnit("i5-7600");
        Computer computer = new Computer();
        computer.add(hdd).add(hdd1).add(fdd).add(ram).add(ram1).add(ram2).add(cpu);
        computer.add(computer);

        System.out.println(computer.getName());
        computer.start();
        computer.getSize();
    }
}

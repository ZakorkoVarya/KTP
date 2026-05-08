abstract class Furniture {
    private String name;          
    private String material;      
    private double price;         
    
    private static int totalFurnitureCount = 0;
    
    // Конструктор по умолчанию
    public Furniture() {
        this.name = "Неизвестная мебель";
        this.material = "Неизвестный материал";
        this.price = 0.0;
        totalFurnitureCount++;  // увеличиваем счетчик при создании
        System.out.println("Создан объект Мебель (по умолчанию)");
    }
    
    // Конструктор с параметрами
    public Furniture(String name, String material, double price) {
        this.name = name;
        this.material = material;
        this.price = price;
        totalFurnitureCount++;
        System.out.println("Создан объект Мебель: " + name);
    }
    
    // Геттеры и сеттеры (инкапсуляция)
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getMaterial() {
        return material;
    }
    
    public void setMaterial(String material) {
        this.material = material;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        if (price >= 0) {  // проверка (инкапсуляция)
            this.price = price;
        } else {
            System.out.println("Цена не может быть отрицательной!");
        }
    }
    
    // Статический метод для получения счетчика
    public static int getTotalFurnitureCount() {
        return totalFurnitureCount;
    }
    
    // Абстрактный метод - каждая мебель используется по-своему (абстракция)
    public abstract void use();
    
    // Обычный метод для вывода информации
    public void displayInfo() {
        System.out.println("Мебель: " + name);
        System.out.println("Материал: " + material);
        System.out.println("Цена: " + price + " руб.");
    }
}





class Table extends Furniture {
    private int numberOfLegs;      
    private double length;         
    private double width;          
    
    // Статический счетчик для столов
    private static int tableCount = 0;
    
    // Конструктор по умолчанию
    public Table() {
        super();  
        this.numberOfLegs = 4;
        this.length = 120.0;
        this.width = 80.0;
        tableCount++;
        System.out.println("Стол создан (по умолчанию)");
    }
    
    // Конструктор с параметрами
    public Table(String name, String material, double price, 
                 int numberOfLegs, double length, double width) {
        super(name, material, price); 
        this.numberOfLegs = numberOfLegs;
        this.length = length;
        this.width = width;
        tableCount++;
        System.out.println("Стол '" + name + "' создан");
    }
    
    // Геттеры и сеттеры
    public int getNumberOfLegs() {
        return numberOfLegs;
    }
    
    public void setNumberOfLegs(int numberOfLegs) {
        if (numberOfLegs >= 3 && numberOfLegs <= 6) { 
            this.numberOfLegs = numberOfLegs;
        } else {
            System.out.println("Стол должен иметь от 3 до 6 ножек!");
        }
    }
    
    public double getLength() {
        return length;
    }
    
    public void setLength(double length) {
        if (length > 0) {
            this.length = length;
        }
    }
    
    public double getWidth() {
        return width;
    }
    
    public void setWidth(double width) {
        if (width > 0) {
            this.width = width;
        }
    }
    
    public static int getTableCount() {
        return tableCount;
    }
    
    // Переопределение абстрактного метода (полиморфизм)
    @Override
    public void use() {
        System.out.println("За столом " + getName() + " можно работать или есть");
    }
    
    // Переопределение метода displayInfo
    @Override
    public void displayInfo() {
        super.displayInfo(); 
        System.out.println("Ножек: " + numberOfLegs);
        System.out.println("Размер: " + length + " x " + width + " см");
        System.out.println("Площадь столешницы: " + getArea() + " кв.см");
    }
    
    // Дополнительный метод
    public double getArea() {
        return length * width;
    }
}

/**
 * Класс Компьютерный стол - наследник Стола
 * Второй уровень наследования
 */
class ComputerTable extends Table {
    // Дополнительные поля
    private boolean hasKeyboardTray;     // есть ли полка для клавиатуры
    private int numberOfShelves;          // количество полочек
    private boolean hasCableHoles;        // есть ли отверстия для проводов
    
    private static int computerTableCount = 0;
    
    // Конструктор по умолчанию
    public ComputerTable() {
        super();
        this.hasKeyboardTray = true;
        this.numberOfShelves = 2;
        this.hasCableHoles = true;
        computerTableCount++;
        System.out.println("Компьютерный стол создан");
    }
    
    // Конструктор с параметрами
    public ComputerTable(String name, String material, double price,
                         int numberOfLegs, double length, double width,
                         boolean hasKeyboardTray, int numberOfShelves, 
                         boolean hasCableHoles) {
        super(name, material, price, numberOfLegs, length, width);
        this.hasKeyboardTray = hasKeyboardTray;
        this.numberOfShelves = numberOfShelves;
        this.hasCableHoles = hasCableHoles;
        computerTableCount++;
        System.out.println("Компьютерный стол '" + name + "' создан");
    }
    
    // Геттеры и сеттеры
    public boolean isHasKeyboardTray() {
        return hasKeyboardTray;
    }
    
    public void setHasKeyboardTray(boolean hasKeyboardTray) {
        this.hasKeyboardTray = hasKeyboardTray;
    }
    
    public int getNumberOfShelves() {
        return numberOfShelves;
    }
    
    public void setNumberOfShelves(int numberOfShelves) {
        this.numberOfShelves = numberOfShelves;
    }
    
    public boolean isHasCableHoles() {
        return hasCableHoles;
    }
    
    public void setHasCableHoles(boolean hasCableHoles) {
        this.hasCableHoles = hasCableHoles;
    }
    
    public static int getComputerTableCount() {
        return computerTableCount;
    }
    
    // Переопределение метода use (полиморфизм)
    @Override
    public void use() {
        System.out.print("За компьютерным столом " + getName() + " можно: ");
        System.out.println("ставить компьютер, работать, играть");
    }
    
    // Переопределение displayInfo
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Полка для клавиатуры: " + (hasKeyboardTray ? "да" : "нет"));
        System.out.println("Количество полочек: " + numberOfShelves);
        System.out.println("Отверстия для проводов: " + (hasCableHoles ? "да" : "нет"));
    }
}

/**
 * Класс Стул - наследник Мебели
 */
class Chair extends Furniture {
    private boolean hasArmrests;      // есть ли подлокотники
    private boolean isAdjustable;      // регулируется ли высота
    private String chairType;           // тип стула (офисный, кухонный и т.д.)
    
    private static int chairCount = 0;
    
    public Chair() {
        super();
        this.hasArmrests = false;
        this.isAdjustable = false;
        this.chairType = "Обычный";
        chairCount++;
        System.out.println("Стул создан (по умолчанию)");
    }
    
    public Chair(String name, String material, double price,
                 boolean hasArmrests, boolean isAdjustable, String chairType) {
        super(name, material, price);
        this.hasArmrests = hasArmrests;
        this.isAdjustable = isAdjustable;
        this.chairType = chairType;
        chairCount++;
        System.out.println("Стул '" + name + "' создан");
    }
    
    // Геттеры и сеттеры
    public boolean isHasArmrests() {
        return hasArmrests;
    }
    
    public void setHasArmrests(boolean hasArmrests) {
        this.hasArmrests = hasArmrests;
    }
    
    public boolean isAdjustable() {
        return isAdjustable;
    }
    
    public void setAdjustable(boolean adjustable) {
        isAdjustable = adjustable;
    }
    
    public String getChairType() {
        return chairType;
    }
    
    public void setChairType(String chairType) {
        this.chairType = chairType;
    }
    
    public static int getChairCount() {
        return chairCount;
    }
    
    @Override
    public void use() {
        System.out.println("На стуле " + getName() + " можно сидеть");
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Тип стула: " + chairType);
        System.out.println("Подлокотники: " + (hasArmrests ? "есть" : "нет"));
        System.out.println("Регулировка высоты: " + (isAdjustable ? "есть" : "нет"));
    }
}

/**
 * Класс Кровать - наследник Мебели
 */
class Bed extends Furniture {
    private double width;              // ширина кровати
    private double length;              // длина кровати
    private boolean hasMattress;        // есть ли матрас
    
    private static int bedCount = 0;
    
    public Bed() {
        super();
        this.width = 160.0;
        this.length = 200.0;
        this.hasMattress = true;
        bedCount++;
        System.out.println("Кровать создана (по умолчанию)");
    }
    
    public Bed(String name, String material, double price,
               double width, double length, boolean hasMattress) {
        super(name, material, price);
        this.width = width;
        this.length = length;
        this.hasMattress = hasMattress;
        bedCount++;
        System.out.println("Кровать '" + name + "' создана");
    }
    
    // Геттеры и сеттеры
    public double getWidth() {
        return width;
    }
    
    public void setWidth(double width) {
        if (width > 0) {
            this.width = width;
        }
    }
    
    public double getLength() {
        return length;
    }
    
    public void setLength(double length) {
        if (length > 0) {
            this.length = length;
        }
    }
    
    public boolean isHasMattress() {
        return hasMattress;
    }
    
    public void setHasMattress(boolean hasMattress) {
        this.hasMattress = hasMattress;
    }
    
    public static int getBedCount() {
        return bedCount;
    }
    
    @Override
    public void use() {
        System.out.println("На кровати " + getName() + " можно спать и отдыхать");
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Размер: " + width + " x " + length + " см");
        System.out.println("Матрас: " + (hasMattress ? "есть" : "нет"));
        System.out.println("Площадь спального места: " + getSleepArea() + " кв.см");
    }
    
    // Дополнительный метод
    public double getSleepArea() {
        return width * length;
    }
}

/**
 * Главный класс для демонстрации работы всех принципов ООП
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== ДЕМОНСТРАЦИЯ РАБОТЫ ИЕРАРХИИ КЛАССОВ ===\n");
        
        // 1. Демонстрация конструкторов и создания объектов
        System.out.println("--- СОЗДАНИЕ ОБЪЕКТОВ ---");
        
        // Создаем разные объекты
        Table table1 = new Table("Обеденный стол", "Дерево", 5000, 4, 150, 90);
        Chair chair1 = new Chair("Офисное кресло", "Кожа", 8000, true, true, "Офисное");
        Bed bed1 = new Bed("Двуспальная кровать", "Массив дуба", 25000, 160, 200, true);
        ComputerTable compTable1 = new ComputerTable(
            "Игровой компьютерный стол", "ЛДСП", 12000, 
            4, 140, 70, true, 3, true
        );
        
        System.out.println();
        
        // 2. Демонстрация работы геттеров и сеттеров
        System.out.println("--- ДЕМОНСТРАЦИЯ ГЕТТЕРОВ И СЕТТЕРОВ ---");
        System.out.println("Название стола: " + table1.getName());
        System.out.println("Материал стула: " + chair1.getMaterial());
        
        // Пытаемся установить некорректную цену (инкапсуляция с проверкой)
        System.out.println("\nПопытка установить отрицательную цену:");
        bed1.setPrice(-1000);  // сработает проверка
        
        System.out.println();
        
        // 3. Демонстрация полиморфизма
        System.out.println("--- ДЕМОНСТРАЦИЯ ПОЛИМОРФИЗМА ---");
        
        // Массив объектов типа Furniture (upcasting)
        Furniture[] furniture = {
            table1,
            chair1,
            bed1,
            compTable1
        };
        
        for (Furniture item : furniture) {
            System.out.println("\nОбрабатываем объект:");
            item.use();  // полиморфный вызов
            item.displayInfo();  // полиморфный вызов
            System.out.println("-------------------");
        }
        
        // 4. Демонстрация работы счетчиков (статических переменных)
        System.out.println("\n--- СТАТИСТИКА СОЗДАННЫХ ОБЪЕКТОВ ---");
        System.out.println("Всего объектов мебели: " + Furniture.getTotalFurnitureCount());
        System.out.println("Из них:");
        System.out.println("  Столов (всего): " + Table.getTableCount());
        System.out.println("    Компьютерных столов: " + ComputerTable.getComputerTableCount());
        System.out.println("  Стульев: " + Chair.getChairCount());
        System.out.println("  Кроватей: " + Bed.getBedCount());
        
        // 5. Демонстрация instanceof (проверка типа)
        System.out.println("\n--- ПРОВЕРКА ТИПОВ (INSTANCEOF) ---");
        for (Furniture item : furniture) {
            if (item instanceof ComputerTable) {
                System.out.println(item.getName() + " - это компьютерный стол");
                // Downcasting
                ComputerTable ct = (ComputerTable) item;
                System.out.println("  Полочек: " + ct.getNumberOfShelves());
            } else if (item instanceof Table) {
                System.out.println(item.getName() + " - это обычный стол");
            } else if (item instanceof Chair) {
                System.out.println(item.getName() + " - это стул");
            } else if (item instanceof Bed) {
                System.out.println(item.getName() + " - это кровать");
            }
        }
        
        // 6. Создание объекта через конструктор по умолчанию
        System.out.println("\n--- КОНСТРУКТОР ПО УМОЛЧАНИЮ ---");
        Chair defaultChair = new Chair();
        defaultChair.displayInfo();
        
        // Финальная статистика
        System.out.println("\n--- ИТОГОВАЯ СТАТИСТИКА ---");
        System.out.println("Всего объектов мебели: " + Furniture.getTotalFurnitureCount());
    }
}




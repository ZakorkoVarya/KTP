import java.util.LinkedList;

public class HashTable<K, V> {
    
    // Внутренний класс для пары ключ-значение
    private static class Entry<K, V> {
        private K key;
        private V value;
        
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
        
        public K getKey() { return key; }
        public V getValue() { return value; }
        public void setValue(V value) { this.value = value; }
    }
    
    // Поля таблицы
    private static final int DEFAULT_CAPACITY = 16;
    private LinkedList<Entry<K, V>>[] table;
    private int size;
    
    // Конструктор
    @SuppressWarnings("unchecked")
    public HashTable() {
        table = (LinkedList<Entry<K, V>>[]) new LinkedList[DEFAULT_CAPACITY];
        size = 0;
    }
    
    // Хеш-функция
    private int hash(K key) {
        return Math.abs(key.hashCode()) % table.length;
    }
    
    // Добавление/обновление
    public void put(K key, V value) {
        int index = hash(key);
        
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }
        
        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }
        
        table[index].add(new Entry<>(key, value));
        size++;
    }
    
    // Получение по ключу
    public V get(K key) {
        int index = hash(key);
        
        if (table[index] == null) {
            return null;
        }
        
        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        
        return null;
    }
    
    // Удаление по ключу
    public V remove(K key) {
        int index = hash(key);
        
        if (table[index] == null) {
            return null;
        }
        
        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                V value = entry.getValue();
                table[index].remove(entry);
                size--;
                return value;
            }
        }
        
        return null;
    }
    
    // Размер
    public int size() {
        return size;
    }
    
    // Проверка на пустоту
    public boolean isEmpty() {
        return size == 0;
    }
    
    // Вывод таблицы
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        
        boolean first = true;
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                for (Entry<K, V> entry : table[i]) {
                    if (!first) {
                        sb.append(", ");
                    }
                    sb.append(entry.getKey()).append("=").append(entry.getValue());
                    first = false;
                }
            }
        }
        
        sb.append("}");
        return sb.toString();
    }
    
    // Тестирование
    public static void main(String[] args) {
        HashTable<String, Integer> map = new HashTable<>();
        
        map.put("apple", 5);
        map.put("banana", 3);
        map.put("orange", 7);
        
        System.out.println(map);                    // {apple=5, banana=3, orange=7}
        System.out.println(map.get("banana"));      // 3
        
        map.put("apple", 10);
        System.out.println(map.get("apple"));       // 10
        
        map.remove("orange");
        System.out.println(map);                    // {apple=10, banana=3}
        System.out.println("Size: " + map.size());  // Size: 2
    }
}
package spark.javapractise.LRU;

public class LRUMain {

	public static void main(String[] args) {
		
		LRUCache lruCache = new LRUCache(2);
		
		Employee employee1 = new Employee();
		Employee employee2 = new Employee();
		Employee employee3 = new Employee();
		
		employee1.setId(1);
		employee1.setName("Sahil");
		
		employee2.setId(2);
		employee2.setName("Sahil2");
		
		employee3.setId(3);
		employee3.setName("Sahil3");
		
		lruCache.addIntoLRUCache(employee1);
		lruCache.addIntoLRUCache(employee2);
		lruCache.addIntoLRUCache(employee3);
		lruCache.addIntoLRUCache(employee3);
		
	}

}

package spark.javapractise.LRU;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {
	
	private int maxSize;

	private HashMap<Integer,Employee> dequeEmployeeMap;
	
	private Deque<Employee> dequeEmployee;
	
	public LRUCache(int maxSize) {
		
		this.maxSize = maxSize;
		this.dequeEmployee = new LinkedList<Employee>();
		this.dequeEmployeeMap = new HashMap<Integer, Employee>();
	}
	
	
	public boolean addIntoLRUCache(Employee employee) {
		
		if(dequeEmployeeMap.containsKey(employee.getId())) {
			
			cacheHit(employee);
			System.out.println("Cache hit called element already present in Cache");
			return false;
		}
		else {
			
			if(dequeEmployee.size()>=maxSize) {
				
				System.out.println("LRUCache is full removing LRU element and adding new at the start");
				
				Employee deleteEmployee = dequeEmployee.removeLast();
				dequeEmployeeMap.remove(deleteEmployee.getId());
				dequeEmployee.addFirst(employee);
				dequeEmployeeMap.put(employee.getId(), employee);
				System.out.println("New size of Cache is = "+dequeEmployee.size());
				
				return true;
				
			}else {
			
				dequeEmployee.addFirst(employee);
				dequeEmployeeMap.put(employee.getId(), employee);
				System.out.println("New size of Cache is = "+dequeEmployee.size());
				return true;
			}
					
		}
	}
	
	
	
	public boolean getLRUCache(Employee employee) {
		
		if(!dequeEmployeeMap.containsKey(employee.getId())) {
			
			System.out.println("Cache miss call Element is not present in Cache");
			cacheMiss(employee);	
			return false;	
		}
		else {
			cacheHit(employee);
			return true;
		}	
		
		
	}
	
	public void cacheHit(Employee employee) {
		
		dequeEmployee.remove(employee);
		dequeEmployeeMap.remove(employee.getId());
		dequeEmployee.addFirst(employee);
		dequeEmployeeMap.put(employee.getId(), employee);
		
	}
	
	public void cacheMiss(Employee employee) {
		
		dequeEmployee.addFirst(employee);
		dequeEmployeeMap.put(employee.getId(), employee);	
		
	}
}

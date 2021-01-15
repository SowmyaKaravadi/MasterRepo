/**
 Couse:CS5220
 Instructor: Sunae Shin
 Program title: Generic Stack Implementation
 Program description::This program is used to create a generic stack using array instead of array list.
 Name: Sowmya Karavadi
 700# 700700306
 Group# 1
 Date: 09/24/2020
 *
 * */
public class Q1_stack {

	// Generic Stack class using array instead of arraylist
	public class GenericStack<E>{

		// initializing the required variables.
		public final static int SIZE = 30;		//constant SIZE is used in cases where the size is not explicitly passed
		private E[] array ;
		private int length;						//length variable is used to keep track of number of elements in the array.

		//default constructor
		public GenericStack() {
			array = (E[]) new Object[SIZE];
			length=0;
		}

		//Parameterized constructor to define the capacity of the array which is passed during object creation.
		public GenericStack(int capacity) {
			array = (E[]) new Object[capacity];
			length=0;
		}

		//getSize() method to get the current size of the array.
		public int getSize() {
			return length;
		}

		//peek() method is used just retrieve the latest element in the stack.
		public E peek()
		{
			if(isEmpty())
				return null;
			else
				return array[getSize()-1];
		}

		//push method is used to insert elements into the stack.
		public void push(E o)
		{
			//condition to check if the array is full or not,if full new array is created that doubles the current array size.
			if(length == array.length) {
				E[] array1 = (E[]) new Object[array.length*2];
				for (int i=0;i<length;i++) {
					array1[i]= array[i];
				}
				array = array1;
			}

			array[length] = o;
			length++;
		}

		//pop method is used to retrieve and remove the elements from the stack.
		public E pop() {
			if(isEmpty())
				return null;
			else {
				E o = array[length-1];
				length--;
				return o;
			}
		}

		private boolean isEmpty() {
			// TODO Auto-generated method stub
			return (length==0);
		}

	}

	//Main method where the program execution starts.
	public static void main(String[] args) {

		Q1_stack obj = new Q1_stack();											//creating object for the outer class.
		GenericStack<String> Names = obj.new GenericStack<>(5);					//using generic stack for String array.
		GenericStack<Integer> RollNumbers = obj.new GenericStack<>(5);			//using generic stack for integer array.

		//Adding elements into the stack. push method is used to add elements into stack.
		Names.push("Sowmya");
		Names.push("Kiran");
		Names.push("Charan");
		Names.push("Cherry");
		Names.push("Swetha");
		Names.push("Deepu");
		RollNumbers.push(42);
		RollNumbers.push(19);
		RollNumbers.push(65);
		RollNumbers.push(24);
		RollNumbers.push(47);
		RollNumbers.push(18);

		System.out.println("Number of elements in the Names stack: " + Names.getSize());	//getting size of Names stack and printing it.
		System.out.println("Number of elements in the Roll Number stack: " + RollNumbers.getSize());	//getting size of Roll Number stack and print it.

		//printing out the latest entries from Names and Roll Numbers stacks.
		System.out.println("The latest entries into the names and rollnumber stack are: "+ Names.peek() + " "+ RollNumbers.peek());

		System.out.println("Entries in the Names are Roll Numbers are::");
		//If the Names stack is not null,then we are retrieving and removing the elements from the stack.
		while(!Names.isEmpty()) {
			System.out.println(Names.pop()+ " "+ RollNumbers.pop());
		}

	}

}

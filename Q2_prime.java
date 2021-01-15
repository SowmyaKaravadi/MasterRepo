import java.util.LinkedList;

/**
 Couse:CS5220
 Instructor: Sunae Shin
 Program title: First 50 prime numbers
 Program description::This program displays the first 50 prirme numbers in ascending order and a generic queue is used to store the prime numbers.
 Name: Sowmya Karavadi
 700# 700700306
 Group# 1
 Date: 09/24/2020
 *
 * */

public class Q2_prime {

	//Defining the generic queue class using the linkedlist as it is mentioned that we need to use generic Queue to store the prime numbers.
	public class GenericQueue<E>{

		private java.util.LinkedList<E> list = new LinkedList<E>();
		// this method is used to add elements into the queue
		public void enqueue(E e){
			list.addLast(e);
		}

		//this method is used to remove elements from the queue.
		public E dequeue(){
			return list.removeFirst();
		}

		//this method is used to get the size of the queue
		public int getSize(){
			return list.size();
		}

		@Override
		public String toString() {
			return "Prime numbers: "+list.toString();
			}

	}

	//This method is used to check if the number is prime or not
	public static boolean isPrime(int n){
		for(int i=2;i<=n/2;i++){
			if(n%i == 0)
				return false;
		}
		return true;
	}

	//Main method where the program execution starts.
	public static void main(String[] args) {


		Q2_prime obj = new Q2_prime(); 							//creating Instance to the outer class
		GenericQueue<Integer> storageQueue= obj.new GenericQueue<>();//created storageQueue to store the 50 prime numbers.
		int number=2;									//Initially taking the number as 2 as prime numbers starts from 2.

		//while condition keeps checking the size of the queue,when queue contains 50 elements while loops ends.
        while(storageQueue.getSize()<50){
        		if(isPrime(number)){					//calling is prime to check if its prime or not.
                	storageQueue.enqueue(number);		//if the condition satisfies add the number to the queue.
                }

                number++; 								//incrementing the number
        }

        //Display of prime numbers.Used toString method to print them.
        System.out.println("First 50 prime numbers in ascending order are::");
        System.out.println(storageQueue.toString());

	}


}

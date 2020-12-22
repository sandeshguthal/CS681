package edu.umb.cs681.hw12;

public class CustomerAddressMultiThread implements Runnable{
    @Override
    public void run() {
        Customer customer = new Customer(new Address("Boston", "MA", "11 Penn Bay", 02125));
        System.out.println("The Current Address of the Customer Is : " + customer.getAddress());
        customer.setAddress(customer.getAddress().changeAddress("Boston", "MA", "100 Ocean View Drive B Sector", 02125));
        System.out.println("The new Address of the customer is : " + customer.getAddress());
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new CustomerAddressMultiThread());
        Thread thread2 = new Thread(new CustomerAddressMultiThread());

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

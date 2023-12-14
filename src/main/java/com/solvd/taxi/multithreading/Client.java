package com.solvd.taxi.multithreading;

public class Client implements Runnable {
    private ConnectionPool pool;

    public Client(ConnectionPool pool) {
        this.pool = pool;
    }

    @Override
    public void run() {
        Connection connection = pool.getConnection();
        if (connection != null) {
            // Print name of thread
            System.out.println(Thread.currentThread().getName() + " obtained " + connection.getName());
            try {
                Thread.sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            pool.releaseConnection(connection);
        }
    }

    public static void main(String[] args) {
        ConnectionPool pool = ConnectionPool.getInstance();
        for (int i = 0; i < 10; i++) {
            new Thread(new Client(pool), "Thread " + (i + 1)).start();
        }
    }
}

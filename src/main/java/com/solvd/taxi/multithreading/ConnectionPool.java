package com.solvd.taxi.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class ConnectionPool {
    private static volatile ConnectionPool connectionPool = null;
    private List<Connection> availableConnections = new ArrayList<>();
    private List<Connection> usedConnections = new ArrayList<>();
    private static final int MAX_CONNECTIONS = 5;

    private ConnectionPool() {
        IntStream.rangeClosed(1, MAX_CONNECTIONS).forEach(i -> {
            availableConnections.add(new Connection("Connection " + i));
        });
    }

    public static ConnectionPool getInstance() {
        if (connectionPool == null) {
            synchronized (ConnectionPool.class) {
                if (connectionPool == null) {
                    connectionPool = new ConnectionPool();
                }
            }
        }
        return connectionPool;
    }

    public synchronized Connection getConnection() {
        // return connection
        if (availableConnections.isEmpty()) {
            try {
                System.out.println(Thread.currentThread().getName() + " is waiting for a connection");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return null;
            }
        }
        Connection connection = availableConnections.remove(0);
        usedConnections.add(connection);
        return connection;
    }

    public synchronized void releaseConnection(Connection connection) {
        // return back connection
        availableConnections.add(connection);
        usedConnections.remove(connection);
        System.out.println(connection.getName() + " is released back to the pool");
        notifyAll();
    }
}

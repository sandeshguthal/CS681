package edu.umb.cs681.hw18;


@FunctionalInterface
interface Observer {
    void update(Observable obs, Object obj);
}

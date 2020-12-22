package edu.umb.cs681.hw16;


@FunctionalInterface
interface Observer {
    void update(Observable obs, Object obj);
}

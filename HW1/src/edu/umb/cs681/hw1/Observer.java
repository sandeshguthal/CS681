
package edu.umb.cs681.hw1;

@FunctionalInterface
interface Observer {
    void update(Observable obs, Object obj);
}

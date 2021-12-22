package sample;

import java.util.Objects;

public class LimitedObject<T> implements Comparable<LimitedObject> {
    int numberOfInvokes;
    T object;

    public LimitedObject(T object) {
        this.object = object;
        this.numberOfInvokes = 0;
    }

    public void invoke() {
        this.numberOfInvokes++;
    }

    public Integer getNumberOfInvokes() {
        return numberOfInvokes;
    }

    public void setNumberOfInvokes(Integer numberOfInvokes) {
        this.numberOfInvokes = numberOfInvokes;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    @Override
    public boolean equals(Object o) {
        return o.equals(this.object);
    }

    @Override
    public int hashCode() {
        return Objects.hash(object);
    }

    @Override
    public String toString() {
        return "\nLimitedObject{" +
                "numberOfInvokes=" + numberOfInvokes +
                ", object=" + object +
                '}';
    }

    @Override
    public int compareTo(LimitedObject o) {
        return this.object.equals(o) ? 1 : -1;
    }

}

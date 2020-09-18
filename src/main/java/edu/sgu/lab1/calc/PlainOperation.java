package edu.sgu.lab1.calc;

import java.lang.reflect.Method;

public class PlainOperation {
    private Object instance;
    private Method method;

    public PlainOperation(Object instance, Method method) {
        this.instance = instance;
        this.method = method;
    }

    public Object getInstance() {
        return instance;
    }

    public void setInstance(Object instance) {
        this.instance = instance;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }
}

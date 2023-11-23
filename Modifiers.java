class Modifiers {

}

class MyClass {
    private int myField;

    private void myMethod() {
        // ...
    }
}

class MyBaseClass {
    protected int myField;
}

class MyDerivedClass extends MyBaseClass {
    void myMethod() {
        myField = 42; // Accessing protected member from a subclass
    }
}
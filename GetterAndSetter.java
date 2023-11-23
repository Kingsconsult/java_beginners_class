public class GetterAndSetter {

    public static void main(String[] args) {

        AccessGetterAndSetter accessGetterAndSetter = new AccessGetterAndSetter();

        accessGetterAndSetter.setName("kings");
        accessGetterAndSetter.setAge(25);

        String name = accessGetterAndSetter.getName();
        int age = accessGetterAndSetter.getAge();

        System.out.println("My name is " + name + ", and I am " + age + " years old");
    }
}

class AccessGetterAndSetter {
    String name;
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
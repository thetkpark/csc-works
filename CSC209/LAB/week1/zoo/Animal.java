/**
 * Animal
 */
public class Animal {

    String name,color,type;
    int age;
    char sex;


    public Animal(){
        this("no name", "brown", "deer", 1, 'M');
    }

    public Animal(String name, String color, String type, int age, char sex){
        this.name = name;
        this.type = type;
        this.setColor(color);
        this.age = age;
        this.setSex(sex);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if(type.equalsIgnoreCase("bear")){
            if(color.equalsIgnoreCase("white") || color.equalsIgnoreCase("brown") || color.equalsIgnoreCase("black")){
                this.color = color;
            }
            System.out.println("This is not the color of bear");
        }else{
            this.color = color;
        }
    }

    public String toString(){
        return "Animal{" + " name=" + this.name + ", age=" + this.age + ", color=" + this.color + ", type=" + this.type + ", sex=" + this.sex + "}";
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSex(){
        return this.sex;
    }

    public void setSex(char sex){
        if(sex == 'M' || sex == 'F'){
            this.sex = sex;
        }
    }

    

}
/**
 * <h3>DoubleSilly</h3>
 * <P></p>
 *
 * @author i2silly
 * @date 2020/01/13
 */
public class User {
    private String name;

    private int id;

    private String sex;

    private int age;

    public User() {
    }

    public User(String name, int id, String sex, int age) {
        this.name = name;
        this.id = id;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}

package cn.xiao;

/**
 * Created by Smile on 2018/4/16.
 */
public class User {
    private int id;
    private int age;
    private String name;

    public int getId()
    {
        return this.id;
    }
    public int getAge()
    {
        return this.age;
    }
    public String getName()
    {
        return this.name;
    }


    public void setId(int id) {this.id = id; }
    public void setAge(int age)
    {
        this.age = age;
    }
    public void setName(String name)
    {
        this.name = name;
    }

}


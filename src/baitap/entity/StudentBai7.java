package baitap.entity;

import java.io.Serializable;

public class StudentBai7 implements Serializable
{
    private int id;
    private String name;

    public StudentBai7(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "StudentBai7{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

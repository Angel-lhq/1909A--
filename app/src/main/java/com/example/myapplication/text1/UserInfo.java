package com.example.myapplication.text1;

@TableName(tableName = "UserInfo")
public class UserInfo {

    @ColumnName(columnName = "name")
    private String name;
    @ColumnName(columnName = "id")
    private int id;
    @ColumnName(columnName = "apparence")
    private String apparence;

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

    public String getApparence() {
        return apparence;
    }

    public void setApparence(String apparence) {
        this.apparence = apparence;
    }
}

package com.sugary.jsonparsermaptest.entity;

import java.io.Serializable;

/**
 * Created by Ethan on 2017/6/21.
 * 目录实体类
 */

public class CategoryEntity implements Serializable {

    private String id;
    private String name;

    private boolean selected = false;

    public CategoryEntity() {
    }

    public CategoryEntity(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public CategoryEntity(String id, String name, boolean selected) {
        this.id = id;
        this.name = name;
        this.selected = selected;
    }

    public boolean getSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CategoryEntity)) return false;

        CategoryEntity that = (CategoryEntity) o;

        return getName().equals(that.getName());

    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }

    @Override
    public String toString() {
        return "CategoryEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", selected=" + selected +
                '}';
    }
}

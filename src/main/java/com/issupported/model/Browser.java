package com.issupported.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "browser")
public class Browser implements Serializable {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany
    @Fetch(FetchMode.JOIN)
    @JoinTable(
            name = "browser_to_version",
            joinColumns = @JoinColumn(name = "browser_id"),
            inverseJoinColumns = @JoinColumn(name = "version_id")
    )
    private List<Version> versions;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Version> getVersions() {
        return versions;
    }

    public void setVersions(List<Version> versions) {
        this.versions = versions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Browser browser = (Browser) o;

        if (id != browser.id) return false;
        if (!name.equals(browser.name)) return false;
        return versions.equals(browser.versions);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + versions.hashCode();
        return result;
    }
}

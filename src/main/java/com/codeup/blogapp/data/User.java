package com.codeup.blogapp.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Collection;
import java.util.Date;
//Create the fields
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String username;

    @Email
    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    //    private Date createdAt;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role = Role.USER;

    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties("user")
    private Collection<Post> posts;


    public User(long id, String username, String email, String password) {

        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;

    }

    public User() {

    }

    //POJO
    public enum Role {USER, ADMIN}

    public User (String username){
        this.username = username;
    }
    public User(long id, String username, String email, String password, Collection<Post> posts) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.posts = posts;
//        this.createdAt = createdAt;

    }


//Getters and Setters


    public Collection<Post> getPosts() {
        return posts;
    }

    public void setPosts(Collection<Post> posts) {
        this.posts = posts;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public Date getCreatedAt() {
//        return createdAt;
//    }

//    public void setCreatedAt(Date createdAt) {
////        this.createdAt = createdAt;
//    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

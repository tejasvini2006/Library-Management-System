package com.example.library.librarysystem.entity;

import jakarta.persistence.*;
@Entity
@Table(name = "authorities")
 
public class Authorities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username", nullable = false)
    private Users user;


    @Column(length = 500, nullable = false)
    private String authority;
    
    
    

	public Authorities() {
		super();
	}

	public Authorities(Long id, Users user, String authority) {
		super();
		this.id = id;
		this.user = user;
		this.authority = authority;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
    
    
}

package com.lismart.smartregie.domain;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Date;

@Entity(name = "users")
public class User extends Person {

    @Column(length = 60)
    @Size(min = 8)
    private String password;

    private boolean enabled;

    @Temporal(TemporalType.DATE)
    @Past
    private Date birthday;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;
    
    @ManyToOne
	@JoinColumn(name="id_service")
	private Service service;
    
    @OneToMany(cascade=CascadeType.ALL)
    private Collection<Courrier> courriers;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Collection<Courrier> getCourriers() {
		return courriers;
	}

	public void setCourriers(Collection<Courrier> courriers) {
		this.courriers = courriers;
	}
    
    
}

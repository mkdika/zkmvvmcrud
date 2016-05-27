package com.mkdika.zkmvvmcrud.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OptimisticLock;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Maikel Chandika <mkdika@gmail.com>
 */
@Entity
@Table(name = "tb_person", schema = "testing")
public class TbPerson implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", length = 32, nullable = false)
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @Column(name = "firstname", length = 255, nullable = false)
    @NotNull(message = "First Name can't empty.")
    @NotEmpty(message = "First Name can't empty.")
    private String firstname;

    @Column(name = "lastname", length = 255, nullable = false)
    @NotNull(message = "Last Name can't empty.")
    @NotEmpty(message = "Last Name can't empty.")
    private String lastname;

    /*
    List of Value:
    0 = FEMALE
    1 = MALE
     */
    @Column(name = "gender", length = 1, nullable = false)
    @NotNull(message = "Gender must be valid.")
    private Integer gender;

    @Column(name = "birthday", nullable = false)
    @NotNull(message = "Birthday can't empty.")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date birthday;

    /*
    List of Value:
    0 = KTP
    1 = SIM
    2 = PASPOR
    3 = KITAS
     */
    @Column(name = "idtype", length = 1, nullable = false)
    @NotNull(message = "ID Type must be valid.")
    private Integer idtype;

    @Column(name = "idnumber", length = 50, nullable = false)
    @NotNull(message = "ID Number can't empty.")
    @NotEmpty(message = "ID Number can't empty.")
    private String idnumber;

    @Column(name = "email", length = 100, nullable = false)
    @NotNull(message = "Email can't empty.")
    @NotEmpty(message = "Email can't empty.")
    @Email(message = "Not a valid email address.")
    private String email;

    @Column(name = "phonenumber", length = 50, nullable = false)
    @NotNull(message = "Phone Number can't empty.")
    @NotEmpty(message = "Phone Number can't empty.")
    private String phonenumber;

    @Column(name = "address", length = 255, nullable = true)
    private String address;

    @OrderBy(value = "dtfrom")
    @OptimisticLock(excluded = true)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "person")
    private List<TbExperience> experiences;

    public TbPerson() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getIdtype() {
        return idtype;
    }

    public void setIdtype(Integer idtype) {
        this.idtype = idtype;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public List<TbExperience> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<TbExperience> experiences) {
        this.experiences = experiences;
    }
}

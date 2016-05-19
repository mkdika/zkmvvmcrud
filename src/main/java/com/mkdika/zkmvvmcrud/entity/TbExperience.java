
package com.mkdika.zkmvvmcrud.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Maikel Chandika <mkdika@gmail.com>
 */
@Entity
@Table(name = "tb_experience",  schema = "testing")
public class TbExperience implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "id",length = 32,nullable = false)
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
        
    @JoinColumn(name = "person", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private TbPerson person;
    
    @Column(name = "companyname",length = 255,nullable = false)
    @NotNull(message = "Company Name can't empty.")
    @NotEmpty(message = "Company Name can't empty.")
    private String companyname;
    
    @Column(name = "companysector",length = 1,nullable = false)    
    @NotNull(message = "Company Sector can't empty.")
    private Integer companysector;
    
    @Column(name = "companyaddress1",length = 255,nullable = true)    
    private String companyaddress1;
    
    @Column(name = "companyaddress2",length = 255,nullable = true)    
    private String companyaddress2;
    
    @Column(name = "companycity",length = 255,nullable = true)    
    private String companycity;
    
    @Column(name = "companyprovince",length = 255,nullable = true)    
    private String companyprovince;
    
    @Column(name = "companycountry",length = 255,nullable = true)    
    private String companycountry;
        
    @Column(name = "companyzipcode",length = 6,nullable = true)    
    private String companyzipcode;
    
    @Column(name = "companyemail",length = 50,nullable = true)    
    @Email(message = "Not a valid Company Email.")
    private String companyemail;
    
    @Column(name = "companywebsite",length = 100,nullable = true)    
    private String companywebsite;
            
    @Column(name = "position",length = 255,nullable = false)    
    @NotNull(message = "Position can't empty.")
    @NotEmpty(message = "Position can't empty.")
    private String position;
    
    @Column(name = "dtfrom",nullable = false)    
    @Temporal(javax.persistence.TemporalType.DATE)
    @NotNull(message = "Since Date can't empty.")
    private Date dtfrom;
    
    @Column(name = "dtto",nullable = false)    
    @Temporal(javax.persistence.TemporalType.DATE)
    @NotNull(message = "to Date can't empty.")
    private Date dtto;
    
    @Column(name = "salary",nullable = true)  
    private BigDecimal salary;
    
    @Column(name = "mealallowance",nullable = true)  
    private BigDecimal mealallowance;
    
    @Column(name = "transportallowance",nullable = true)  
    private BigDecimal transportallowance;
    
    @Column(name = "otherallowance",nullable = true)  
    private BigDecimal otherallowance;
    
    @Column(name = "bonus",nullable = true)  
    private BigDecimal bonus;
    
    @Column(name = "insurance",nullable = true)  
    private BigDecimal insurance;
            
    @Column(name = "duty",length = 255,nullable = true)    
    private String duty;
    
    @Column(name = "achievement",length = 255,nullable = true)
    private String achievement;
    
    @Column(name = "leavingreason",length = 255,nullable = false)    
    @NotNull(message = "Leaving Reason can't empty.")
    @NotEmpty(message = "Leaving Reason can't empty.")
    private String leavingreason;
    
    @Column(name = "note",length = 255,nullable = true)
    private String note;
    
    public TbExperience() {
        
    }
    
    public TbExperience(TbPerson person) {
        this.person = person;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TbPerson getPerson() {
        return person;
    }

    public void setPerson(TbPerson person) {
        this.person = person;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public Integer getCompanysector() {
        return companysector;
    }

    public void setCompanysector(Integer companysector) {
        this.companysector = companysector;
    }

    public String getCompanyaddress1() {
        return companyaddress1;
    }

    public void setCompanyaddress1(String companyaddress1) {
        this.companyaddress1 = companyaddress1;
    }

    public String getCompanyaddress2() {
        return companyaddress2;
    }

    public void setCompanyaddress2(String companyaddress2) {
        this.companyaddress2 = companyaddress2;
    }

    public String getCompanycity() {
        return companycity;
    }

    public void setCompanycity(String companycity) {
        this.companycity = companycity;
    }

    public String getCompanyprovince() {
        return companyprovince;
    }

    public void setCompanyprovince(String companyprovince) {
        this.companyprovince = companyprovince;
    }

    public String getCompanycountry() {
        return companycountry;
    }

    public void setCompanycountry(String companycountry) {
        this.companycountry = companycountry;
    }

    public String getCompanyzipcode() {
        return companyzipcode;
    }

    public void setCompanyzipcode(String companyzipcode) {
        this.companyzipcode = companyzipcode;
    }

    public String getCompanyemail() {
        return companyemail;
    }

    public void setCompanyemail(String companyemail) {
        this.companyemail = companyemail;
    }

    public String getCompanywebsite() {
        return companywebsite;
    }

    public void setCompanywebsite(String companywebsite) {
        this.companywebsite = companywebsite;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getDtfrom() {
        return dtfrom;
    }

    public void setDtfrom(Date dtfrom) {
        this.dtfrom = dtfrom;
    }

    public Date getDtto() {
        return dtto;
    }

    public void setDtto(Date dtto) {
        this.dtto = dtto;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public BigDecimal getMealallowance() {
        return mealallowance;
    }

    public void setMealallowance(BigDecimal mealallowance) {
        this.mealallowance = mealallowance;
    }

    public BigDecimal getTransportallowance() {
        return transportallowance;
    }

    public void setTransportallowance(BigDecimal transportallowance) {
        this.transportallowance = transportallowance;
    }

    public BigDecimal getOtherallowance() {
        return otherallowance;
    }

    public void setOtherallowance(BigDecimal otherallowance) {
        this.otherallowance = otherallowance;
    }

    public BigDecimal getBonus() {
        return bonus;
    }

    public void setBonus(BigDecimal bonus) {
        this.bonus = bonus;
    }

    public BigDecimal getInsurance() {
        return insurance;
    }

    public void setInsurance(BigDecimal insurance) {
        this.insurance = insurance;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getAchievement() {
        return achievement;
    }

    public void setAchievement(String achievement) {
        this.achievement = achievement;
    }

    public String getLeavingreason() {
        return leavingreason;
    }

    public void setLeavingreason(String leavingreason) {
        this.leavingreason = leavingreason;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }               
}

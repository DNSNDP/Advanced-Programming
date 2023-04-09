package com.bumblebee.system.model;

import javax.persistence.*;

@Entity
@Table(name="CUSTOMER" ,uniqueConstraints = {

        @UniqueConstraint(columnNames = "email")
})

public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;
    @Column(name="email")
    public String email;
    @Column(name="name")
    public String name;
    @Column(name="installement")
    public String installment;

    @Column(name="dateOfBirth")
    public String dateOfBirth;
    @Column(name="loanBalance")
    public Integer loanBalance;

    @Column(name="budget")
    public Integer budget;
    @Column(name="usedAmount")
    public Integer usedAmount;
    @Column(name="password")
    public String password;


    @Column(name="installmentPlan")
    public Integer installmentPlan;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getLoanBalance() {
        return loanBalance;
    }

    public void setLoanBalance(Integer loanBalance) {
        this.loanBalance = loanBalance;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public Integer getUsedAmount() {
        return usedAmount;
    }

    public void setUsedAmount(Integer usedAmount) {
        this.usedAmount = usedAmount;
    }

    public Integer getInstallmentPlan() {
        return installmentPlan;
    }

    public void setInstallmentPlan(Integer installmentPlan) {
        this.installmentPlan = installmentPlan;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getInstallment() {
		return installment;
	}

	public void setInstallment(String installment) {
		this.installment = installment;
	}

	@Override
	public String toString() {
		return "Customers [id=" + id + ", email=" + email + ", name=" + name + ", installment=" + installment
				+ ", dateOfBirth=" + dateOfBirth + ", loanBalance=" + loanBalance + ", budget=" + budget
				+ ", usedAmount=" + usedAmount + ", password=" + password + ", installmentPlan=" + installmentPlan
				+ "]";
	}

	
}

package org.openhds.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.openhds.domain.contract.AuditableEntity;
import org.openhds.domain.util.Description;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Description(description = "A Field Worker represents a surveyor working in the study area.")
@Entity
@Table(name = "fieldworker")
public class FieldWorker extends AuditableEntity implements Serializable {

    private static final long serialVersionUID = -7550088299362704483L;

    @NotNull(message = "field worker fieldWorkerId may not be null")
    @Description(description = "User-facing Id of the field worker")
    String fieldWorkerId;

    @Description(description = "First name of the field worker.")
    String firstName;

    @Description(description = "Last name of the field worker.")
    String lastName;

    @Description(description = "Password entered for a new field worker.")
    @Transient
    @JsonIgnore
    String password;

    @NotNull(message = "field worker passwordHash may not be null")
    @Description(description = "Hashed version of a field worker's password.")
    String passwordHash;

    public String getFieldWorkerId() {
        return fieldWorkerId;
    }

    public void setFieldWorkerId(String fieldWorkerId) {
        this.fieldWorkerId = fieldWorkerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    @Override
    public String toString() {
        return "FieldWorker{" +
                "fieldWorkerId='" + fieldWorkerId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                "} " + super.toString();
    }
}

package org.openhds.domain.model.update;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.openhds.domain.contract.AuditableCollectedEntity;
import org.openhds.domain.model.census.Individual;
import org.openhds.domain.util.Description;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wolfe on 7/14/2015.
 */
@Description(description = "A pregnancy outcome for a female individual. This contains a list of pregnancy results.")
@Entity
@Table(name = "PregnancyOutcome", indexes={@Index(columnList = "lastModifiedDate")})
public class PregnancyOutcome extends AuditableCollectedEntity implements Serializable {

    private static final long serialVersionUID = 5179378759539398625L;

    @Description(description = "Total number of children born, including live and still births.")
    private int childrenBorn;

    @Description(description = "Total number of live births.")
    private int numberOfLiveBirths;

    @Description(description = "Date of the pregnancy outcome.")
    private ZonedDateTime outcomeDate;

    @ManyToOne
    @Description(description = "Visit that is associated with the pregnancy outcome.")
    private Visit visit;

    @NotNull
    @ManyToOne
    @Description(description = "Mother of the pregnancy outcome.")
    private Individual mother;

    @ManyToOne
    @Description(description = "Father of the pregnancy outcome.")
    private Individual father;

    @JsonIgnore
    @OneToMany(mappedBy = "pregnancyOutcome")
    @Description(description = "List of all outcomes for the pregnancy.")
    private List<PregnancyResult> pregnancyResults = new ArrayList<>();

    public int getChildrenBorn() {
        return childrenBorn;
    }

    public void setChildrenBorn(int childrenBorn) {
        this.childrenBorn = childrenBorn;
    }

    public int getNumberOfLiveBirths() {
        return numberOfLiveBirths;
    }

    public void setNumberOfLiveBirths(int numberOfLiveBirths) {
        this.numberOfLiveBirths = numberOfLiveBirths;
    }

    public ZonedDateTime getOutcomeDate() {
        return outcomeDate;
    }

    public void setOutcomeDate(ZonedDateTime outcomeDate) {
        this.outcomeDate = outcomeDate;
    }

    public Visit getVisit() {
        return visit;
    }

    public void setVisit(Visit visit) {
        this.visit = visit;
    }

    public Individual getMother() {
        return mother;
    }

    public void setMother(Individual mother) {
        this.mother = mother;
    }

    public Individual getFather() {
        return father;
    }

    public void setFather(Individual father) {
        this.father = father;
    }

    public List<PregnancyResult> getPregnancyResults() {
        return pregnancyResults;
    }

    public void setPregnancyResults(List<PregnancyResult> pregnancyResults) {
        this.pregnancyResults = pregnancyResults;
    }

    @Override
    public String toString() {
        return "PregnancyOutcome{" +
                "visit=" + visit +
                ", childrenBorn=" + childrenBorn +
                ", numberOfLiveBirths=" + numberOfLiveBirths +
                ", outcomeDate=" + outcomeDate +
                "} " + super.toString();
    }

}

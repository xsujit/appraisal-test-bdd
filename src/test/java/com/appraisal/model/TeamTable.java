
package com.appraisal.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "First Name",
    "Employee Id",
    "Appraisal",
    "My Vote",
    "Sr. No",
    "Last Name"
})
public class TeamTable {

    @JsonProperty("First Name")
    private String firstName;
    @JsonProperty("Employee Id")
    private String employeeId;
    @JsonProperty("Appraisal")
    private String appraisal;
    @JsonProperty("My Vote")
    private String myVote;
    @JsonProperty("Sr. No")
    private String srNo;
    @JsonProperty("Last Name")
    private String lastName;

    @JsonProperty("First Name")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("First Name")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public TeamTable withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @JsonProperty("Employee Id")
    public String getEmployeeId() {
        return employeeId;
    }

    @JsonProperty("Employee Id")
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public TeamTable withEmployeeId(String employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    @JsonProperty("Appraisal")
    public String getAppraisal() {
        return appraisal;
    }

    @JsonProperty("Appraisal")
    public void setAppraisal(String appraisal) {
        this.appraisal = appraisal;
    }

    public TeamTable withAppraisal(String appraisal) {
        this.appraisal = appraisal;
        return this;
    }

    @JsonProperty("My Vote")
    public String getMyVote() {
        return myVote;
    }

    @JsonProperty("My Vote")
    public void setMyVote(String myVote) {
        this.myVote = myVote;
    }

    public TeamTable withMyVote(String myVote) {
        this.myVote = myVote;
        return this;
    }

    @JsonProperty("Sr. No")
    public String getSrNo() {
        return srNo;
    }

    @JsonProperty("Sr. No")
    public void setSrNo(String srNo) {
        this.srNo = srNo;
    }

    public TeamTable withSrNo(String srNo) {
        this.srNo = srNo;
        return this;
    }

    @JsonProperty("Last Name")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("Last Name")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public TeamTable withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Override
    public String toString() {
        return "TeamTable{" +
                "firstName='" + firstName + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", appraisal='" + appraisal + '\'' +
                ", myVote='" + myVote + '\'' +
                ", srNo='" + srNo + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeamTable teamTable = (TeamTable) o;
        return firstName.equals(teamTable.firstName) &&
                employeeId.equals(teamTable.employeeId) &&
                lastName.equals(teamTable.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, employeeId, lastName);
    }
}

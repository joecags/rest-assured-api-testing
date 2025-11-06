package org.loonycorn.bugs_api.model;

import java.util.UUID;
import java.time.LocalDateTime;

public class Bug {
    private int id; // Internal numeric ID
    private String bugId; // Public UUID string ID
    private String createdBy; // User who created the bug
    private LocalDateTime createdOn; // Timestamp when the bug was created
    private LocalDateTime updatedOn; // Timestamp when the bug was last updated
    private Integer priority; // Priority level of the bug
    private String severity; // Severity level of the bug
    private String title; // Title of the bug
    private Boolean completed; // Completion status of the bug

    // Full constructor (commented out for now)
    // public Bug(int id,String createdBy, Integer priority, String severity, String
    // title, Boolean completed) {
    // this.id = id; //in future when adding bugs dynamically in a POST / bugs
    // endpoing use this.id = nextId++;
    // this.bugId = UUID.randomUUID().toString();
    // this.createdBy = createdBy;
    // this.createdOn = LocalDateTime.now();
    // this.updatedOn = LocalDateTime.now();
    // this.priority = priority;
    // this.severity = severity;
    // this.title = title;
    // this.completed = false;
    // }

    // Short test constructor (3 params)
    public Bug(int id, String title, String severity) {
        this.id = id;
        this.bugId = UUID.randomUUID().toString();
        this.createdBy = "System"; // default for testing
        this.createdOn = LocalDateTime.now();
        this.updatedOn = LocalDateTime.now();
        this.priority = 1;
        this.severity = severity;
        this.title = title;
        this.completed = false;
    }

    public int getId() {
        return id;
    }

    public String getBugId() {
        return bugId;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public Integer getPriority() {
        return priority;
    }

    public String getSeverity() {
        return severity;
    }

    public String getTitle() {
        return title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBugId(String bugId) {
        this.bugId = bugId;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }
}

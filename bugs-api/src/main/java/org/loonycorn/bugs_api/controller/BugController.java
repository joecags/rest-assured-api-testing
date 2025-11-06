package org.loonycorn.bugs_api.controller;

import org.loonycorn.bugs_api.model.Bug;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;
// import java.util.Optional;
import java.time.LocalDateTime;
// import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class BugController {
    private List<Bug> bugs = new ArrayList<Bug>();
    private int nextId = 4; // start after your 3 sample bugs

    @GetMapping("/")
    public String welcome() {
        return "Welcome to the Bug Tracking API!";
    }

    @GetMapping("/bugs")
    public ResponseEntity<List<Bug>> getBugs() {
        return ResponseEntity.ok(bugs);
    }

    // @GetMapping("/bugs")
    // public List<Bug> getAllBugs(Integer id, String title, String severity) {
    // return List.of(
    // new Bug(1, "Login fails on invalid password", "High"),
    // new Bug(2, "UI overlaps on small screens", "Medium"),
    // new Bug(3, "Tooltip text misaligned", "Low")
    // );
    // }

    @GetMapping("/bugs/{bugId}")
    public ResponseEntity<?> getBug(@PathVariable String bugId) {
        Bug bug = bugs.stream().filter(b -> b.getBugId().equals(bugId)).findFirst().orElse(null);
        if (bug != null) {
            return ResponseEntity.ok(bug);
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(Collections.singletonMap("error", "Bug not found"));
        }
    }

    @PostMapping("/bugs")
    public ResponseEntity<?> createBug(@RequestBody Bug bug) {
        bug.setCreatedBy("System"); // optional: default for testing
        bug.setCreatedOn(LocalDateTime.now());
        bug.setUpdatedOn(LocalDateTime.now());
        bug.setId(nextId++); // ✅ auto-increment the ID
        bugs.add(bug);

        return ResponseEntity.status(HttpStatus.CREATED).body(bug);
    }

    @PutMapping("/bugs/{bugId}")
    public ResponseEntity<?> updateBug(@PathVariable String bugId, @RequestBody Bug updatedBug) {
        Bug bugToUpdate = bugs.stream()
                .filter(b -> b.getBugId().equals(bugId))
                .findFirst()
                .orElse(null);

        if (bugToUpdate != null) {
            bugToUpdate.setCreatedBy(updatedBug.getCreatedBy());
            bugToUpdate.setPriority(updatedBug.getPriority());
            bugToUpdate.setSeverity(updatedBug.getSeverity());
            bugToUpdate.setTitle(updatedBug.getTitle());
            bugToUpdate.setCompleted(updatedBug.getCompleted());
            bugToUpdate.setUpdatedOn(LocalDateTime.now());

            return ResponseEntity.ok(bugToUpdate);
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(Collections.singletonMap("error", "Bug not found"));
        }
    }

    @PatchMapping("/bugs/{bugId}")
    public ResponseEntity<?> patchBug(@PathVariable String bugId, @RequestBody Bug updatedBug) {
        Bug bugToPatch = bugs.stream()
                .filter(b -> b.getBugId().equals(bugId))
                .findFirst()
                .orElse(null);

        if (bugToPatch != null) {
            if (updatedBug.getCreatedBy() != null) {
                bugToPatch.setCreatedBy(updatedBug.getCreatedBy());
            }
            if (updatedBug.getPriority() != null) {
                bugToPatch.setPriority(updatedBug.getPriority());
            }
            if (updatedBug.getSeverity() != null) {
                bugToPatch.setSeverity(updatedBug.getSeverity());
            }
            if (updatedBug.getTitle() != null) {
                bugToPatch.setTitle(updatedBug.getTitle());
            }
            if (updatedBug.getCompleted() != null) {
                bugToPatch.setCompleted(updatedBug.getCompleted());
            }
            bugToPatch.setUpdatedOn(LocalDateTime.now());

            return ResponseEntity.ok(bugToPatch);
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(Collections.singletonMap("error", "Bug not found"));
        }
    }

    @DeleteMapping("/bugs/{bugId}")
    public ResponseEntity<?> deleteBug(@PathVariable String bugId) {
        Bug bug = bugs.stream()
                .filter(b -> b.getBugId().equals(bugId))
                .findFirst()
                .orElse(null);

        if (bug != null) {
            bugs.remove(bug);

            Map<String, String> responseMessage = new HashMap<>();
            responseMessage.put("message", "Bug deleted successfully");
            responseMessage.put("bugId", bugId);

            return ResponseEntity.ok(responseMessage);
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(Collections.singletonMap("error", "Bug not found"));
        }
    }
}

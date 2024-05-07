package com.example.javacodepractice.Task1;

import org.springframework.stereotype.Component;

@Component
public class Repository {
    Snapshot snapshot;

    public Snapshot getSnapshot() {
        return snapshot;
    }

    public void setSnapshot(Snapshot snapshot) {
        this.snapshot = snapshot;
    }
}

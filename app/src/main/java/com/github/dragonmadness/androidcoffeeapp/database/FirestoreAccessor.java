package com.github.dragonmadness.androidcoffeeapp.database;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class FirestoreAccessor {
    private final FirebaseFirestore instance = FirebaseFirestore.getInstance();

    public void getDepartments(Consumer<List<String>> onComplete) {
        instance.collection("departments").get().addOnCompleteListener(task -> {
            onComplete.accept(task.getResult().getDocuments().stream()
                    .map(document -> document.getString("address"))
                    .collect(Collectors.toList()));
        });
    }
}

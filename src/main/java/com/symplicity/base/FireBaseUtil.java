package com.symplicity.base;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Component
public class FireBaseUtil {

    private static String FIRESTORE_DB_NAME = "vote-symplicity-firestore";
    private Firestore db = null;

    @PostConstruct
    public void init() {
        GoogleCredentials credentials = null;
        try {

            credentials = GoogleCredentials.fromStream(FireBaseUtil.class.getResourceAsStream("/vote-symplicity-firestore-bae53fe5e3f8.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(credentials)
                .setProjectId(FIRESTORE_DB_NAME)
                .build();
        FirebaseApp.initializeApp(options);
        db = FirestoreClient.getFirestore();
    }

    public void saveVote( String userName, String fruit) {
        try {
        DocumentReference docRef = db.collection("users").document("votes");
        Map<String, Object> data = new HashMap<>();
        data.put("userName", userName);
        data.put("fruit", fruit);
        ApiFuture<WriteResult> result = docRef.set(data);
        System.out.println("Update time : " + result.get().getUpdateTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

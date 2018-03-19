package com.symplicity.base;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.symplicity.web.model.Vote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutionException;

@Component
public class FireBaseUtil {
    private final Logger logger = LoggerFactory.getLogger(FireBaseUtil.class);
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

    public void saveVote(String userName, String fruit) {
        DocumentReference docRef = db.collection("votes").document(userName);
        Map<String, Object> data = new HashMap<>();
        data.put("fruit", fruit);
        ApiFuture<WriteResult> result = docRef.set(data);
        // System.out.println("Update time : " + result.get().getUpdateTime());
        logger.info("vote is saved to DataBase");
    }

    public Map<String, Integer> getVotes() {
        List<QueryDocumentSnapshot> documents = null;
//        List<Vote> votes = new ArrayList<Vote>();
        Map<String,Integer> fruitCount = new HashMap();

        try {
            ApiFuture<QuerySnapshot> future = db.collection("votes").get();
            documents = future.get().getDocuments();

            for (QueryDocumentSnapshot document : documents) {
//                Vote vote = new Vote();
                String fruitName = document.get("fruit").toString();
//                vote.setFruit(fruitName);
                if(!fruitCount.containsKey(fruitName)){
                    fruitCount.put(fruitName,  1);
                }else {
                    fruitCount.put(fruitName, fruitCount.get(fruitName) + 1);
                }
//                vote.setUserName(document.getId());
//                vote.setFruitCount(fruitCount);
//                votes.add(vote);
               // System.out.println(document.getId() + " => " + document.toObject(Vote.class));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return fruitCount;
    }



}

package ec.edu.espol.proyectoed.model;

/**
 *
 * @author Matías_Collaguazo
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class FirebaseDatabase implements Database {

    private static volatile FirebaseDatabase instance;
    private static final String DATABASE_URL = "https://proyectoed-5cec6-default-rtdb.firebaseio.com/";
    private FirebaseDatabase() {}//Singleton ;u

    public static FirebaseDatabase getInstance() {
        FirebaseDatabase instance = FirebaseDatabase.instance;
        if (instance == null) {
            synchronized (FirebaseDatabase.class) {
                instance = FirebaseDatabase.instance;
                if (instance == null) {
                    FirebaseDatabase.instance = instance = new FirebaseDatabase();
                }
            }
        }
        return instance;
    }

    @Override
    public void saveData(String path, String data) {
        try {
            URL url = new URL(DATABASE_URL + path + ".json");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            connection.setDoOutput(true);

            try (OutputStream os = connection.getOutputStream()) {
                os.write(data.getBytes("utf-8"));
            }

            try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                System.out.println("Save Response: " + response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getData(String path) {
        StringBuilder response = new StringBuilder();
        try {
            URL url = new URL(DATABASE_URL + path + ".json");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response.toString();
    }

    @Override
    public void updateData(String path, String data) {
        try {
            URL url = new URL(DATABASE_URL + path + ".json");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("PUT");
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            connection.setDoOutput(true);

            try (OutputStream os = connection.getOutputStream()) {
                os.write(data.getBytes("utf-8"));
            }

            try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                System.out.println("Update Response: " + response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteData(String path) {
        try {
            URL url = new URL(DATABASE_URL + path + ".json");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("DELETE");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("Delete Success");
            } else {
                System.out.println("Delete Failed with Code: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

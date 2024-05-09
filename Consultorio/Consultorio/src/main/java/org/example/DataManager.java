package org.example;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataManager {

    private static final String DB_FOLDER_PATH = "db";
    private static final String DOCTORS_FILE = "doctores.json";
    private static final String PATIENTS_FILE = "pacientes.json";
    private static final String APPOINTMENTS_FILE = "citas.json";

    public static List<User> loadData() throws IOException {
        createDbDirectory();
        createJsonFilesIfNotExist();

        List<User> users = new ArrayList<>();
        loadJsonFile(DOCTORS_FILE, users);
        loadJsonFile(PATIENTS_FILE, users);
        loadJsonFile(APPOINTMENTS_FILE, users);

        return users;
    }

    public static void saveData(List<User> users) throws IOException {
        saveJsonFile(DOCTORS_FILE, getDoctors(users));
        saveJsonFile(PATIENTS_FILE, getPatients(users));
        saveJsonFile(APPOINTMENTS_FILE, getAppointments(users));
    }

    private static void loadJsonFile(String fileName, List<User> users) {
        File file = new File(DB_FOLDER_PATH, fileName);
        if (file.exists()) {
            try {
                users.addAll(JsonFileLoader.loadUsersFromFile(file));
            } catch (IOException e) {
                System.err.println("Error al cargar el archivo JSON: " + fileName + ": " + e.getMessage());
            }
        }
    }

    private static void saveJsonFile(String fileName, List<? extends User> data) {
        try {
            JsonFileWriter.writeJsonToFile(new File(DB_FOLDER_PATH, fileName), data);
        } catch (IOException e) {
            System.err.println("Error al guardar el archivo JSON: " + fileName + ": " + e.getMessage());
        }
    }

    private static void createDbDirectory() {
        File dbFolder = new File(DB_FOLDER_PATH);
        if (!dbFolder.exists()) {
            dbFolder.mkdir();
        }
    }

    private static void createJsonFilesIfNotExist() {
        File doctorsFile = new File(DB_FOLDER_PATH, DOCTORS_FILE);
        File patientsFile = new File(DB_FOLDER_PATH, PATIENTS_FILE);
        File appointmentsFile = new File(DB_FOLDER_PATH, APPOINTMENTS_FILE);

        if (!doctorsFile.exists() || !patientsFile.exists() || !appointmentsFile.exists()) {
            try {
                generateJsonFiles();
            } catch (IOException e) {
                System.err.println("Error al crear los archivos JSON de ejemplo: " + e.getMessage());
            }
        }
    }

    private static List<Doctor> getDoctors(List<User> users) {
        List<Doctor> doctors = new ArrayList<>();
        for (User user : users) {
            if (user instanceof Doctor) {
                doctors.add((Doctor) user);
            }
        }
        return doctors;
    }

    private static List<Patient> getPatients(List<User> users) {
        List<Patient> patients = new ArrayList<>();
        for (User user : users) {
            if (user instanceof Patient) {
                patients.add((Patient) user);
            }
        }
        return patients;
    }

    private static List<Appointment> getAppointments(List<User> users) {
        List<Appointment> appointments = new ArrayList<>();
        for (User user : users) {
            if (user instanceof Appointment) {
                appointments.add((Appointment) user);
            }
        }
        return appointments;
    }

    private static void generateJsonFiles() throws IOException {
        // Crear un JSON de ejemplo para doctores
        List<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor("doc123","Hola", "Dr. Juan Pérez", "Pediatría"));
        saveJsonFile(DOCTORS_FILE, doctors);

        // Crear un JSON de ejemplo para pacientes
        List<Patient> patients = new ArrayList<>();
        patients.add(new Patient("pac001", "María García"));
        saveJsonFile(PATIENTS_FILE, patients);

        // Crear un JSON de ejemplo para citas
        List<Appointment> appointments = new ArrayList<>();
        appointments.add(new Appointment("doc123", "pac001", "2024-05-10 09:00", "Control de embarazo"));
        saveJsonFile(APPOINTMENTS_FILE, appointments);
    }
    private static void saveJsonFile(String fileName, List<? extends User> data) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.writeValue(new File(DB_FOLDER_PATH, fileName), data);
        } catch (IOException e) {
            System.err.println("Error al guardar el archivo JSON: " + fileName + ": " + e.getMessage());
        }
    }

    private static class JsonFileLoader {
        static List<User> loadUsersFromFile(File file) throws IOException {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, User.class));
        }
    }

    private static class JsonFileWriter {
        static void writeJsonToFile(File file, List<? extends User> data) throws IOException {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.writeValue(file, data);
        }
    }
}

package org.example;
import java.util.List;

public class ProcessManager {
    public static void addDoctor(List<User> users) {
        System.out.println("Ingrese los datos del doctor:");
        String identifier = InputManager.getStringInput("Identificador único: ");
        String name = InputManager.getStringInput("Nombre completo: ");
        String specialty = InputManager.getStringInput("Especialidad: ");
        users.add(new Doctor(identifier,name, name, specialty));
    }

    public static void addPatient(List<User> users) {
        System.out.println("Ingrese los datos del paciente:");
        String identifier = InputManager.getStringInput("Identificador único: ");
        String name = InputManager.getStringInput("Nombre completo: ");
        users.add(new Patient(identifier, name));
    }

    public static void createAppointment(List<User> users) {
        System.out.println("Ingrese los datos de la cita:");
        String doctorId = InputManager.getStringInput("Identificador del doctor: ");
        String patientId = InputManager.getStringInput("Identificador del paciente: ");
        String dateTime = InputManager.getStringInput("Fecha y hora de la cita (YYYY-MM-DD HH:MM): ");
        String reason = InputManager.getStringInput("Motivo de la cita: ");
        users.add(new Appointment(doctorId, patientId, dateTime, reason));
    }

    public static void viewAppointments(List<User> users) {
        System.out.println("Lista de citas:");
        for (User user : users) {
            if (user instanceof Appointment) {
                Appointment appointment = (Appointment) user;
                System.out.println("Cita ID: " + appointment.getIdentifier());
                System.out.println("Doctor ID: " + appointment.getDoctorId());
                System.out.println("Paciente ID: " + appointment.getPatientId());
                System.out.println("Fecha y hora: " + appointment.getDateTime());
                System.out.println("Motivo: " + appointment.getReason());
                System.out.println();
            }
        }
    }

    public static void login(List<User> users) {
        System.out.println("Ingrese sus credenciales:");
        String identifier = InputManager.getStringInput("Identificador: ");
        String password = InputManager.getStringInput("Contraseña: ");

        for (User user : users) {
            if (user.getIdentifier().equals(identifier) && user.getPassword().equals(password)) {
                System.out.println("Inicio de sesión exitoso.");
                return;
            }
        }

        System.out.println("Credenciales incorrectas. Por favor, inténtelo de nuevo.");
    }

}


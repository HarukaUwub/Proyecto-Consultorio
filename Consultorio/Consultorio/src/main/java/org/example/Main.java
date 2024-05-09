package org.example;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<User> users = DataManager.loadData();
            System.out.println("Bienvenido al sistema de gestión de citas.");
            boolean exit = false;
            while (!exit) {
                System.out.println("Seleccione una opción:");
                System.out.println("1. Iniciar sesión como administrador");
                System.out.println("2. Dar de alta doctor");
                System.out.println("3. Dar de alta paciente");
                System.out.println("4. Crear cita");
                System.out.println("5. Salir");
                System.out.println("6. Ver citas");
                int option = InputManager.getIntInput("Opción: ");
                switch (option) {
                    case 1:
                        ProcessManager.login(users);
                        break;
                    case 2:
                        ProcessManager.addDoctor(users);
                        break;
                    case 3:
                        ProcessManager.addPatient(users);
                        break;
                    case 4:
                        ProcessManager.createAppointment(users);
                        break;
                    case 5:
                        exit = true;
                        break;
                    case 6:
                        ProcessManager.viewAppointments(users);
                        break;
                    default:
                        System.out.println("Opción no válida");
                }
            }

            DataManager.saveData(users);
        } catch (IOException e) {
            System.err.println("Error al cargar los datos: " + e.getMessage());
        }
    }
}

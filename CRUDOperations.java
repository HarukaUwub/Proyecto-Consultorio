import java.sql.*;

public class CRUDOperations {

    // Método para establecer la conexión con la base de datos
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/music";
        String user = "Mario";
        String password = "Alblue0303";
        return DriverManager.getConnection(url, user, password);
    }

    // Método para insertar un nuevo artista en la tabla "artists"
    public static void insertArtist(String artistName) {
        String sql = "INSERT INTO artists (name) VALUES (?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, artistName);
            pstmt.executeUpdate();
            System.out.println("Artista agregado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al agregar el artista: " + e.getMessage());
        }
    }

    // Método para insertar un nuevo álbum asociado a un artista en la tabla "albums"
    public static void insertAlbum(String albumName, int artistId) {
        String sql = "INSERT INTO albums (name, artist_id) VALUES (?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, albumName);
            pstmt.setInt(2, artistId);
            pstmt.executeUpdate();
            System.out.println("�?lbum agregado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al agregar el álbum: " + e.getMessage());
        }
    }

    // Método para eliminar un artista de la tabla "artists" y sus álbumes asociados en la tabla "albums"
    public static void deleteArtist(int artistId) {
        String deleteAlbumsSQL = "DELETE FROM albums WHERE artist_id = ?";
        String deleteArtistSQL = "DELETE FROM artists WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt1 = conn.prepareStatement(deleteAlbumsSQL);
             PreparedStatement pstmt2 = conn.prepareStatement(deleteArtistSQL)) {
            // Eliminar álbumes asociados al artista
            pstmt1.setInt(1, artistId);
            pstmt1.executeUpdate();

            // Eliminar al artista
            pstmt2.setInt(1, artistId);
            pstmt2.executeUpdate();
            System.out.println("Artista eliminado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar el artista: " + e.getMessage());
        }
    }

    // Método para actualizar el nombre de un álbum en la tabla "albums"
    public static void updateAlbum(int albumId, String newAlbumName) {
        String sql = "UPDATE albums SET name = ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newAlbumName);
            pstmt.setInt(2, albumId);
            pstmt.executeUpdate();
            System.out.println("�?lbum actualizado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al actualizar el álbum: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Ejemplo de uso de los métodos
        // Insertar un nuevo artista
        insertArtist("Nuevo Artista");

        // Obtener el ID del artista recién agregado (deberías implementar esto en tu aplicación)
        int artistId = 1; // ID del artista que acabas de agregar

        // Insertar un nuevo álbum asociado al artista
        insertAlbum("Nuevo �?lbum", artistId);

        // Eliminar el artista recién agregado
        deleteArtist(artistId);

        // Actualizar un álbum existente
        // Deberías obtener el ID del álbum que deseas actualizar y el nuevo nombre del álbum
        int albumId = 1; // ID del álbum que deseas actualizar
        String newAlbumName = "�?lbum Actualizado";
        updateAlbum(albumId, newAlbumName);
    }
}

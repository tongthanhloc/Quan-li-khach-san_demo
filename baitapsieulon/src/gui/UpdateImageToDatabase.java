package gui;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateImageToDatabase {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLKS", "sa", "sapassword")) {
            File imageFile = new File("anhNhanVien/NhanVien10.jpg"); // Thay thế đường dẫn với đường dẫn thực tế của hình ảnh
            byte[] imageData = readImageFromFile(imageFile);
            if (imageData != null) {
                updateImageInDatabase(connection, imageData);
                System.out.println("Image2 updated in database successfully.");
            } else {
                System.out.println("Failed to read image data.");
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    private static byte[] readImageFromFile(File file) throws IOException {
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] buffer = new byte[(int) file.length()];
            fis.read(buffer);
            return buffer;
        }
    }

    private static void updateImageInDatabase(Connection connection, byte[] imageData) throws SQLException {
        String sql = "UPDATE NhanVien SET anhDaiDien = ? WHERE maNhanVien = 'QL0000010'"; // Thay thế phần WHERE để xác định hàng bạn muốn cập nhật
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setBytes(1, imageData);
            statement.executeUpdate();
        }
    }
}

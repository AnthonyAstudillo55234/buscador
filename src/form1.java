import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class form1 {
    private JButton buscarBtn;
    public JPanel mainPanel;
    private JTextField buscar;
    private JButton buscarBtn2;
    private JLabel nombreEstu;
    private JLabel nota1;
    private JLabel nota2;
    private JLabel promedio;
    private JLabel sinSuple;
    private JLabel suple;
    private JLabel perdio;
    private JTextField buscar2;


    public form1() {
        buscarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://localhost:3306/clase";
                String user = "root";
                String password = "123456";
                try (Connection connection = DriverManager.getConnection(url,user,password)){
                    System.out.println("Conectando a la base de datos");
                    String cedula = buscar.getText();
                    String query = "select * from estudiantes where cedula = '" + cedula + "'";
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(query);
                    System.out.println();
                    System.out.println("Notas Estudiantes\n");
                    while(resultSet.next()){
                        System.out.println("\nCedula: " + resultSet.getString("cedula"));
                        System.out.println("Nombre Estudiante: " + resultSet.getString("nombre"));
                        nombreEstu.setText("Nombre Estudiante: " + resultSet.getString("nombre"));
                        System.out.println("Nota Bimestre Uno: " + resultSet.getString("b1"));
                        nota1.setText("Nota Bimestre Uno: " + resultSet.getString("b1"));
                        System.out.println("Nota Bimestre Dos: " + resultSet.getString("b2")+"\n");
                        nota2.setText("Nota Bimestre Dos: " + resultSet.getString("b2"));
                        float nota1 = resultSet.getFloat("b1");
                        float nota2 = resultSet.getFloat("b2");
                        float suma = nota1 + nota2;
                        System.out.println("Promedio: " + suma);
                        promedio.setText("Promedio: " + suma);
                        if (suma > 28){
                            System.out.println("El estudiante aprueba sin supletorio");
                            sinSuple.setText("Sin supletorio");
                        } else if (18 < suma && suma < 28) {
                            System.out.println("El estudiante entra supletorio y para pasar le hace falta: " + String.format("%.2f",40 - suma));
                            suple.setText("El estudiante entra supletorio y para pasar le hace falta: " + String.format("%.2f",40 - suma));
                        }else {
                            System.out.println("El estudiante reprueba sin supletorio para llegar al supletorio le falta: " + String.format("%.2f",18 - suma));
                            perdio.setText("El estudiante reprueba sin supletorio para llegar al supletorio le falta: " + String.format("%.2f",18 - suma));
                        }
                    }
                }
                catch (SQLException e1){
                    System.out.println(e1.getMessage());
                }
            }
        });
        buscarBtn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://localhost:3306/clase";
                String user = "root";
                String password = "123456";
                try (Connection connection = DriverManager.getConnection(url,user,password)){
                    System.out.println("Conectando a la base de datos");
                    String nombre = buscar2.getText();
                    String query = "select * from estudiantes where nombre = '" + nombre + "'";
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(query);
                    System.out.println();
                    System.out.println("Notas Estudiantes\n");
                    while(resultSet.next()){
                        System.out.println("\nCedula: " + resultSet.getString("cedula"));
                        System.out.println("Nombre Estudiante: " + resultSet.getString("nombre"));
                        nombreEstu.setText("Nombre Estudiante: " + resultSet.getString("nombre"));
                        System.out.println("Nota Bimestre Uno: " + resultSet.getString("b1"));
                        nota1.setText("Nota Bimestre Uno: " + resultSet.getString("b1"));
                        System.out.println("Nota Bimestre Dos: " + resultSet.getString("b2")+"\n");
                        nota2.setText("Nota Bimestre Dos: " + resultSet.getString("b2"));
                        float nota1 = resultSet.getFloat("b1");
                        float nota2 = resultSet.getFloat("b2");
                        float suma = nota1 + nota2;
                        System.out.println("Promedio: " + suma);
                        promedio.setText("Promedio: " + suma);
                        if (suma > 28){
                            System.out.println("El estudiante aprueba sin supletorio");
                            sinSuple.setText("Sin supletorio");
                        } else if (18 < suma && suma < 28) {
                            System.out.println("El estudiante entra supletorio y para pasar le hace falta: " + String.format("%.2f",40 - suma));
                            suple.setText("El estudiante entra supletorio y para pasar le hace falta: " + String.format("%.2f",40 - suma));
                        }else {
                            System.out.println("El estudiante reprueba sin supletorio para llegar al supletorio le falta: " + String.format("%.2f",18 - suma));
                            perdio.setText("El estudiante reprueba sin supletorio para llegar al supletorio le falta: " + String.format("%.2f",18 - suma));
                        }
                    }
                }
                catch (SQLException e1){
                    System.out.println(e1.getMessage());
                }
            }
        });
    }
}

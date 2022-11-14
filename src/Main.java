import java.io.*;
import java.util.Scanner;
import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) {
        try(FileInputStream in = new FileInputStream("src/input.txt");
            FileOutputStream out = new FileOutputStream("src/output.txt"))
        {
            byte[] buffer = new byte[in.available()];
            in.read(buffer, 0, buffer.length);
            StringBuilder input = new StringBuilder();
            for (byte x: buffer){
                input.append((char)x);
            }
            Scanner scanner = new Scanner(input.toString());
            int a = Integer.parseInt(scanner.next());
            int b = Integer.parseInt(scanner.next());
            System.out.println(a/b);
            String output = Integer.toString(a/b);
            buffer = new byte[1];
            for (int i = 0; i < output.length(); i++){
                buffer[i] = (byte)output.charAt(i);
            }
            out.write(buffer, 0, buffer.length);
        } catch (FileNotFoundException ex){
            System.out.println("There is no such file.");
        } catch (SecurityException ex){
            System.out.println("Access denied.");
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
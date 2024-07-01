package decoder;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;





public class Decoder {
    public static String decode(String message_file) {
    //stringBuilder to store decoded msg
        StringBuilder decodedMessage = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(message_file))) {
            String line;
            //var to track the expected next number
            int nextNumber = 1;
            //read lines of the file
            while ((line = reader.readLine()) != null) {
            //split line into parts words and numbers
                String[] parts = line.split(" ");
                int number = Integer.parseInt(parts[0]);
                //loop to check if the # matches next #
                if (number == nextNumber) {
                    decodedMessage.append(parts[1]).append(" ");
                    nextNumber++;
                }
            }
            //print error trace
        } catch (IOException e) {
            e.printStackTrace();
        }

        // return the msg as a string
        return decodedMessage.toString().trim();
    }
    public static void main(String[] args) {
        String message_file = "coding_qual_input.txt"; 
        //decode the msg and print
        String decodedMessage = decode(message_file);
        System.out.println("Decoded message: " + decodedMessage);
    }
}

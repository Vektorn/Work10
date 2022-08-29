package Task2;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String usersJson = getUsersJson();
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/Files/Task2.json"));
        writer.write(usersJson);
        writer.close();
    }

    private static String getUsersJson() throws IOException {
        FileReader fileReader2 = new FileReader("src/Files/Task2.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader2);

        String line = bufferedReader.readLine();
        String[] columns = line.split(" ");
        String json = "[";

        while (true) {
            line = bufferedReader.readLine();
            if (line == null)
                break;

            String[] userFields = line.split(" ");
            if (columns.length == userFields.length) {
                json += "\n{\n";
                for (int i = 0; i < columns.length; i++) {
                    json += "\"" + columns[i]+"\": ";

                    if (isNumeric(userFields[i]))
                        json += userFields[i];
                    else
                        json += "\"" + userFields[i] + "\"";

                    json += ",\n";
                }
                json = json.substring(0, json.length() - 2);
                json += "\n},";
            }
        }
        json = json.substring(0, json.length() - 1) ;
        json += "\n]";
        return json;
    }

    private static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}

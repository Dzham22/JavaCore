package LessonFive;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class AppData {

    public static final String Separator = ";";

    private String[] header;
    private Integer[][] data;

    public String[] getHeader() {
        return header;
    }

    public Integer[][] getData() {
        return data;
    }

    public void readTheFile(String a) {

        try (BufferedReader br = new BufferedReader(new FileReader(a))) {
            ArrayList<Integer[]> arraylist = new ArrayList<>();
            header = (br.readLine().split(Separator));
            String line;
            while ((line = br.readLine()) != null) {
                String[] strArr = line.split(Separator);
                Integer[] intArr = new Integer[strArr.length];
                for (int i = 0; i < strArr.length; i++) {
                    intArr[i] = Integer.parseInt(strArr[i]);
                }
                arraylist.add(intArr);
            }
            data = arraylist.toArray(new Integer[][]{});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToFile(String b) {
        try {BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(b), StandardCharsets.UTF_8));

            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < header.length; i++) {
                sb.append(header[i]);
                sb.append(Separator);
            }
            bw.write(sb.toString());
            bw.newLine();

            for (int i = 0; i < data.length; i++) {
                Integer[] rowData = data[i];
                sb.delete(0, sb.length());
                for (int j = 0; j < rowData.length; j++) {
                    sb.append(rowData[j]);
                    sb.append(Separator);
                }
                bw.write(sb.toString());
                bw.newLine();
            }

            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
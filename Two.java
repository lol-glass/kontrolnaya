import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Two {
    private static final String IN_FILE_TXT = "src\\inFile.txt";

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите размер окна");
        int window = sc.nextInt();
        String st = reader();
        Double[] array = arr(st, window);
        double mov = moving(window, array);
        double media = median(array);
        System.out.println("Простое скользящее среднее:" + mov);
        System.out.println("Медианный фильтр:" + media);
    }

    //считает среднее
    public static Double moving(int window, Double[] arr){
        double simpleMovingAverage = 0;
        for (Double array : arr){
            simpleMovingAverage+=array;
        }
        simpleMovingAverage = simpleMovingAverage/window;
        return simpleMovingAverage;
    }
    //чтение из файла
    public static String reader() throws IOException {
        String st;
        BufferedReader reader = new BufferedReader(new FileReader(IN_FILE_TXT));
        st = reader.readLine();
        reader.close();
        return st;
    }
    //Происходит запись строки как массива
    public static Double[] arr(String st, int window){
        String[] words = st.split(", ");
        String[] mini = new String[window];
        System.arraycopy(words, 0, mini, 0, window);
        Double[] array = Stream.of(mini).mapToDouble(Double::parseDouble).boxed().toArray(Double[]::new);
        return array;
    }
    //медианный фильтр
    public static double median(Double[] array) {
        Arrays.sort(array);
        double media = 0;
         array[0] = 0.0;
         array[array.length-1] = 0.0;
         for (Double aDouble : array) {
         media = media + aDouble;
         }
         return media/array.length;
    }


}

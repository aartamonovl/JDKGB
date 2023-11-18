package homework6;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        Random rnd = new Random();
        Map<Integer, Boolean> result = new HashMap<>();
        int maxSteps = 1000;
        String file2result = "result.json";

        // реализация первого варианта
        for (int i = 0; i < maxSteps; i++) {
            boolean[] boxes = getBoxes();
            int selectedBox = rnd.nextInt(3);
            result.put(i, boxes[selectedBox]);
        }

        printResult(maxSteps, result, 1);
        System.out.println();

        // реализация второго врианта
        for (int i = 0; i < maxSteps; i++) {
            boolean[] boxes = getBoxes();
            int selectedBox = rnd.nextInt(3);
            selectedBox = getSecondBox(selectedBox, boxes);
            result.put(i + maxSteps, boxes[selectedBox]);
        }

        printResult(maxSteps, result, 2);

        Map2JSONFile.toJsonFile(result,file2result);
    }
    private static void printResult(int maxSteps, Map<Integer, Boolean> result, int step) {
        int win = 0;
        int fail = 0;
        for (int i = maxSteps*(step-1); i < maxSteps*(step); i++) {
            if (result.get(i)) {
                win++;
            } else {
                fail++;
            }
        }
        System.out.printf("Варинт %d\n",step);
        System.out.printf("Выигрышей:\t%d\nПроигрышей:\t%d\n", win, fail);
        System.out.printf("при %d итераций: %2.2f%%\n",maxSteps,((float)win/(win+fail)*100));
    }

    /**
     * Возвращает индекс шкатулки, которую предлагает открыть ведущий
     *
     * @param userSelectedBox
     * @param boxes
     * @return
     */
    private static int getSecondBox(int userSelectedBox, boolean[] boxes) {
        Random rnd = new Random();
        int selectSecondBox;
        if (boxes[userSelectedBox]) {
            // начальный выбор игрока был правильный
            while (true) {
                //предлагаем любую из оставшихся шкатулок
                selectSecondBox = rnd.nextInt(3);
                if (selectSecondBox != userSelectedBox) return selectSecondBox;
            }
        } else {
            //если начальный выбор был проигрышный,
            // то предлагаем шкатулку с призом
            while (true) {
                for (int i = 0; i < 3; i++) {
                    if (boxes[i]) return i;
                }
            }
        }
    }

    /**
     * Возвращает массив шкатулок, в одной из которого приз
     *
     * @return
     */
    private static boolean[] getBoxes() {

        Random rnd = new Random();
        boolean[] boxes = new boolean[]{false, false, false};
        boxes[rnd.nextInt(3)] = true;
        return boxes;
    }
    public class Map2JSONFile {
        public static<K,V> void toJsonFile(Map<K,V> map, String filename){
            Gson gson = new Gson();
            String data2file = gson.toJsonTree(map).toString();
            try (FileWriter fw = new FileWriter(filename)){
                fw.write(data2file);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

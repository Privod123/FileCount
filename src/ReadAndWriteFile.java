import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class ReadAndWriteFile {

    private String nameFile = "resultat.txt";
    private String pathSaveFile ="src\\Resultat\\";

    public void writeFile(Map<String,Integer> countFileMap,String nameFolder){
        try(FileWriter writer = new FileWriter(pathSaveFile + nameFile, false))
        {
            writer.write("В папке - " + nameFolder + " содержиться :");
            writer.append('\n');
            for (Map.Entry<String,Integer> countFile: countFileMap.entrySet()) {
                String key = countFile.getKey();
                int value = countFile.getValue();
                String prefix = "";
                if (!"Папок".equalsIgnoreCase(key)){
                    prefix = "Файлов с расщирением ";
                }
                writer.write(prefix + key + " - " + value + " шт.");
                writer.append('\n');
                writer.flush();
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        System.out.println("Расчет статистики закончен.");
    }

}

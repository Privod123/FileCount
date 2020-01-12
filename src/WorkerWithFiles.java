import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class WorkerWithFiles {

    private String pathNameFolder;
    private Map<String,Integer> countFileMap = new HashMap<>();

    public void setNameFolder(String pathNameFolder) {
        this.pathNameFolder = pathNameFolder;
    }

    public void setNameFolder() {
        try(Scanner scanner = new Scanner(System.in);) {
            System.out.println("Укажите путь до папки в которой необхдимо сделать статистику");
            pathNameFolder = scanner.nextLine();
        }
    }

    public String getNameFolder() {
        File fileFolder = new File(pathNameFolder);
        return fileFolder.getName();
    }

    public String getPathNameFolder() {
        return pathNameFolder;
    }

    public Map<String, Integer> getCountFileMap() {
        return countFileMap;
    }

    public void printConsolCountFileMap(){
        System.out.println("-------------------------");
        for (Map.Entry<String,Integer> countFile: countFileMap.entrySet()) {
            String key = countFile.getKey();
            int value = countFile.getValue();
            System.out.println(key + " - " + value);
        }
    }

    public void checkerFolder(String nameFolder){
        File file = new File(nameFolder);
        if (!file.exists()){
            System.out.println("По указанному пути файл или каталог не существует.");
        }else {
            File[] fileList = file.listFiles();
            for (int i = 0; i < fileList.length; i++) {
                if (fileList[i].isDirectory()){
                    try {
                        int countFolder = countFileMap.get("Папок");
                        countFileMap.put("Папок",++countFolder);
                        checkerFolder(fileList[i].getAbsolutePath());
                    } catch (Exception e) {
                        countFileMap.put("Папок",1);
                        checkerFolder(fileList[i].getAbsolutePath());
                    }
                }
                if (fileList[i].isFile()){
                    String nameFile = fileList[i].getName();
                    String[] splitNameFile = nameFile.split("\\.");
                    String typeFile = splitNameFile[1];
                    try {
                        int countFoundType = countFileMap.get(typeFile);
                        countFileMap.put(typeFile,++countFoundType);
                    } catch (Exception e) {
                        countFileMap.put(typeFile,1);
                    }

                }
            }
        }
    }

}

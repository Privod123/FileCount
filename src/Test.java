public class Test {
    public static void main(String[] args) {
       WorkerWithFiles worker = new WorkerWithFiles();
       ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();

       worker.setNameFolder();
       worker.checkerFolder(worker.getPathNameFolder());

       readAndWriteFile.writeFile(worker.getCountFileMap(),worker.getNameFolder());
    }
}

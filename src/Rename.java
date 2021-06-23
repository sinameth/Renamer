import java.io.File;
import java.nio.file.Files;

public class Rename {
    public static final String DIR = "./Rename";

    public static void main(String[] args) {
        File dir = new File(DIR);
        File[] files = dir.listFiles();
        //seperateGetByPos(files, "_", 3);
        //seperateGetByPos(files, "\\.", 1);
        //seperateRemByPos(files,"-", 2);
        addType(files,".png");

    }

    public static void seperateGetByPos(File[] files, String c, int pos) {
        String ap;
        String[] seperated = new String[0];

        for (File file : files) {
            if(!file.getName().equals(".DS_Store")) {
                ap = file.getName();
                seperated = ap.split(String.valueOf(c));

                File newFile = new File(""+DIR+"/"+seperated[pos-1]);
                file.renameTo(newFile);
            }
        }
    }
    public static void seperateRemByPos(File[] files, String c, int pos) {
        String ap;
        String[] seperated = new String[0];

        for (File file : files) {
            if(!file.getName().equals(".DS_Store")) {
                ap = file.getName();
                seperated = ap.split(String.valueOf(c));

                String filename=""+DIR+"/";
                for (int i = 0; i < seperated.length; i++) {
                    if(i!=(pos-1)) {
                        filename+=seperated[i];
                    }
                }
                File newFile = new File(filename);
                file.renameTo(newFile);
            }
        }
    }
    public static void addType(File[] files, String type) {
        String ap;

        for (File file : files) {
            if(!file.getName().equals(".DS_Store")) {
                ap = file.getName();

                File newFile = new File(""+DIR+"/"+ap+""+type);
                file.renameTo(newFile);
            }
        }
    }
}

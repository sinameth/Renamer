import java.io.File;
import java.nio.file.Files;
import java.util.Locale;

public class Rename {
    public static final String DIR = "./Rename";

    public static void main(String[] args) {
        File dir = new File(DIR);
        File[] files = dir.listFiles();

        //toUpperCase(files);
        //removeType(files);
        //toPNG(files);


        //seperateGetByPos(files, "_", 3);
        //seperateRemByPos(files,"-", 2);
    }

    public static void seperateGetByPos(File[] files, String regex, int pos) {
        String fileName, newName;
        String[] sepName = new String[0];

        for (File file : files) {
            if (!file.getName().equals(".DS_Store")) {
                fileName = file.getName();
                sepName = fileName.split(regex);

                newName = "" + DIR + "/" + sepName[pos - 1];
                File newFile = new File(newName);
                file.renameTo(newFile);
            }
        }
    }

    public static void seperateRemByPos(File[] files, String regex, int pos) {
        String fileName, newName;
        String[] sepName = new String[0];

        for (File file : files) {
            if (!file.getName().equals(".DS_Store")) {
                fileName = file.getName();
                sepName = fileName.split(regex);

                newName = "" + DIR + "/";
                for (int i = 0; i < sepName.length; i++) {
                    if (i != (pos - 1)) {
                        newName += sepName[i];
                    }
                }

                File newFile = new File(newName);
                file.renameTo(newFile);
            }
        }
    }

    public static void addType(File[] files, String type) {
        String fileName, newName;

        for (File file : files) {
            if (!file.getName().equals(".DS_Store")) {
                fileName = file.getName();
                newName = "" + DIR + "/" + fileName + "" + type;

                File newFile = new File(newName);
                file.renameTo(newFile);
            }
        }
    }

    public static void toUpperCase(File[] files) {
        String fileName, newName;


        for (File file : files) {
            if (!file.getName().equals(".DS_Store")) {
                fileName = file.getName();
                newName = "" + DIR + "/" + fileName.toUpperCase();

                File newFile = new File(newName);
                file.renameTo(newFile);
            }
        }
    }

    public static void removeType(File[] files) {
        seperateGetByPos(files, "\\.", 1);
    }

    public static void toPNG(File[] files) {
        addType(files, ".png");
    }
}

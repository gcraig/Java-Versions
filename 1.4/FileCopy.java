
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.nio.channels.FileChannel;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class FileCopy {

    // Java 4 NIO
    public void fileCopyNIO() throws Exception {

        long start = System.currentTimeMillis();

        File source = new File("source.dat");
        File target = new File("target.dat");

        // Getting file channels
        FileChannel in = new FileInputStream(source).getChannel();
        FileChannel out = new FileOutputStream(target).getChannel();

        // JavaVM does its best to do this as native I/O operations.
        in.transferTo(0, in.size(), out);

        // Closing file channels will close corresponding stream objects as well.
        out.close();
        in.close();

        long stop = System.currentTimeMillis();
        System.err.println("total time: " + (stop - start) + "ms");

    }

    // since Java 4 - 1 full second
    public void fileCopyBuffer() throws Exception {

        long start = System.currentTimeMillis();

        BufferedReader fr = new BufferedReader(new FileReader(new File("source.dat")));
        BufferedWriter fw = new BufferedWriter(new FileWriter(new File("target.dat")));

        char[] buf = new char[1_024_000];
        int len;
        while ((len = fr.read(buf)) > 0) {
            fw.write(buf, 0, len);
        }
        fr.close();
        fw.close();

        long stop = System.currentTimeMillis();
        System.err.println("total time: " + (stop - start) + "ms");

    }

    // Java 7
    public void copyFile() throws IOException {

        long start = System.currentTimeMillis();

        File source = new File("source.dat");
        File target = new File("target.dat");

        if (!source.exists()) {
            source.createNewFile();
        }

        try (
                FileChannel in = new FileInputStream(source).getChannel();
                FileChannel out = new FileOutputStream(target).getChannel()) {

            out.transferFrom(in, 0, in.size());
        }
        
        long stop = System.currentTimeMillis();
        System.err.println("total time: " + (stop - start) + "ms");
        
    }

    // Java 7 - just as fast as NIO from 1.4, 65 ms
    public void copyFileFiles() throws IOException {
        
        long start = System.currentTimeMillis();
        
        File source = new File("source.dat");
        File target = new File("target.dat");

        Files.delete(target.toPath());
        Files.copy(source.toPath(), target.toPath());

        long stop = System.currentTimeMillis();
        System.err.println("total time: " + (stop - start) + "ms");

    }

    public static void main(String[] args) throws Exception {
        
        new FileCopy().copyFile();
                
    }
}

package top.codewood.wx.common.util.file;

import java.io.*;
import java.nio.file.Files;

public class FileUtils {

    /**
     *
     * @param inputStream 输入文件流
     * @param name  文件名
     * @param ext   扩展名
     * @param tmpDirFile 临时文件夹目录
     * @return
     * @throws IOException
     */
    public static File createTmpFile(InputStream inputStream, String name, String ext, File tmpDirFile) throws IOException {
        File file = File.createTempFile(name, "." + ext, tmpDirFile);
        file.deleteOnExit();
        copyToFile(inputStream, file);
        return file;
    }

    /**
     *
     * @param inputStream 输入文件流
     * @param name  文件名
     * @param ext   扩展名
     * @return
     * @throws IOException
     */
    public static File createTmpFile(InputStream inputStream, String name, String ext) throws IOException {
        return createTmpFile(inputStream, name, ext, Files.createTempDirectory("wx-java-tools-temp").toFile());
    }

    private static void copyToFile( InputStream source, File destination) throws IOException {
        try (InputStream in = source; OutputStream out = new FileOutputStream(destination)) {
            copy(in, out);
        }
    }

    public static long copy(InputStream input, OutputStream output) throws IOException {
        long count = 0;
        int n;
        byte[] buffer = new byte[1024 * 4];
        while ((n = input.read(buffer)) != -1) {
            output.write(buffer, 0, n);
            count += n;
        }
        return count;
    }

}

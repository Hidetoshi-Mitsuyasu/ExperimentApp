package com.example.hmitsuyasu.myapplication.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by hmitsuyasu on 2019/03/20.
 */
public class FileUtils {

    /**
     * Read file string. Assetの代わりにresources/のファイルを読み込む。
     *
     * @param path the path
     * @return the string
     * @throws IOException the io exception
     */
    public static String readFile(String path) throws IOException {
        InputStreamReader isr = null;
        BufferedReader reader = null;

        String result = "";
        InputStream is = ClassLoader.getSystemResourceAsStream(path);
        try {
            isr = new InputStreamReader(is);
            reader = new BufferedReader(isr);
        } catch (NullPointerException e) {
            e.printStackTrace();
            throw e;
        }
        String data;
        StringBuilder buf = new StringBuilder();
        try {
            while ((data = reader.readLine()) != null) {
                buf.append(data);
            }
        } catch (IOException mE) {
            mE.printStackTrace();
            throw mE;
        }
        result = buf.toString();
        return result;
    }
}

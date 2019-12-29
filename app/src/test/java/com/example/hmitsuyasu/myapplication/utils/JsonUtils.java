package com.example.hmitsuyasu.myapplication.utils;

import android.support.annotation.Nullable;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;

/**
 * Created by hmitsuyasu on 2019/03/20.
 */
public class JsonUtils {

    /**
     * Get json array string [ ].
     *
     * @param path the path 拡張子含む
     * @return the string [ ]
     */
    @Nullable
    public static String[] getJsonArray(String path) {
        String[] result = null;
        String record;
        try {
            record = FileUtils.readFile(path);
        } catch (IOException | NullPointerException mE) {
            mE.printStackTrace();
            return null;
        }
        Gson gson = new Gson();

        try {
            result = gson.fromJson(record, String[].class);
        } catch (JsonSyntaxException e) {
            return null;
        }
        return result;
    }
}

package com.haanhgs.app.viewmodellivedata1;

import android.content.Context;
import com.haanhgs.app.viewmodellivedata1.model.Score;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Repo {
    public static void save(Context context, Score score){
        try{
            FileOutputStream out = context.openFileOutput("save.txt", Context.MODE_PRIVATE);
            ObjectOutputStream outputStream = new ObjectOutputStream(out);
            outputStream.writeObject(score);
            outputStream.flush();
            outputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Score load(Context context){
        Score score = new Score();
        File file = new File(context.getFilesDir(), "save.txt");
        if (file.exists()){
            try{
                FileInputStream in = context.openFileInput("save.txt");
                ObjectInputStream inputStream = new ObjectInputStream(in);
                Object object = inputStream.readObject();
                score = (Score)object;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return score;
    }
}

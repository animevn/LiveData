package com.haanhgs.app.livedata.model;

import android.content.Context;
import android.util.Log;
import org.json.*;
import java.io.*;

public class Helper {

    //save and load file using json conversion//
    ////////////////////////////////
    private static Score jsonToScore(JSONObject jsonObject)throws JSONException{
        return new Score(jsonObject.getInt("a"), jsonObject.getInt("b"));
    }

    private static JSONObject scoreToJson(Score score)throws JSONException{
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("a", score.getScoreA());
        jsonObject.put("b", score.getScoreB());
        return jsonObject;
    }

    public static void save(Context context, Score score){
        Writer writer = null;
        try {
            JSONObject jsonObject = scoreToJson(score);
            OutputStream out = context.openFileOutput("save", Context.MODE_PRIVATE);
            writer = new OutputStreamWriter(out);
            writer.write(jsonObject.toString());
        }catch (JSONException e){
            Log.e("json", e.toString());
        }catch (IOException e){
            Log.e("ioe", e.toString());
        }finally {
            try{
                if (writer != null) writer.close();
            }catch (IOException e){
                Log.e("ioe", e.toString());
            }
        }
    }

    public static Score load(Context context){
        Score score = new Score();
        BufferedReader reader = null;
        File file = new File(context.getFilesDir(), "save");
        if (file.exists()){
            try{
                InputStream in = context.openFileInput("save");
                reader = new BufferedReader(new InputStreamReader(in));
                StringBuilder builder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) builder.append(line);
                JSONObject json = (JSONObject) new JSONTokener(builder.toString()).nextValue();
                score = jsonToScore(json);
            }catch (JSONException e){
                Log.e("json", e.toString());
            }catch (IOException e){
                Log.e("ioe", e.toString());
            }finally {
                try{
                    if (reader != null) reader.close();
                }catch (IOException e){
                    Log.e("ioe", e.toString());
                }
            }
        }
        return score;
    }

    //save and load file using serializable//
    /////////////////////////////////////////
    public static void saveSerializable(Context context, Score score){
        try{
            FileOutputStream out = context.openFileOutput("save", Context.MODE_PRIVATE);
            ObjectOutputStream outputStream = new ObjectOutputStream(out);
            outputStream.writeObject(score);
            outputStream.flush();
            outputStream.close();
        }catch (IOException e){
            Log.e("ioe", e.toString());
        }
    }

    public static Score loadSerializable(Context context){
        Score score = new Score();
        File file = new File(context.getFilesDir(), "save");
        if (file.exists()){
            try{
                FileInputStream in = context.openFileInput("save");
                ObjectInputStream inputStream = new ObjectInputStream(in);
                Object object = inputStream.readObject();
                score = (Score) object;
            }catch (IOException e){
                Log.e("ioe", e.toString());
            }catch (ClassNotFoundException e){
                Log.e("class not found", e.toString());
            }
        }
        return score;
    }

}

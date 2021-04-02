package Client.ServerHandler;

import Client.Model.ErrorMsg;
import Client.Model.OverErrorMsg;
import com.google.gson.Gson;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2021-April-02
 */

public class Util {
    private static OkHttpClient client = new OkHttpClient();
    private static Call call;
    private static Gson gson = new Gson();

    public static Response executeServerRequest(Request request){
        try {
            call = client.newCall(request);
            return call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ErrorMsg extractOneErrorMsg(String responseString){
        return gson.fromJson(responseString, ErrorMsg.class);
    }

    public static OverErrorMsg extractMulErrorMsg(String responseString){
        OverErrorMsg errorMsg = gson.fromJson(responseString, OverErrorMsg.class);

        return errorMsg;
    }
}

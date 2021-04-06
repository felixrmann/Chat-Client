package Client.Main;

import Client.DataHandler.UserLoader;
import Client.Model.Chat;
import Client.Model.Message;
import Client.Model.User;
import Client.ServerHandler.ChatService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Vector;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2021-Februar-27
 */

public class RunClient {

    public static void main(String[] args) throws IOException {

        try {
            UserLoader userLoader = new UserLoader();

            String jsonString = ChatService.loadChats(userLoader.loadUser().getuserToken()).body().string();
            JSONObject jsonObject = new JSONObject(jsonString);
            System.out.println(jsonString);
            JSONArray array = jsonObject.getJSONArray("chats");

            Vector<Chat> chats = new Vector<>();

            for (int i = 0; i < array.length(); i++) {
                JSONObject chatObj = array.getJSONObject(i);
                JSONObject messageObj = array.getJSONObject(i).getJSONObject("message");
                User author = null;
                if (messageObj.has("author")) {
                    JSONObject authorObj = messageObj.getJSONObject("author");
                    author = new User(authorObj.getString("id"), authorObj.getString("username"), authorObj.getString("avatar"));
                }
                Message lastMessage = new Message(messageObj.optString("id"), messageObj.optString("content"), messageObj.optString("date"), author);
                chats.add(new Chat(chatObj.optString("id"), chatObj.optString("name"), chatObj.optInt("type"), chatObj.optString("imagePath"), lastMessage));
            }


            for (Chat chat : chats) {
                System.out.println(chat.getChatName());
                System.out.println(chat.getLastMessage().getMessageContent());
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        System.exit(0);

        /*
        UserLoader userLoader = new UserLoader();
        Response response = ChatService.loadChats(userLoader.loadUser().getuserToken());
        String respo = response.body().string();
        System.out.println(respo);

        Gson gson = new Gson();
        LoadChat loadChat = gson.fromJson(respo, LoadChat.class);
        System.out.println(loadChat.toString());

        System.exit(0);

         */



        /*
        [
          {
           "status": "available",
           "managed": true,
           "name": "va_85621143-1133-412f-83b4-57a01a552638_",
           "support": {
            "status": "supported"
           },
          },
          {
           "status": "in-use",
           "managed": false,
           "name": "bt_newd20",
           "support": {
            "status": "not_supported",
            "reasons": [
             "This volume is not a candidate for management because it is already attached to a virtual machine.  To manage this volume with PowerVC, select the virtual machine to which the volume is attached for management. The attached volume will be automatically included for management."
             }
            ]
         */



        /*
        FormBody data = new FormBody.Builder()
                .add("username", "felix")
                .add("password", "12345678")
                .build();

        Request request = new Request.Builder()
                .url("https://chat.mahler.link/api/v1/users/login")
                .post(data)
                .build();

        Request request1 = new Request.Builder()
                .url("https://chat.mahler.link/api/v1/chats")
                .header("Authorization", "")
                .build();

        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        Response response = call.execute();

        System.out.println("Code: " + response.code());

        String responseString = response.body().string();
        System.out.println(responseString);

        Gson gson = new Gson();
        Token token = gson.fromJson(responseString, Token.class);
        token.printToken();

         */



        /*
        System.out.println(Util.extractErrorMsg(responseString).getErrorMsg());

        System.exit(0);

         */



        /*
        JsonElement jsonElement = new JsonParser().parse(responseString);
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        JSONObject jsonObject1 = new Gson().fromJson(responseString, JSONObject.class);

         */

        /*
        String token = jsonObject.get("token").getAsString();
        System.out.println(token);

         */

        /*
        System.out.println(jsonObject.toString());

        System.out.println(jsonObject1.toString());
        try {
            System.out.println(jsonObject1.get("token"));
            jsonObject1.getString("token");
        } catch (JSONException e) {
            e.printStackTrace();
        }

         */


        /*
        Request covidApiTest = new Request.Builder()
                .url("https://chat.mahler.link/api/v1/chats")
                .build();
        OkHttpClient httpClient1 = new OkHttpClient();
        try (Response response = httpClient1.newCall(covidApiTest).execute()){
            JSONObject jsonObject = new JSONObject(Objects.requireNonNull(response.body()).string());
            System.out.println(jsonObject.getJSONArray("errors").getJSONObject(0).get("msg"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        System.exit(0);

         */

        /*
        try {
            socket = new Socket("localhost", 5005);
        } catch (IOException ex){
            System.out.println("Server not found");
            System.exit(0);
        }
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        printWriter.println("Hello World");
        printWriter.flush();

        InputStreamReader in = new InputStreamReader(socket.getInputStream());
        BufferedReader bf = new BufferedReader(in);

        String str = bf.readLine();
        System.out.println("server : " + str);

         */
    }
    class Token {
        private String token;

        public Token(String token){
            this.token = token;
        }

        public void printToken() {
            System.out.println("Token:" + token);
        }
    }
}

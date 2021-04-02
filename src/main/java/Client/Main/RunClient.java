package Client.Main;

import java.io.IOException;

/**
 * @author Felix Mann
 * @version 1.0
 * @since 2021-Februar-27
 */

public class RunClient {

    public static void main(String[] args) throws IOException {

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

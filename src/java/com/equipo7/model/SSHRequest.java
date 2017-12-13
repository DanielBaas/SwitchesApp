import com.equipo7.model.SwitchCisco;
import java.io.*;

import com.jcraft.jsch.*;

public class SSHRequest {

    public void switchCommand(String command, String switchFile, SwitchCisco switchCisco) {

        String user = switchCisco.getUser();
        String host = switchCisco.getHost();
        int port = switchCisco.getPort();
        String pass = switchCisco.getPass();
        String switchCommand = command;
        JSch jsch = new JSch();

        try {
            Session session = jsch.getSession(user, host, port);
            UserInfo ui = new SUserInfo(pass, null);

            session.setUserInfo(ui);
            session.setPassword(pass);
            session.connect();

            ChannelExec channelExec = (ChannelExec)session.openChannel("exec");
            InputStream in = channelExec.getInputStream();

            channelExec.setCommand(switchCommand);
            channelExec.connect();

            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String linea = null;
            PrintWriter fileOut = new PrintWriter(switchFile);

            while ((linea = reader.readLine()) != null) {
                fileOut.println(linea);
                channelExec.disconnect();
                session.disconnect();
            }

            fileOut.close();
        } catch (JSchException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void pingCommand(String ip, String switchFile) {

    }

}

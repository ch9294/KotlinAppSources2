import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket server = new ServerSocket(55555);
			System.out.println("사용자 접속 대기");
			Socket socket = server.accept();
			
			InputStream input = socket.getInputStream();
			DataInputStream dis = new DataInputStream(input);
			
			OutputStream output = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(output);
			
			dos.writeInt(100);
			dos.writeDouble(11.11);
			dos.writeUTF("서버가 보낸 문자열");
			
			int data1 = dis.readInt();
			double data2 = dis.readDouble();
			String data3 = dis.readUTF();
			
			socket.close();
			server.close();
			
			System.out.printf("data1 : %d\n", data1);
			System.out.printf("data2 : %f\n", data2);
			System.out.printf("data3 : %s\n", data3);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}









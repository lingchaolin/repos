package httpServer.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MyProtol {
/**d
 * httpЭ��
 * ����ʽ
 * 
 * 		get
 * 		post
 * ����ͷ
 * 
 * ��������(post)-����
 * 
 * Http��Ӧ��ʽ
 * 		httpЭ��汾��״̬���롢����
 * 		��Ӧͷ(Response Head)
 * 		��Ӧ����(Response Content)
 */
/**http��Ӧ����
 * 	Ӧ����-״̬��
 * 200-ok
 * 400-Bad Request
 * 404 Not Found
 * 405 Method Not Allowed
 * 500 ������������ɶ�����Ĵ���
 */

/**��Ӧͷ
 * ��������
 * Content-type:text/html:charset=GBK
 * Content-type:text/plain:charset=GBK
 * content-type:application/octet-stream
 * ���ĵĳ���
 */
		public static void main(String[] args) {
			Server server = new Server();
			server.start();
		}
}

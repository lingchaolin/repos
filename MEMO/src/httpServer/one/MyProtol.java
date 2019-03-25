package httpServer.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MyProtol {
/**d
 * http协议
 * 请求方式
 * 
 * 		get
 * 		post
 * 请求头
 * 
 * 请求正文(post)-换行
 * 
 * Http响应格式
 * 		http协议版本、状态代码、描述
 * 		响应头(Response Head)
 * 		响应正文(Response Content)
 */
/**http响应分析
 * 	应答码-状态码
 * 200-ok
 * 400-Bad Request
 * 404 Not Found
 * 405 Method Not Allowed
 * 500 服务器不能完成对请求的处理
 */

/**响应头
 * 流的类型
 * Content-type:text/html:charset=GBK
 * Content-type:text/plain:charset=GBK
 * content-type:application/octet-stream
 * 正文的长度
 */
		public static void main(String[] args) {
			Server server = new Server();
			server.start();
		}
}

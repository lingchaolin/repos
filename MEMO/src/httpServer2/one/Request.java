package httpServer2.one;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Request {
//封装Request
	//请求方式-post/get
	private String method;
	//请求资源
	private String url;
	//请求参数-键值对-可能存在一个键对应多个值
	private Map<String,List<String>> parameterMapValues;
	//内部
	public static final String CRLF="\r\n";
	private InputStream is;
	private String requestInfo;
	public Request() {//避免空指针异常
		method="";
		url="";
		parameterMapValues=new HashMap<String,List<String>>();
		requestInfo="";
	}

	
}

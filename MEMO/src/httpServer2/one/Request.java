package httpServer2.one;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Request {
//��װRequest
	//����ʽ-post/get
	private String method;
	//������Դ
	private String url;
	//�������-��ֵ��-���ܴ���һ������Ӧ���ֵ
	private Map<String,List<String>> parameterMapValues;
	//�ڲ�
	public static final String CRLF="\r\n";
	private InputStream is;
	private String requestInfo;
	public Request() {//�����ָ���쳣
		method="";
		url="";
		parameterMapValues=new HashMap<String,List<String>>();
		requestInfo="";
	}

	
}

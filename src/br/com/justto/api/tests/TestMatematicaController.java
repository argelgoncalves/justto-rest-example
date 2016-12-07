package br.com.justto.api.tests;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import junit.framework.TestCase;

public class TestMatematicaController extends TestCase{
	
	public void testSoma(){
		
		StringEntity requestEntity = new StringEntity(
				"{\"A\": 30.50, \"B\": 5.12}",
			    ContentType.APPLICATION_JSON);

			HttpPost postMethod = new HttpPost("http://localhost:8080/justto/soma");
			postMethod.setEntity(requestEntity);
			
			HttpClient httpClient = new DefaultHttpClient();
			HttpResponse rawResponse;
			try {
				rawResponse = httpClient.execute(postMethod);
				HttpEntity entity = rawResponse.getEntity();
				String entityContents = EntityUtils.toString(entity);
		        assertEquals("{\"RESULTADO\":35.62}", entityContents);
			} catch (ClientProtocolException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}  		
	}
}

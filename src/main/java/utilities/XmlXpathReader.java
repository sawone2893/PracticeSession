package utilities;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class XmlXpathReader {
	
	private static XmlXpathReader xmlXpathRead;
	private static File xmlFile;
	private static DocumentBuilderFactory factory;
	private static DocumentBuilder builder;
	private static Document doc;
	private static NodeList nList;
	private static Node nNode;
	private static Element ele;
	
	
	private XmlXpathReader(String xpathXmlName){

		try{
			xmlFile = new File(System.getProperty("user.dir") +"/src/main/java/resource/"+xpathXmlName+".xml");
		    factory=DocumentBuilderFactory.newInstance();
		    builder=factory.newDocumentBuilder();
		    doc=builder.parse(xmlFile);
		    }catch(Exception e){
		        e.printStackTrace();
		    }

	}
	
	public static XmlXpathReader getInstanceXmlXpathReader(String xpathXmlName){
		
		if(xmlXpathRead==null){
			xmlXpathRead=new XmlXpathReader(xpathXmlName);
		}
		return xmlXpathRead;
	}
	
	public String getProperty(String xpathName){
		doc.getDocumentElement();
		  nList=doc.getElementsByTagName("dish");
		    //System.out.println("The length is: "+nList.getLength());
		  String value=null;
		    for(int i=0; i<nList.getLength(); i++){
		        nNode=nList.item(i);
		          ele=(Element) nNode;
		          
		          if(ele.getElementsByTagName("key").item(0).getNodeValue().equals(xpathName)){
		        	  value= ele.getElementsByTagName("value").item(0).getNodeValue();
		        	  break;
		          }
 
		    }
		    
		    return value;
		
	}
	public static void main(String args[]){
		
		XmlXpathReader xpathValue=XmlXpathReader.getInstanceXmlXpathReader("xpaths");
		
		System.out.println(xpathValue.getProperty("1027"));
		
		
	}

}

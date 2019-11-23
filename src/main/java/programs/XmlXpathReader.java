package programs;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class XmlXpathReader {
	
	public File xmlFile;
	DocumentBuilderFactory factory;
	DocumentBuilder builder;
	Document doc;
	NodeList nList;
	Node nNode;
	Element ele;
	
	
	public XmlXpathReader(String xpathXmlName){

		try{
			xmlFile = new File(System.getProperty("user.dir") +"/src/main/java/programs/"+xpathXmlName+".xml");
		    factory=DocumentBuilderFactory.newInstance();
		    builder=factory.newDocumentBuilder();
		    doc=builder.parse(xmlFile);
		    }catch(Exception e){
		        e.printStackTrace();
		    }

	}
	
	
	public String getvalue(String xpathName){
		doc.getDocumentElement();
		  nList=doc.getElementsByTagName("dish");
		    //System.out.println("The length is: "+nList.getLength());
		  String value=null;
		    for(int i=0; i<nList.getLength(); i++){
		        nNode=nList.item(i);
		          ele=(Element) nNode;
		          
		          if(ele.getElementsByTagName("key").item(0).getTextContent().equals(xpathName)){
		        	  value= ele.getElementsByTagName("value").item(0).getTextContent();
		        	  break;
		          }
 
		    }
		    
		    return value;
		
	}
	public static void main(String args[]){
		
		XmlXpathReader xpathValue=new XmlXpathReader("xpaths");
		
		System.out.println(xpathValue.getvalue("1027"));
		
		
	}

}

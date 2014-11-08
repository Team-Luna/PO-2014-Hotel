package main;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author K O M P U T E R
 */
public class ConfigReader {

    File fXmlFile;
    Document doc;

    public ConfigReader() {
        try {
            fXmlFile = new File("src/user.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(ConfigReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(ConfigReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConfigReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public double getPriceForDay(int roomSize, Calendar day) {
        return getRoomCost(roomSize)*getSeasonMulti(day);
    }

    private int getRoomCost(int roomSize) {
        NodeList nList = doc.getElementsByTagName("room");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                int size = Integer.parseInt(eElement.getElementsByTagName("size").item(0).getTextContent());
                int price = Integer.parseInt(eElement.getElementsByTagName("price").item(0).getTextContent());
                if(size == roomSize){
                    //System.out.println("Return from getRoomCost");
                    return price;
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    private double getSeasonMulti(Calendar day) {
        NodeList nList = doc.getElementsByTagName("season");
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                try {
                    Element eElement = (Element) nNode;
                    Calendar start = Calendar.getInstance();
                    Calendar end = Calendar.getInstance();
                    String seasonstart = eElement.getElementsByTagName("seasonstart").item(0).getTextContent();
                    String seasonend = eElement.getElementsByTagName("seasonend").item(0).getTextContent();
                    //eElement.getAttribute("id");
                    Date date = formatter.parse(seasonstart);
                    start.setTime(date);
                    date = formatter.parse(seasonend);
                    end.setTime(date);
                    //System.out.println(start.get(Calendar.MONTH)+":"+start.get(Calendar.DAY_OF_MONTH)+"|"+end.get(Calendar.MONTH)+":"+end.get(Calendar.DAY_OF_MONTH)+"|=|"+day.get(Calendar.MONTH)+":"+day.get(Calendar.DAY_OF_MONTH));
                    if(start.before(day)){
                        if(end.after(day)){
                            String multi = eElement.getElementsByTagName("seasonmulti").item(0).getTextContent();
                            return Double.parseDouble(multi);
                        }
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(ConfigReader.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return 1;
    }

}

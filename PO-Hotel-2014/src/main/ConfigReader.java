package main;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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
    static Document doc;

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

    public List<Room> loadRooms() {
        NodeList nList = doc.getElementsByTagName("room");
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        List<Room> rooms = new ArrayList<>();

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            Room room = new Room();
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                room.setID(Integer.parseInt(eElement.getElementsByTagName("id").item(0).getTextContent()));
                room.setFloor(Integer.parseInt(eElement.getElementsByTagName("floor").item(0).getTextContent()));
                room.setPrice(Integer.parseInt(eElement.getElementsByTagName("price").item(0).getTextContent()));
                room.setRoomID(eElement.getElementsByTagName("roomID").item(0).getTextContent());

                /* TODO
                NodeList bedList = eElement.getElementsByTagName("bed");
                int[] beds = new int[bedList.getLength()];
                for (int i = 0; i < bedList.getLength(); i++) {
                    Node bedNode = bedList.item(temp);
                    Element bedElement = (Element) bedNode;
                    System.out.println(bedElement);
                    beds[i] = Integer.parseInt(bedElement.getTextContent());
                }
                room.setBeds(beds);
                */

                NodeList seasonList = eElement.getElementsByTagName("season");
                List<Season> seasons = new ArrayList<>();
                for (int i = 0; i < seasonList.getLength(); i++) {
                    try {
                        Node seasonNode = seasonList.item(temp);
                        Element seasonElement = (Element) seasonNode;
                        System.out.println(seasonElement); //TODO
                        Calendar start = Calendar.getInstance();
                        Calendar end = Calendar.getInstance();
                        String seasonstart = seasonElement.getElementsByTagName("seasonstart").item(0).getTextContent();
                        String seasonend = seasonElement.getElementsByTagName("seasonend").item(0).getTextContent();
                        //seasonElement.getAttribute("id");
                        Date date = formatter.parse(seasonstart);
                        start.setTime(date);
                        date = formatter.parse(seasonend);
                        end.setTime(date);
                        int price = Integer.parseInt(seasonElement.getElementsByTagName("price").item(0).getTextContent());
                        seasons.add(new Season(start, end, price));
                    } catch (ParseException ex) {
                        Logger.getLogger(ConfigReader.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                room.setSeasons(seasons);
            }
            rooms.add(room);
        }
        return rooms;
    }

}

package main;

import java.io.File;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Konrad Welc
 */
public class XMLWriter {

    public void saveReservation(List<Reservation> reservation) {
        int ResId = 0;
        try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // root elements
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("Reservations");
            doc.appendChild(rootElement);

            // customer elements
            for (Reservation res : reservation) {
                Element reserve = doc.createElement("Reservation");
                rootElement.appendChild(reserve);

                // set attribute to customer element
                Attr attr = doc.createAttribute("id");
                attr.setValue(Integer.toString(ResId++));
                reserve.setAttributeNode(attr);

                    // shorten way
                // customer.setAttribute("id", "1");
                // firstname elements
                Element Name = doc.createElement("Name");
                Name.appendChild(doc.createTextNode(res.getCustomerName()));
                reserve.appendChild(Name);

                // lastname elements
                Element Address = doc.createElement("address");
                Address.appendChild(doc.createTextNode(res.getCustomerAddress()));
                reserve.appendChild(Address);

                // nickname elements
                Element Email = doc.createElement("Email");
                Email.appendChild(doc.createTextNode(res.getCustomerEmail()));
                reserve.appendChild(Email);

                // salary elements
                Element Start_Date = doc.createElement("Start_Date");
                Start_Date.appendChild(doc.createTextNode(res.getStartingDate().toString()));
                reserve.appendChild(Start_Date);

                Element End_Date = doc.createElement("End_Date");
                End_Date.appendChild(doc.createTextNode(res.getEndDate().toString()));
                reserve.appendChild(End_Date);

                Element Rooms = doc.createElement("Rooms");
                reserve.appendChild(Rooms);

                for (Room room : res.getRoomList()) {
                    Element Room = doc.createElement("Room");
                    End_Date.appendChild(doc.createTextNode(Integer.toString(room.getID())));
                    reserve.appendChild(Room);
                }
            }

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            File f = new File("Reservation.xml");
            if (f.exists()) {
                f.delete();
            }
            StreamResult result = new StreamResult(new File("Reservation.xml"));

		// Output to console for testing
            // StreamResult result = new StreamResult(System.out);
            transformer.transform(source, result);

            System.out.println("File saved!");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }
}

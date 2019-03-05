package poc;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Articles {

    @XmlElement(name = "article")
    public List<Article> articles;

    public Articles(){
        articles = new ArrayList<>();
    }

    public void exportArticles(String path) throws JAXBException {
        File file = new File(path);
        JAXBContext context = JAXBContext.newInstance(Articles.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.marshal(this, file);
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}

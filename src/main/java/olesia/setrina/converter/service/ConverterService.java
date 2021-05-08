package olesia.setrina.converter.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import olesia.setrina.converter.models.Summary;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class ConverterService {

    public String convert(Summary summary) throws IOException {
        ObjectMapper xmlMapper = new XmlMapper();
        xmlMapper.writeValue(new File("summary_" + summary.getName() + ".xml"), summary);
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        return xmlMapper.writeValueAsString(summary);
    }
}

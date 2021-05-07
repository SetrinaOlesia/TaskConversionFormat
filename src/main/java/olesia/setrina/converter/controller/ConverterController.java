package olesia.setrina.converter.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import olesia.setrina.converter.models.Summary;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConverterController {

    @RequestMapping(value = "/conversion", method = RequestMethod.POST, consumes = "application/json")
    public String convertJsonToXml(@RequestBody Summary summary) throws JsonProcessingException {
        ObjectMapper xmlMapper = new XmlMapper();
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        final String xml = xmlMapper.writeValueAsString(summary);
        return xml;
    }
}
